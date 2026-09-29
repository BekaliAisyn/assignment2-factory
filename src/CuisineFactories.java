import java.util.HashMap;
import java.util.Map;

public class CuisineFactories {
    private static final Map<Cuisine, CuisineFactory> FACTORIES = new HashMap<>();

    static {
        FACTORIES.put(Cuisine.ITALIAN, new ItalianFactory());
        FACTORIES.put(Cuisine.JAPANESE, new JapaneseFactory());
        FACTORIES.put(Cuisine.KAZAKH, new KazakhFactory());
    }

    public static CuisineFactory forCuisine(Cuisine cuisine) {
        CuisineFactory factory = FACTORIES.get(cuisine);
        if (factory == null) {
            throw new IllegalArgumentException("No factory for cuisine: " + cuisine);
        }
        return factory;
    }
}