public class Pizza implements MainDish {
    public String getName() { return "Pizza"; }
    public double getPrice() { return 12.0; }
    public int getCookTime() { return 15; }
    public Cuisine getCuisine() { return Cuisine.ITALIAN; }
}