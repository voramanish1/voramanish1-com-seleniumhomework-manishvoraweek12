package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Base64;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find login tab and click on tab
        WebElement loginTab = driver.findElement(By.linkText("Log in"));
        loginTab.click();

        //This is from requirement
        driver.findElement(By.linkText("Log in")).click();

        String expectedMessage = "Welcome, Please Sign In!";

        //Find the welcom text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualTextMessageElement.getText();

        //Vlidation actual and expeced
        Assert.assertEquals("Not navigated to Login page", expectedMessage,actualMessage);

    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.linkText("Log in")).click();
        //Located Email field and enterd valid email
        driver.findElement(By.id("Email")).sendKeys("abcd@gmail.com");
        //Located password field and enter valid credetials
        driver.findElement(By.name("Password")).sendKeys("123456");

        //After entering valid credetials click on login button
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        //Verifying logout text is displayed or no
        String expectedMessae1 = "Log out";
        WebElement actualMessagetext = driver.findElement(By.xpath("//a[text()='Log out']"));
        String actualMessage1 = actualMessagetext.getText();

        Assert.assertEquals("No log out is available", actualMessage1,expectedMessae1);


    }
    @Test
    public void verifyTheErrorMessage() {
        //Find login tab and click on tab
        driver.findElement(By.linkText("Log in")).click();

        //Find email and enter in field element
        driver.findElement(By.id("Email")).sendKeys("abcd@gmail.com");

        //Find password and enter in field element
        driver.findElement(By.name("Password")).sendKeys("1234567");

        //Find login button and click
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        //Verify error message on login page when entering invalid credentials
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect";

        //Find the error message text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage = actualTextMessageElement.getText();

        //Validate actual and expected
        Assert.assertEquals("Error message not found", expectedMessage, actualMessage);
}

    @After
    public void teardown(){
        closingBrowser();
    }




}




