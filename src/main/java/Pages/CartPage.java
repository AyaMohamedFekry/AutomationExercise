package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    By cartLink = By.cssSelector("a[href=\"/view_cart\"]");
    By deleteItem = By.cssSelector("a[data-product-id=\"28\"]");
    By checkoutButton = By.cssSelector("a[class=\"btn btn-default check_out\"]");
    By placeOrderButton = By.cssSelector("a[class=\"btn btn-default check_out\"]");

    public void deleteFromCart()
    {
        driver.findElement(deleteItem).click();
    }
    public void checkout()
    {
        driver.findElement(checkoutButton).click();
    }
    public void placeOrder()
    {
        driver.findElement(placeOrderButton).click();
    }
    public void viewCart()
    {
        driver.findElement(cartLink).click();
    }

}
