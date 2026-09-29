import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    void italianComboHasCorrectProducts() {
        Combo combo = new Combo(new ItalianFactory());
        assertEquals("Pizza + Espresso + Tiramisu", combo.describe());
    }

    @Test
    void japaneseComboHasCorrectProducts() {
        Combo combo = new Combo(new JapaneseFactory());
        assertEquals("Sushi + GreenTea + Mochi", combo.describe());
    }

    @Test
    void kazakhComboHasCorrectProducts() {
        Combo combo = new Combo(new KazakhFactory());
        assertEquals("Beshbarmak + Kumis + ChakChak", combo.describe());
    }

    @Test
    void italianFactoryCreatesItalianMainDish() {
        CuisineFactory factory = new ItalianFactory();
        assertTrue(factory.createMainDish() instanceof Pizza);
    }

    @Test
    void japaneseFactoryCreatesJapaneseDrink() {
        CuisineFactory factory = new JapaneseFactory();
        assertTrue(factory.createDrink() instanceof GreenTea);
    }

    @Test
    void kazakhFactoryCreatesKazakhDessert() {
        CuisineFactory factory = new KazakhFactory();
        assertTrue(factory.createDessert() instanceof ChakChak);
    }

    @Test
    void allProductsInComboHaveSameCuisine() {
        Combo combo = new Combo(new ItalianFactory());
        assertEquals(Cuisine.ITALIAN, combo.getCuisine());
    }

    @Test
    void allProductsInJapaneseComboHaveSameCuisine() {
        CuisineFactory factory = new JapaneseFactory();
        Cuisine dishCuisine = factory.createMainDish().getCuisine();
        Cuisine drinkCuisine = factory.createDrink().getCuisine();
        Cuisine dessertCuisine = factory.createDessert().getCuisine();
        assertEquals(dishCuisine, drinkCuisine);
        assertEquals(drinkCuisine, dessertCuisine);
    }

    @Test
    void runtimeSelectionReturnsCorrectFactory() {
        CuisineFactory factory = CuisineFactories.forCuisine(Cuisine.JAPANESE);
        assertTrue(factory instanceof JapaneseFactory);
    }

    @Test
    void runtimeSelectionForUnknownCuisineThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            CuisineFactories.forCuisine(null);
        });
    }

    @Test
    void calculateBillForOneGuestIsCorrect() {
        OrderService service = new OrderService(new ItalianFactory());
        assertEquals(21.0, service.calculateBill(1));
    }

    @Test
    void calculateBillAppliesDiscountForFourGuests() {
        OrderService service = new OrderService(new ItalianFactory());
        double fullPrice = 21.0 * 4;
        double expected = Math.round(fullPrice * 0.9 * 100) / 100.0;
        assertEquals(expected, service.calculateBill(4));
    }

    @Test
    void calculateBillWithZeroGuestsThrowsException() {
        OrderService service = new OrderService(new ItalianFactory());
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateBill(0);
        });
    }

    @Test
    void estimateReadyTimeIsLongestCookTime() {
        OrderService service = new OrderService(new KazakhFactory());
        assertEquals(40, service.estimateReadyTime());
    }

    @Test
    void createReceiptContainsCuisineAndBill() {
        OrderService service = new OrderService(new JapaneseFactory());
        String receipt = service.createReceipt(2);
        assertTrue(receipt.contains("JAPANESE"));
        assertTrue(receipt.contains("Bill:"));
    }

    @Test
    void clientWorksThroughAbstractionsOnly() {
        CuisineFactory factory = CuisineFactories.forCuisine(Cuisine.ITALIAN);
        OrderService service = new OrderService(factory);
        assertDoesNotThrow(() -> service.createReceipt(3));
    }
}