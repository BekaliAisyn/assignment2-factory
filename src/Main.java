public class Main {
    public static void main(String[] args) {
        CuisineFactory factory = new ItalianFactory();
        Combo combo = new Combo(factory);

        System.out.println("Cuisine: " + combo.getCuisine());
        System.out.println("Total price: " + combo.getTotalPrice());
        System.out.println("Cooking time: " + combo.getTotalCookTime() + " min");
    }
}