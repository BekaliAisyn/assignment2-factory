public class JapaneseFactory implements CuisineFactory {
    public MainDish createMainDish() { return new Sushi(); }
    public Drink createDrink() { return new GreenTea(); }
    public Dessert createDessert() { return new Mochi(); }
}