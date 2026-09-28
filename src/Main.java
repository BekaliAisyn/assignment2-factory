public class Main {
    public static void main(String[] args) {
        String cuisine = "ITALIAN";
        Restaurant restaurant;

        if (cuisine.equals("ITALIAN")) {
            restaurant = new ItalianRestaurant();
        } else if (cuisine.equals("JAPANESE")) {
            restaurant = new JapaneseRestaurant();
        } else {
            restaurant = new KazakhRestaurant();
        }

        System.out.println(restaurant.serveMainDish());
    }
}