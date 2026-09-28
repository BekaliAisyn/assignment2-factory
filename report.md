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