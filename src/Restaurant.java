public abstract class Restaurant {

    protected abstract MainDish createMainDish();

    public String serveMainDish() {
        MainDish dish = createMainDish();
        double priceWithService = Math.round(dish.getPrice() * 1.10 * 100) / 100.0;
        int waitTime = dish.getCookTime() + 5;
        return dish.getName() + ": price " + priceWithService
                + ", ready in " + waitTime + " min";
    }
}