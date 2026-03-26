import Pages.CartPage;
import Pages.LoginPage;
import Pages.PaymentPage;
import Pages.ShoppingPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Shopping extends BaseTest {

    @Test
    public void shoppingScenario(){
        //Valid login
        LoginPage ob = new LoginPage(driver);
        ob.moveToLoginPage();
        ob.login("aya13579@gmail.com", "135792468&");
        //Shopping Scenario
        ShoppingPage obj = new ShoppingPage(driver);
        //View product page
        obj.switchToProductPage();
        //Search for a specific product (T-shirt)
        obj.setSearchInput("T-shirt");
        obj.clickSubmitSearch();
        //Add to cart
        obj.addToCart();
        obj.continueShopping();
        obj.addToCart();
        //Navigate to View Cart page
        obj.viewCart();
        //Verify that user is redirected to View Cart Page
        String actual = obj.getCurrentCartPageUrl();
        String expected = "https://automationexercise.com/view_cart";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected);
        CartPage cartPage = new CartPage(driver);
        //Remove product from cart
        cartPage.deleteFromCart();
        //Proceed to checkout
        cartPage.checkout();
        //Place order from checkout page
        cartPage.placeOrder();
        PaymentPage paymentPage = new PaymentPage(driver);
        //Fill payment details and submit order
        paymentPage.paymentProcess("Aya","2816816845866","798","7","2027");
        //Verify that order is successfully placed
        String actualValue = paymentPage.verifyOrderIsPlaced();
        String expectedValue = "ORDER PLACED!";
        softAssert.assertEquals(actualValue,expectedValue);
        //Assert all validations
        softAssert.assertAll();
    }
}
