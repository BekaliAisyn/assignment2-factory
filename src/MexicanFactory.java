public class MexicanFactory implements CuisineFactory {
    public MainDish createMainDish() { return new Taco(); }
    public Drink createDrink() { return new Horchata(); }
    public Dessert createDessert() { return new Churros(); }
}