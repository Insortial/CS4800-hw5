public class FoodWithMustard implements Food{
    private double totalCost;

    private double toppingCost;

    private boolean hadTopping;

    private String mealDescription;
    public FoodWithMustard(Food food)
    {
        this.totalCost = food.getPrice();
        this.mealDescription = food.getDescription();
        this.hadTopping = food.hasToppings();
        this.toppingCost = 0.45;
    }

    @Override
    public double getPrice() {
        return this.totalCost + this.toppingCost;
    }

    @Override
    public String getDescription() {
        String finishedDescription = this.mealDescription;
        if(!this.hadTopping) {
            finishedDescription += " w/ Mustard";
        } else {
            finishedDescription += ", Mustard";
        }
        return finishedDescription;
    }

    @Override
    public Boolean hasToppings() {
        return true;
    }
}
