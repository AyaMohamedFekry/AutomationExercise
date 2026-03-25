package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutAndDeleteAccountPage {

    WebDriver driver;

    public LogoutAndDeleteAccountPage(WebDriver driver)
    {
        this.driver = driver;
    }

    By logoutLink = By.linkText("Logout");
    By deleteAccountLink = By.linkText("Delete Account");
    By continueButton = By.cssSelector("a[data-qa=\"continue-button\"]");
    public void logout()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(logoutLink)));
        driver.findElement(logoutLink).click();
    }

    public void deleteAccount()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(deleteAccountLink)));
        driver.findElement(deleteAccountLink).click();
        driver.findElement(continueButton).click();
    }


}
