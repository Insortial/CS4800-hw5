import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ReceiptTest {
    @Test
    public void testGetTotalCostWithoutDiscount() {
        Receipt customerOrder = new CustomerOrder();
        //Total cost of fries with Ketchup and burger with ketchup and cheese: $7.99
        double expectedTotalCost = 7.99;

        Food friesWithKetchup = new FoodWithKetchup(new Fries());
        Food burgerWithKetchupAndCheese = new FoodWithCheese(new FoodWithKetchup(new Burger()));
        customerOrder.addFood(friesWithKetchup);
        customerOrder.addFood(burgerWithKetchupAndCheese);

        assertEquals(expectedTotalCost, customerOrder.getTotalCost());
    }

    @Test
    public void testGetReceiptWithoutDiscount() {
        Receipt customerOrder = new CustomerOrder();
        //Receipt of fries with Ketchup and burger with ketchup and cheese: $7.99
        String expectedReceipt = "List Of Items:\nFries w/ Ketchup: 2.5\nBurger w/ Ketchup, Cheese: 5.49\n\nTotal Cost: 7.99";

        Food friesWithKetchup = new FoodWithKetchup(new Fries());
        Food burgerWithKetchupAndCheese = new FoodWithCheese(new FoodWithKetchup(new Burger()));
        customerOrder.addFood(friesWithKetchup);
        customerOrder.addFood(burgerWithKetchupAndCheese);

        assertEquals(expectedReceipt, customerOrder.getReceipt());
    }

    @ParameterizedTest
    @EnumSource(value = OrderWithLoyaltyStatus.LoyaltyStatus.class, names = {"NEWCUSTOMER", "FREQUENT", "LOYAL"})
    public void testGetTotalCostWithDiscount(OrderWithLoyaltyStatus.LoyaltyStatus status) {
        Receipt customerOrder = new CustomerOrder();
        //Total cost of fries with Ketchup and burger with ketchup and cheese with: $7.99
        double expectedTotalCostNewCustomer = 7.99;
        double expectedTotalCostFrequentCustomer = 7.99 * 0.8;
        double expectedTotalCostLoyalCustomer = 7.99 * 0.7;


        Food friesWithKetchup = new FoodWithKetchup(new Fries());
        Food burgerWithKetchupAndCheese = new FoodWithCheese(new FoodWithKetchup(new Burger()));
        customerOrder.addFood(friesWithKetchup);
        customerOrder.addFood(burgerWithKetchupAndCheese);
        customerOrder = new OrderWithLoyaltyStatus(customerOrder, status);

        switch (status) {
            case NEWCUSTOMER:
                assertEquals(expectedTotalCostNewCustomer, customerOrder.getTotalCost());
                break;
            case FREQUENT:
                assertEquals(expectedTotalCostFrequentCustomer, customerOrder.getTotalCost());
                break;
            case LOYAL:
                assertEquals(expectedTotalCostLoyalCustomer, customerOrder.getTotalCost());
                break;
        }
    }

    @ParameterizedTest
    @EnumSource(value = OrderWithLoyaltyStatus.LoyaltyStatus.class, names = {"NEWCUSTOMER", "FREQUENT", "LOYAL"})
    public void testGetReceiptWithDiscount(OrderWithLoyaltyStatus.LoyaltyStatus status) {
        Receipt customerOrder = new CustomerOrder();
        //Total cost of fries with Ketchup and burger with ketchup and cheese with: $7.99
        double expectedTotalCostNewCustomer = 7.99;
        double expectedTotalCostFrequentCustomer = 7.99 * 0.8;
        double expectedTotalCostLoyalCustomer = 7.99 * 0.7;
        String expectedReceipt = "List Of Items:\nFries w/ Ketchup: 2.5\nBurger w/ Ketchup, Cheese: 5.49\n\nTotal Cost: ";


        Food friesWithKetchup = new FoodWithKetchup(new Fries());
        Food burgerWithKetchupAndCheese = new FoodWithCheese(new FoodWithKetchup(new Burger()));
        customerOrder.addFood(friesWithKetchup);
        customerOrder.addFood(burgerWithKetchupAndCheese);
        customerOrder = new OrderWithLoyaltyStatus(customerOrder, status);

        switch (status) {
            case NEWCUSTOMER:
                expectedReceipt += expectedTotalCostNewCustomer;
                break;
            case FREQUENT:
                expectedReceipt += expectedTotalCostFrequentCustomer;
                break;
            case LOYAL:
                expectedReceipt += expectedTotalCostLoyalCustomer;
                break;
        }

        assertEquals(expectedReceipt, customerOrder.getReceipt());
    }
}
