Assignment 2: Factory Method and Abstract Factory
Domain: Restaurant Combo Meal

Domain description

The system creates a combo meal for a restaurant. A combo has 3 product types: MainDish, Drink and Dessert. There are 3 product families (cuisines): Italian, Japanese and Kazakh. So there are 9 concrete products.

Italian: Pizza, Espresso, Tiramisu
Japanese: Sushi, GreenTea, Mochi
Kazakh: Beshbarmak, Kumis, ChakChak

Products from different cuisines should not be mixed in one combo, so the client should not create concrete classes directly.

Part A: Problems without factories

Problem 1: Client depends on concrete classes
Main knows about Pizza, Espresso, Sushi, Kumis and all other classes. If I rename or change one class, I must change Main too.

Problem 2: Big if/else and new family needs code change
Main has if/else for every cuisine. If I want to add new cuisine, I must open Main and add one more else if. This is easy to forget and breaks old code.

Problem 3: Wrong products can be mixed
Nothing stops me to make Pizza with Kumis and Mochi. It is wrong combo from different cuisines, but Java does not show any error.

Problem 4: Duplicated code
Each branch repeats the same price and time calculation. If I change the formula, I must change it in three places.

Part B: Factory Method

Restaurant is the Creator. It has abstract method createMainDish(). Each concrete restaurant (ItalianRestaurant, JapaneseRestaurant, KazakhRestaurant) decides which dish to create.

Restaurant also has real business logic in serveMainDish(): it adds 10 percent service fee and 5 minutes waiting time. This logic is the same for all restaurants and works only with MainDish interface.

Why it is Factory Method and not static factory: in Factory Method the creation is decided by subclasses through inheritance, and the parent class uses the product in its own logic. A static factory is one method with if/else inside, and adding a new cuisine means changing that method. Here I only add a new subclass.
Part C: Abstract Factory

CuisineFactory is the Abstract Factory. It has three methods: createMainDish(), createDrink() and createDessert(). ItalianFactory, JapaneseFactory and KazakhFactory each create products from one cuisine only. So every factory makes a compatible family of products.

Part D: Compatibility rule

Combo class has only one constructor and it takes CuisineFactory. It does not take dish, drink and dessert separately. So it is impossible to make Combo with Pizza, Kumis and Mochi. The design itself prevents the wrong combination, I do not need if and throw for this. Every product also has getCuisine() method, so tests can check that all three products in Combo have the same cuisine.
Part E: Runtime factory selection

The cuisine comes from command-line argument, for example cuisine=JAPANESE. Main reads this argument and asks CuisineFactories to give the right factory. The line new ItalianFactory() exists only one time, inside CuisineFactories. After that, OrderService gets only CuisineFactory interface and does not know which cuisine is used.

Part F: Business scenario

OrderService has three operations and they all use Combo, which has MainDish, Drink and Dessert together.
1. calculateBill(guests): price of all combos, with 10 percent discount for 4 or more guests.
2. estimateReadyTime(): kitchen cooks dish, drink and dessert at the same time, so ready time is the longest cook time of the three.
3. createReceipt(guests): receipt with cuisine, names of all three products, bill and ready time.

Part I: Tests

I wrote 16 tests with JUnit. They check:
1-3. Each cuisine factory creates the correct combo (Italian, Japanese, Kazakh).
4-6. Each concrete factory creates the correct concrete product type (instanceof check).
7-8. All products inside one combo have the same cuisine (compatibility check).
9-10. Runtime factory selection works, and throws exception for unknown cuisine.
11-13. Business logic: bill for one guest, discount for 4+ guests, exception for zero guests.
14. Ready time equals the longest cook time among the three products.
    15-16. Receipt contains correct data, and client code works only through CuisineFactory and OrderService, never touching concrete product classes directly.

Part H: UML diagram

Diagram is in docs/factory-uml.png. It shows two labeled parts: Factory method part (Restaurant creator with 3 concrete creators, all working with MainDish) and Abstract factory part (CuisineFactory with 3 concrete factories, creating all three product types). Both parts connect down to the shared product interfaces MainDish, Drink and Dessert, each having 3 concrete classes.
Part G: Adding a fourth product family (Mexican)

Files I created:
1. Taco.java (new MainDish)
2. Horchata.java (new Drink)
3. Churros.java (new Dessert)
4. MexicanFactory.java (new concrete factory)

Files I changed:
1. Cuisine.java - added MEXICAN to the enum
2. CuisineFactories.java - added one line to register MexicanFactory

Files I did NOT change:
Combo.java, OrderService.java, Main.java, CuisineFactory.java interface, and all Factory Method classes (Restaurant and its subclasses) stayed exactly the same.

This shows the Open/Closed Principle: I added new behavior by creating new classes, without modifying the existing tested code for Italian, Japanese and Kazakh cuisines. Only 2 existing files needed a one-line change each, and both are configuration, not business logic.