import Pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Payment extends BaseTest{

    @BeforeMethod
    public void beforeMethod()
    {
        //Valid login
        LoginPage ob = new LoginPage(driver);
        ob.moveToLoginPage();
        ob.login("aya13579@gmail.com", "135792468&");

        //Add to cart
        ShoppingPage shoppingPage = new ShoppingPage(driver);
        shoppingPage.switchToProductPage();
        shoppingPage.addAnyProductToCart();
        shoppingPage.viewCart();

        //View Cart
        CartPage cartPage = new CartPage(driver);
        cartPage.checkout();
        cartPage.placeOrder();
    }

    @Test (priority = 0)
    public void verifyErrorMessageWhenNameIsMissing()
    {
        //Payment page
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.paymentProcess("","51548656161","118","11","2027");
        String actual = paymentPage.getNameOnCardValidationMessage();
        String expected = "Please fill out this field.";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
    }

    @Test (priority = 1)
    public void verifyErrorMessageWhenCardNumberIsMissing()
    {
        //Payment page
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.paymentProcess("Aya","","118","11","2027");
        String actual = paymentPage.getCardNumberValidationMessage();
        String expected = "Please fill out this field.";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
    }

    @Test (priority = 2)
    public void verifyErrorMessageWhenCVCIsMissing()
    {
        //Payment page
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.paymentProcess("Aya","545454254","","11","2027");
        String actual = paymentPage.getCVCValidationMessage();
        String expected = "Please fill out this field.";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
    }

    @Test (priority = 3)
    public void verifyErrorMessageWhenMonthIsMissing()
    {
        //Payment page
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.paymentProcess("Aya","545454254","578","","2027");
        String actual = paymentPage.getExpiryMonthValidationMessage();
        String expected = "Please fill out this field.";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
    }

    @Test (priority = 4)
    public void verifyErrorMessageWhenYearIsMissing()
    {
        //Payment page
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.paymentProcess("Aya","545454254","125","11","");
        String actual = paymentPage.getExpiryYearValidationMessage();
        String expected = "Please fill out this field.";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod()
    {
        //Logout
        LogoutAndDeleteAccountPage logoutAndDeleteAccountPage = new LogoutAndDeleteAccountPage(driver);
        logoutAndDeleteAccountPage.logout();
    }
}
