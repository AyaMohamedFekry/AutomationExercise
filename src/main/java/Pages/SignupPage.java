package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {

    WebDriver driver ;

    //Signup
    By username = By.cssSelector("input[type=\"text\"]");
    By emailAddress = By.cssSelector("input[data-qa=\"signup-email\"]");
    By signup = By.cssSelector("button[data-qa=\"signup-button\"]");

    //Enter Account Information
    By getTitleMr = By.id("id_gender1");
    By getTitleMrs = By.id("id_gender2");
    By getUsername = By.id("name");
    By getEmailAddress = By.id("email");
    By getPassword  = By.id("password");
    By getDay = By.id("days");
    By getMonth = By.id("months");
    By getYear = By.id("years");
    By getReceiveSpecialOffers = By.cssSelector("input[name=\"optin\"]");
    By getNewsletter = By.cssSelector("input[id=\"newsletter\"]");

    //Address Information
    By getFirstname = By.id("first_name");
    By getLastname = By.id("last_name");
    By getCompany = By.id("company");
    By getAddress = By.id("address1");
    By getCountry = By.id("country");
    By getState = By.id("state");
    By getCity = By.id("city");
    By getZipcode = By.id("zipcode");
    By getMobileNumber = By.id("mobile_number");
    By createAccountButton = By.cssSelector("button[data-qa=\"create-account\"]");
    By verify = By.cssSelector("h2[data-qa=\"account-created\"]");
    By continueButton = By.cssSelector("a[data-qa=\"continue-button\"]");

    //Verify Error message
    By getErrorMessage = By.cssSelector("p[style=\"color: red;\"]");


    public SignupPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void setSignup(String name , String email)
    {
        driver.findElement(username).sendKeys(name);
        driver.findElement(emailAddress).sendKeys(email);
        driver.findElement(signup).click();
    }

    public void enterAccountInformation(String Title , String password , String day , String month , String year , String checkbox)
    {
        if (Title.equals("Mr."))
        {
            driver.findElement(getTitleMr).click();
        }
        else
        {
            driver.findElement(getTitleMrs).click();
        }
        driver.findElement(getPassword).sendKeys(password);
        Select d = new Select(driver.findElement(getDay));
        d.selectByValue(day);
        Select m = new Select (driver.findElement(getMonth));
        m.selectByVisibleText(month);
        Select y = new Select(driver.findElement(getYear));
        y.selectByVisibleText(year);
        if (checkbox.contains("newsletter"))
        {
            driver.findElement(getNewsletter).click();
        }
        else
        {
            driver.findElement(getReceiveSpecialOffers).click();
        }
    }

    public void enterAddressInformation(String firstname ,String lastname , String company , String address , String country , String state , String city , String zipcode , String mobileNumber)
    {
        driver.findElement(getFirstname).sendKeys(firstname);
        driver.findElement(getLastname).sendKeys(lastname);
        driver.findElement(getCompany).sendKeys(company);
        driver.findElement(getAddress).sendKeys(address);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(getCountry));
        Select c = new Select(driver.findElement(getCountry));
        c.selectByValue(country);
        driver.findElement(getState).sendKeys(state);
        driver.findElement(getCity).sendKeys(city);
        driver.findElement(getZipcode).sendKeys(zipcode);
        driver.findElement(getMobileNumber).sendKeys(mobileNumber);
        driver.findElement(createAccountButton).click();
    }

    public String registrationVerification()
    {
        return driver.findElement(verify).getText();
    }

    public void moveToHomePage()
    {
        driver.findElement(continueButton).click();
    }

    public String verifyErrorMessage()
    {
        return driver.findElement(getErrorMessage).getText();
    }


}
