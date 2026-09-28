public class Sushi implements MainDish {
    public String getName() { return "Sushi"; }
    public double getPrice() { return 15.0; }
    public int getCookTime() { return 20; }
    public Cuisine getCuisine() { return Cuisine.JAPANESE; }
}