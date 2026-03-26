import Pages.LoginPage;
import Pages.LogoutAndDeleteAccountPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login extends BaseTest{

    @Test (priority = 0)
    public void validLogin()
    {
        //Valid Login
        LoginPage obj = new LoginPage(driver);
        obj.moveToLoginPage();
        obj.login("aya13579@gmail.com", "135792468&");
        String actual = obj.getCurrentPageUrl();
        String expected = "https://automationexercise.com/";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
        LogoutAndDeleteAccountPage ob = new LogoutAndDeleteAccountPage(driver);
        ob.logout();
    }

    @Test ( priority = 1)
    public void LoginWithInvalidUsername()
    {
        LoginPage obj = new LoginPage(driver);
        obj.moveToLoginPage();
        obj.login("aya1@gmail.com", "135792468&");
        String actual = obj.getErrorMessageText();
        String expected  = "Your email or password is incorrect!";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
    }

    @Test ( priority = 2)
    public void LoginWithInvalidPassword()
    {
        LoginPage obj = new LoginPage(driver);
        obj.moveToLoginPage();
        obj.login("aya13579@gmail.com", "135792");
        String actual = obj.getErrorMessageText();
        String expected  = "Your email or password is incorrect!";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
    }

    @Test (priority = 3)
    public void LoginWithDeletedAccount()
    {
        //Valid Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.moveToLoginPage();
        loginPage.login("aya13579@gmail.com", "135792468&");
        //Delete Account
        LogoutAndDeleteAccountPage ob = new LogoutAndDeleteAccountPage(driver);
        ob.deleteAccount();
        //Login With Deleted Account
        LoginPage obj = new LoginPage(driver);
        obj.moveToLoginPage();
        obj.login("aya13579@gmail.com", "135792468&");
        String actual = obj.getErrorMessageText();
        String expected  = "Your email or password is incorrect!";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
    }
}
