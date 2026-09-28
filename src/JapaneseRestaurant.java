public class JapaneseRestaurant extends Restaurant {
    @Override
    protected MainDish createMainDish() {
        return new Sushi();
    }
}