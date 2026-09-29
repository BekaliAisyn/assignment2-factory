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

    public int getReadyTime() {
        return Math.max(mainDish.getCookTime(),
                Math.max(drink.getCookTime(), dessert.getCookTime()));
    }

    public String describe() {
        return mainDish.getName() + " + " + drink.getName() + " + " + dessert.getName();
    }

    public Cuisine getCuisine() {
        return mainDish.getCuisine();
    }
}