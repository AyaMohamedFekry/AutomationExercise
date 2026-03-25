package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {

    WebDriver driver;

    public PaymentPage(WebDriver driver)
    {
        this.driver = driver;
    }

    By getName = By.cssSelector("input[data-qa=\"name-on-card\"]");
    By getCardNumber = By.cssSelector("input[data-qa=\"card-number\"]");
    By getCVC = By.cssSelector("input[data-qa=\"cvc\"]");
    By getMonthExpiration = By.cssSelector("input[data-qa=\"expiry-month\"]");
    By getYearExpiration = By.cssSelector("input[data-qa=\"expiry-year\"]");
    By payAndConfirmOrderButton = By.id("submit");

    By verifyOrderIsPlaced = By.cssSelector("h2[data-qa=\"order-placed\"]");

    public void paymentProcess(String name , String cardNumber , String cvc , String month , String year)
    {
        driver.findElement(getName).sendKeys(name);
        driver.findElement(getCardNumber).sendKeys(cardNumber);
        driver.findElement(getCVC).sendKeys(cvc);
        driver.findElement(getMonthExpiration).sendKeys(month);
        driver.findElement(getYearExpiration).sendKeys(year);
        driver.findElement(payAndConfirmOrderButton).click();
    }

    public String verifyOrderIsPlaced()
    {
        return driver.findElement(verifyOrderIsPlaced).getText();
    }
    public String getValidationMessage(By locator)
    {
        return driver.findElement(locator).getAttribute("validationMessage");
    }
    public String getNameOnCardValidationMessage()
    {
        return getValidationMessage(getName);
    }

    public String getCardNumberValidationMessage()
    {
        return getValidationMessage(getCardNumber);
    }

    public String getCVCValidationMessage()
    {
        return getValidationMessage(getCVC);
    }

    public String getExpiryMonthValidationMessage()
    {
        return getValidationMessage(getMonthExpiration);
    }

    public String getExpiryYearValidationMessage()
    {
        return getValidationMessage(getYearExpiration);
    }

}
