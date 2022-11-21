package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseurl="https://demo.nopcommerce.com/";
    @Before
    public  void setUp(){
        openBrowser(baseurl);
    }
    public void userShouldNavigateToRegisterPageSuccessfully(){
        //click on the register link
        WebElement registerLink= driver.findElement(By.linkText("Register"));
        registerLink.click();
        //Verify the text 'Register'
        String actualText=driver.findElement(By.linkText("Register")).getText();
        String expactedText="Register";
        Assert.assertEquals("verify text", expactedText,actualText );
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //Find register tab and click on tab
        driver.findElement(By.xpath("//a[text()='Register']")).click();

        //Find gender radio button and select radio button
        driver.findElement(By.id("gender-male")).click();

        //Find first name and enter in field element
        driver.findElement(By.name("FirstName")).sendKeys("Manish");

        //Find last name and enter in field element
        driver.findElement(By.name("LastName")).sendKeys("Vora");

        //Find date of birth and enter in field element
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("07");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("March");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1991");

        //Find email and enter in field element
        driver.findElement(By.name("Email")).sendKeys("abcd@gmail.com");

        //Find password and confirm password and enter in field element
        driver.findElement(By.name("Password")).sendKeys("123456");
        driver.findElement(By.name("ConfirmPassword")).sendKeys("123456");

        //Find register button and click on tab
        driver.findElement(By.id("register-button")).click();

        //Verify text after registration
        String expectedMessage = "Your registration completed";

        //Find text message element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//div[text()='Your registration completed']"));
        String actualMessage = actualTextMessageElement.getText();

        //Validate actual and expected
        Assert.assertEquals("Message not matched", expectedMessage, actualMessage);
}
    @After
    public void tearDown(){
       closingBrowser();
    }
}
