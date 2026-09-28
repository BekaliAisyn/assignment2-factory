public class Main {
    public static void main(String[] args) {
        String cuisine = "ITALIAN";
        double total = 0;
        int time = 0;

        if (cuisine.equals("ITALIAN")) {
            Pizza dish = new Pizza();
            Espresso drink = new Espresso();
            Tiramisu dessert = new Tiramisu();
            total = dish.getPrice() + drink.getPrice() + dessert.getPrice();
            time = dish.getCookTime() + drink.getCookTime() + dessert.getCookTime();
        } else if (cuisine.equals("JAPANESE")) {
            Sushi dish = new Sushi();
            GreenTea drink = new GreenTea();
            Mochi dessert = new Mochi();
            total = dish.getPrice() + drink.getPrice() + dessert.getPrice();
            time = dish.getCookTime() + drink.getCookTime() + dessert.getCookTime();
        } else if (cuisine.equals("KAZAKH")) {
            Beshbarmak dish = new Beshbarmak();
            Kumis drink = new Kumis();
            ChakChak dessert = new ChakChak();
            total = dish.getPrice() + drink.getPrice() + dessert.getPrice();
            time = dish.getCookTime() + drink.getCookTime() + dessert.getCookTime();
        }

        System.out.println("Cuisine: " + cuisine);
        System.out.println("Total price: " + total);
        System.out.println("Cooking time: " + time + " min");

        Pizza badDish = new Pizza();
        Kumis badDrink = new Kumis();
        Mochi badDessert = new Mochi();
        System.out.println("Mixed combo price: "
                + (badDish.getPrice() + badDrink.getPrice() + badDessert.getPrice()));
    }
}