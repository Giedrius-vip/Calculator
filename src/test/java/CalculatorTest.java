
import lt.techin.CalculatorPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest extends BaseTest {

    private CalculatorPage calculatorPage;

    @BeforeAll
    public void setUp() {
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.navigateToCalculatorPage();
    }

    @BeforeEach
    public void beforeEachTest() {
        driver.navigate().refresh();
    }

    @Test
    public void testPositiveAddition() {
        calculatorPage.enterFirstNumber("5");
        calculatorPage.enterSecondNumber("3");
        calculatorPage.selectFunction("plus");
        calculatorPage.clickCalculate();
        assertEquals("8", calculatorPage.getResult());
    }

    @Test
    public void testPositiveSubtraction() {
        calculatorPage.enterFirstNumber("10");
        calculatorPage.enterSecondNumber("4");
        calculatorPage.selectFunction("minus");
        calculatorPage.clickCalculate();
        assertEquals("6", calculatorPage.getResult());
    }

    @Test
    public void testDivideByZero() {
        calculatorPage.enterFirstNumber("10");
        calculatorPage.enterSecondNumber("0");
        calculatorPage.selectFunction("divide");
        calculatorPage.clickCalculate();
        assertEquals("0", calculatorPage.getResult());
    }

    @Test
    public void testNegativeInput() {
        calculatorPage.enterFirstNumber("-5");
        calculatorPage.enterSecondNumber("-3");
        calculatorPage.selectFunction("plus");
        calculatorPage.clickCalculate();
        assertEquals("-8", calculatorPage.getResult());
    }

    @Test
    public void testMissingSecondNumber() {
        calculatorPage.enterFirstNumber("5");
        calculatorPage.enterSecondNumber("");
        calculatorPage.selectFunction("times");
        calculatorPage.clickCalculate();
        assertEquals("ERR", calculatorPage.getResult());
    }
}
