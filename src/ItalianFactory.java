public class ItalianFactory implements CuisineFactory {
    public MainDish createMainDish() { return new Pizza(); }
    public Drink createDrink() { return new Espresso(); }
    public Dessert createDessert() { return new Tiramisu(); }
}