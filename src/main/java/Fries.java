import java.math.BigDecimal;

public class Fries implements Food{
    @Override
    public double getPrice() {
        return 2;
    }

    @Override
    public String getDescription() {
        return "Fries";
    }

    @Override
    public Boolean hasToppings() {
        return false;
    }
}
