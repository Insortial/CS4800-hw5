import java.math.BigDecimal;

public class Burger implements Food{
    @Override
    public double getPrice() {
        return 3.99;
    }

    @Override
    public String getDescription() {
        return "Burger";
    }

    @Override
    public Boolean hasToppings() {
        return false;
    }
}
