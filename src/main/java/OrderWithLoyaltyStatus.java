import java.util.ArrayList;

public class OrderWithLoyaltyStatus implements Receipt{
    private ArrayList<Food> customerOrder;
    private LoyaltyStatus loyalty;
    enum LoyaltyStatus {
        NEWCUSTOMER,
        FREQUENT,
        LOYAL
    }

    public OrderWithLoyaltyStatus(Receipt order, LoyaltyStatus loyalty)
    {
        this.customerOrder = order.getListOfFood();
        this.loyalty = loyalty;
    }

    @Override
    public ArrayList<Food> getListOfFood() {
        return this.customerOrder;
    }

    @Override
    public double getTotalCost() {
        double totalCost = 0;
        double discount = 1;
        for(Food item : customerOrder) {
            totalCost += item.getPrice();
        }

        switch (this.loyalty) {
            case NEWCUSTOMER:
                break;
            case FREQUENT:
                discount = 0.8; //20% discount for frequent customers
                break;
            case LOYAL:
                discount = 0.7; //30% discount for loyal customers
                break;
        }

        return totalCost * discount;
    }

    @Override
    public void addFood(Food food) {
        customerOrder.add(food);
    }


    @Override
    public String getReceipt() {
        String receiptString = "List Of Items:";
        for(Food item : customerOrder) {
            receiptString += "\n" + item.getDescription() + ": " + item.getPrice();
        }
        receiptString += "\n\nTotal Cost: " + this.getTotalCost();
        return receiptString;
    }
}
