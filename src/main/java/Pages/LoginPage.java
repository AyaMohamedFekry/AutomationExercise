package Pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {


    WebDriver driver ;
    By loginLink = By.cssSelector("a[href=\"/login\"]");
    //Login
    By getEmailAdress = By.cssSelector("input[data-qa=\"login-email\"]");
    By getPassword = By.cssSelector("input[data-qa=\"login-password\"]");
    By loginbutton = By.cssSelector("button[data-qa=\"login-button\"]");

    //Verify Error message
    By getErrorMessage = By.cssSelector("p[style=\"color: red;\"]");

    public LoginPage(WebDriver driver)
    {

        this.driver = driver;
    }
    public void moveToLoginPage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loginLink))).click();
    }
    public void login(String email , String password)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(getEmailAdress)));
        driver.findElement(getEmailAdress).sendKeys(email);
        driver.findElement(getPassword).sendKeys(password);
        driver.findElement(loginbutton).click();
    }
    public String checkIsLoggedIn()
    {
        return driver.getCurrentUrl();
    }

    public String verifyErrorMessage()
    {
        return driver.findElement(getErrorMessage).getText();
    }
}
