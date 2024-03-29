import java.util.ArrayList;

public class CustomerOrder implements Receipt{
    private ArrayList<Food> customerOrder;

    public CustomerOrder() {
        customerOrder = new ArrayList<>();
    }

    public void addFood(Food food) {
        customerOrder.add(food);
    }

    public ArrayList<Food> getListOfFood() {
        return this.customerOrder;
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

    @Override
    public double getTotalCost() {
        double totalCost = 0;
        for(Food item : customerOrder) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }
}
