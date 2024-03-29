public class FoodWithCheese implements Food{
    private double totalCost;

    private double toppingCost;

    private boolean hadTopping;

    private String mealDescription;
    public FoodWithCheese(Food food)
    {
        this.totalCost = food.getPrice();
        this.mealDescription = food.getDescription();
        this.hadTopping = food.hasToppings();
        this.toppingCost = 1;
    }

    @Override
    public double getPrice() {
        return this.totalCost + this.toppingCost;
    }

    @Override
    public String getDescription() {
        String finishedDescription = this.mealDescription;
        if(!this.hadTopping) {
            finishedDescription += " w/ Cheese";
        } else {
            finishedDescription += ", Cheese";
        }
        return finishedDescription;
    }

    @Override
    public Boolean hasToppings() {
        return true;
    }
}
