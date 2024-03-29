import java.util.ArrayList;

public interface Receipt {
    public String getReceipt();

    public double getTotalCost();
    public ArrayList<Food> getListOfFood();

    public void addFood(Food food);
}
