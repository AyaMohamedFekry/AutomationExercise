package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingPage {

    WebDriver driver;

    public ShoppingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    By productLink = By.cssSelector("a[href='/products']");
    By searchInput = By.cssSelector("input[id=\"search_product\"]");
    By submitSearch = By.cssSelector("button[id=\"submit_search\"]");
    By firstProduct = By.cssSelector("a[data-product-id=\"28\"]");
    By lastProduct = By.cssSelector("a[data-product-id=\"30\"]");
    By anyProduct = By.cssSelector("a[data-product-id=\"3\"]");
    By continueShoppingButton = By.cssSelector("button[class=\"btn btn-success close-modal btn-block\"]");
    By viewCartLink = By.cssSelector("a[href=\"/view_cart\"]");

    public void switchToProductPage(){
        closeAdIfPresent();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLink)).click();
    }

    public void setSearchInput(String search)
    {
        closeAdIfPresent();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchInput)));
        driver.findElement(searchInput).sendKeys(search);
    }

    public void clickSubmitSearch()
    {
        driver.findElement(submitSearch).click();
    }

    public void addToCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(firstProduct)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(lastProduct)));
        driver.findElement(firstProduct).click();
        driver.findElement(lastProduct).click();
    }

    public void addAnyProductToCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(anyProduct)));
        driver.findElement(anyProduct).click();
    }

    public void continueShopping()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(continueShoppingButton)));
        driver.findElement(continueShoppingButton).click();
    }

    public void viewCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(viewCartLink)));
        driver.findElement(viewCartLink).click();
    }

    public String getCurrentCartPageUrl()
    {
        return driver.getCurrentUrl();
    }


    public void closeAdIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By adCloseBtn = By.cssSelector(".fc-close, .close, .ad-close, .popup-close");
            wait.until(ExpectedConditions.presenceOfElementLocated(adCloseBtn));
            driver.findElement(adCloseBtn).click();
        } catch (Exception e) {
            System.out.println("No ad appeared.");
        }
    }
}
