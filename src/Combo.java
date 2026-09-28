public class Combo {
    private final MainDish mainDish;
    private final Drink drink;
    private final Dessert dessert;

    public Combo(CuisineFactory factory) {
        this.mainDish = factory.createMainDish();
        this.drink = factory.createDrink();
        this.dessert = factory.createDessert();
    }

    public double getTotalPrice() {
        return mainDish.getPrice() + drink.getPrice() + dessert.getPrice();
    }

    public int getTotalCookTime() {
        return mainDish.getCookTime() + drink.getCookTime() + dessert.getCookTime();
    }

    public Cuisine getCuisine() {
        return mainDish.getCuisine();
    }
}