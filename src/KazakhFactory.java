public class KazakhFactory implements CuisineFactory {
    public MainDish createMainDish() { return new Beshbarmak(); }
    public Drink createDrink() { return new Kumis(); }
    public Dessert createDessert() { return new ChakChak(); }
}