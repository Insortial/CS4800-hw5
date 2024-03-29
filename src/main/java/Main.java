public class Main {
    public static void main(String args[]) {
        Receipt customerOrder = new CustomerOrder();

        Food friesWithKetchup = new FoodWithKetchup(new Fries());
        Food burgerWithKetchupAndCheese = new FoodWithCheese(new FoodWithKetchup(new Burger()));
        customerOrder.addFood(friesWithKetchup);
        customerOrder.addFood(burgerWithKetchupAndCheese);

        System.out.println("Without Loyalty Discount");
        System.out.println(customerOrder.getReceipt());

        customerOrder = new OrderWithLoyaltyStatus(customerOrder, OrderWithLoyaltyStatus.LoyaltyStatus.LOYAL);

        System.out.println("\nWith Loyalty Discount");
        System.out.println(customerOrder.getReceipt());


    }
}
