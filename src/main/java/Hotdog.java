import java.math.BigDecimal;

public class Hotdog implements Food{
    @Override
    public double getPrice() {
        return 2.70;
    }

    @Override
    public String getDescription() {
        return "Hotdog";
    }

    @Override
    public Boolean hasToppings() {
        return false;
    }
}
