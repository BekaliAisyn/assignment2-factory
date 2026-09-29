public class Taco implements MainDish {
    public String getName() { return "Taco"; }
    public double getPrice() { return 9.0; }
    public int getCookTime() { return 10; }
    public Cuisine getCuisine() { return Cuisine.MEXICAN; }
}