public class ItalianRestaurant extends Restaurant {
    @Override
    protected MainDish createMainDish() {
        return new Pizza();
    }
}