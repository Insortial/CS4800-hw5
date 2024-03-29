public class FoodWithKetchup implements Food{
    private double totalCost;

    private double toppingCost;

    private boolean hadTopping;

    private String mealDescription;
    public FoodWithKetchup(Food food)
    {
        this.totalCost = food.getPrice();
        this.mealDescription = food.getDescription();
        this.hadTopping = food.hasToppings();
        this.toppingCost = 0.50;
    }

    @Override
    public double getPrice() {
        return this.totalCost + this.toppingCost;
    }

    @Override
    public String getDescription() {
        String finishedDescription = this.mealDescription;
        if(!this.hadTopping) {
            finishedDescription += " w/ Ketchup";
        } else {
            finishedDescription += ", Ketchup";
        }
        return finishedDescription;
    }

    @Override
    public Boolean hasToppings() {
        return true;
    }
}
