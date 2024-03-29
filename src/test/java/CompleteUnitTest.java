import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CompleteUnitTest.class, FoodTest.class, ReceiptTest.class})
public class CompleteUnitTest {
}
