import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodTest {
    @Test
    public void testGetPriceWithoutToppings() {
        double expectedBurgerPrice = 3.99;
        double expectedFriesPrice = 2;
        double expectedHotdogPrice = 2.7;

        Food burger = new Burger();
        Food fries = new Fries();
        Food hotdog = new Hotdog();

        assertEquals(expectedBurgerPrice, burger.getPrice());
        assertEquals(expectedFriesPrice, fries.getPrice());
        assertEquals(expectedHotdogPrice, hotdog.getPrice());
    }

    @Test
    public void testGetDescriptionWithoutToppings() {
        String expectedBurgerName = "Burger";
        String expectedFriesName = "Fries";
        String expectedHotdogName = "Hotdog";

        Food burger = new Burger();
        Food fries = new Fries();
        Food hotdog = new Hotdog();

        assertEquals(expectedBurgerName, burger.getDescription());
        assertEquals(expectedFriesName, fries.getDescription());
        assertEquals(expectedHotdogName, hotdog.getDescription());
    }

    @Test
    public void testHasToppingsWithoutToppings() {
        boolean expectedBurgerToppingResult = false;
        boolean expectedFriesToppingResult = false;
        boolean expectedHotdogToppingResult = false;

        Food burger = new Burger();
        Food fries = new Fries();
        Food hotdog = new Hotdog();

        assertEquals(expectedBurgerToppingResult, burger.hasToppings());
        assertEquals(expectedFriesToppingResult, fries.hasToppings());
        assertEquals(expectedHotdogToppingResult, hotdog.hasToppings());
    }

    @Test
    public void testGetPriceWithKetchup() {
        double expectedBurgerPriceWithKetchup = 4.49;
        double expectedFriesPriceWithKetchup = 2.50;
        double expectedHotdogPriceWithKetchup = 3.20;

        Food burger = new Burger();
        Food fries = new Fries();
        Food hotdog = new Hotdog();

        Food burgerWithKetchup = new FoodWithKetchup(burger);
        Food friesWithKetchup = new FoodWithKetchup(fries);
        Food hotdogWithKetchup = new FoodWithKetchup(hotdog);

        assertEquals(expectedBurgerPriceWithKetchup, burgerWithKetchup.getPrice());
        assertEquals(expectedFriesPriceWithKetchup, friesWithKetchup.getPrice());
        assertEquals(expectedHotdogPriceWithKetchup, hotdogWithKetchup.getPrice());
    }

    @Test
    public void testGetDescriptionWithKetchup() {
        String expectedBurgerDescriptionWithKetchup = "Burger w/ Ketchup";
        String expectedFriesDescriptionWithKetchup = "Fries w/ Ketchup";
        String expectedHotdogDescriptionWithKetchup = "Hotdog w/ Ketchup";

        Food burger = new Burger();
        Food fries = new Fries();
        Food hotdog = new Hotdog();

        Food burgerWithKetchup = new FoodWithKetchup(burger);
        Food friesWithKetchup = new FoodWithKetchup(fries);
        Food hotdogWithKetchup = new FoodWithKetchup(hotdog);

        assertEquals(expectedBurgerDescriptionWithKetchup, burgerWithKetchup.getDescription());
        assertEquals(expectedFriesDescriptionWithKetchup, friesWithKetchup.getDescription());
        assertEquals(expectedHotdogDescriptionWithKetchup, hotdogWithKetchup.getDescription());
    }

    @Test
    public void testHasToppingWithKetchup() {
        boolean expectedBurgerToppingWithKetchup = true;
        boolean expectedFriesToppingWithKetchup = true;
        boolean expectedHotdogToppingWithKetchup = true;

        Food burger = new Burger();
        Food fries = new Fries();
        Food hotdog = new Hotdog();

        Food burgerWithKetchup = new FoodWithKetchup(burger);
        Food friesWithKetchup = new FoodWithKetchup(fries);
        Food hotdogWithKetchup = new FoodWithKetchup(hotdog);

        assertEquals(expectedBurgerToppingWithKetchup, burgerWithKetchup.hasToppings());
        assertEquals(expectedFriesToppingWithKetchup, friesWithKetchup.hasToppings());
        assertEquals(expectedHotdogToppingWithKetchup, hotdogWithKetchup.hasToppings());
    }

    @Test
    public void testGetPriceWithAllToppings() {
        //Combined cost of toppings is 1.95 Ketchup: 0.50 Mustard: 0.45 Cheese:1.00
        double expectedBurgerPriceWithAllToppings = 5.94;
        double expectedFriesPriceWithAllToppings = 3.95;
        double expectedHotdogPriceWithAllToppings = 4.65;

        Food burger = new Burger();
        Food fries = new Fries();
        Food hotdog = new Hotdog();

        Food burgerWithAllToppings = new FoodWithCheese(new FoodWithMustard(new FoodWithKetchup(burger)));
        Food friesWithAllToppings = new FoodWithCheese(new FoodWithMustard(new FoodWithKetchup(fries)));
        Food hotdogWithAllToppings = new FoodWithCheese(new FoodWithMustard(new FoodWithKetchup(hotdog)));

        assertEquals(expectedBurgerPriceWithAllToppings, burgerWithAllToppings.getPrice());
        assertEquals(expectedFriesPriceWithAllToppings, friesWithAllToppings.getPrice());
        assertEquals(expectedHotdogPriceWithAllToppings, hotdogWithAllToppings.getPrice());
    }

    @Test
    public void testGetDescriptionWithAllToppings() {
        String expectedBurgerDescriptionWithAllToppings = "Burger w/ Ketchup, Mustard, Cheese";
        String expectedFriesDescriptionWithAllToppings = "Fries w/ Ketchup, Mustard, Cheese";
        String expectedHotdogDescriptionWithAllToppings = "Hotdog w/ Ketchup, Mustard, Cheese";

        Food burger = new Burger();
        Food fries = new Fries();
        Food hotdog = new Hotdog();

        Food burgerWithAllToppings = new FoodWithCheese(new FoodWithMustard(new FoodWithKetchup(burger)));
        Food friesWithAllToppings = new FoodWithCheese(new FoodWithMustard(new FoodWithKetchup(fries)));
        Food hotdogWithAllToppings = new FoodWithCheese(new FoodWithMustard(new FoodWithKetchup(hotdog)));

        assertEquals(expectedBurgerDescriptionWithAllToppings, burgerWithAllToppings.getDescription());
        assertEquals(expectedFriesDescriptionWithAllToppings, friesWithAllToppings.getDescription());
        assertEquals(expectedHotdogDescriptionWithAllToppings, hotdogWithAllToppings.getDescription());
    }
}
