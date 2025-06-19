package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage {
    private final WebDriver driver;

    private final By number1Field = By.id("number1");
    private final By number2Field = By.id("number2");
    private final By functionDropdown = By.id("function");
    private final By calculateButton = By.id("calculate");
    private final By answerField = By.id("answer");

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCalculatorPage() {
        driver.get("https://testpages.eviltester.com/styled/calculator");
    }

    public void enterFirstNumber(String number) {
        driver.findElement(number1Field).clear();
        driver.findElement(number1Field).sendKeys(number);
    }

    public void enterSecondNumber(String number) {
        driver.findElement(number2Field).clear();
        driver.findElement(number2Field).sendKeys(number);
    }

    public void selectFunction(String operation) {
        Select dropdown = new Select(driver.findElement(functionDropdown));
        dropdown.selectByValue(operation);
    }

    public void clickCalculate() {
        driver.findElement(calculateButton).click();
    }

    public String getResult() {
        return driver.findElement(answerField).getText();
    }
}
