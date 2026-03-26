import Pages.LogoutAndDeleteAccountPage;
import Pages.SignupPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SignUp extends BaseTest{

    @Test(priority = 0)
    public void validSignup()
    {
        //Valid Signup
        driver.navigate().to("https://automationexercise.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        SignupPage obj = new SignupPage(driver);
        obj.setSignup("Aya","aya13579@gmail.com");
        obj.enterAccountInformation("Mrs.","135792468&","12","December","2002","Receive special offers from our partners!");
        obj.enterAddressInformation("Aya","Mohamed","NTI","Street 2","Canada","Single","Cairo","13495","8445445844");
        String actual = obj.getRegistrationConfirmationText();
        String expected = "ACCOUNT CREATED!";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();

        //Move To Home Page
        obj.moveToHomePage();

        //Logout
        LogoutAndDeleteAccountPage ob = new LogoutAndDeleteAccountPage(driver);
        ob.logout();
    }

    @Test(priority = 1)
    public void signupWithAccountAlreadyExist()
    {
        //Signup With Account Already Exist
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        SignupPage obj = new SignupPage(driver);
        obj.setSignup("Aya","aya13579@gmail.com");
        String actual = obj.verifyErrorMessage();
        String expected  = "Email Address already exist!";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
    }
}
