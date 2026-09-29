public class OrderService {
    private final CuisineFactory factory;

    public OrderService(CuisineFactory factory) {
        this.factory = factory;
    }

    public double calculateBill(int guests) {
        if (guests <= 0) {
            throw new IllegalArgumentException("Guests must be greater than 0");
        }
        double sum = 0;
        for (int i = 0; i < guests; i++) {
            sum += new Combo(factory).getTotalPrice();
        }
        if (guests >= 4) {
            sum = sum * 0.9;
        }
        return Math.round(sum * 100) / 100.0;
    }

    public int estimateReadyTime() {
        return new Combo(factory).getReadyTime();
    }

    public String createReceipt(int guests) {
        Combo combo = new Combo(factory);
        return "Cuisine: " + combo.getCuisine() + "\n"
                + "Order: " + combo.describe() + "\n"
                + "Guests: " + guests + "\n"
                + "Bill: " + calculateBill(guests) + "\n"
                + "Ready in: " + estimateReadyTime() + " min";
    }
}