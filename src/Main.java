public class Main {
    public static void main(String[] args) {
        String cuisineName = "ITALIAN";
        for (String arg : args) {
            if (arg.startsWith("cuisine=")) {
                cuisineName = arg.substring("cuisine=".length());
            }
        }

        Cuisine cuisine = Cuisine.valueOf(cuisineName.toUpperCase());
        CuisineFactory factory = CuisineFactories.forCuisine(cuisine);
        OrderService service = new OrderService(factory);

        System.out.println(service.createReceipt(2));
    }
}