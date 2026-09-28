public class KazakhRestaurant extends Restaurant {
    @Override
    protected MainDish createMainDish() {
        return new Beshbarmak();
    }
}