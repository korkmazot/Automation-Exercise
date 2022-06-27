package exercises.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class ActionsTest {

    @Test
    public void test01(){

        //    1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         //    2. Navigate to url 'http://automationexercise.com'
         driver.get("http://www.automationexercise.com");

        //    3.  Click on 'Signup / Login' button
        WebElement signupButton = driver.findElement(By.xpath("//a[@href='/login']"));
        Actions actions = new Actions(driver);
        actions.click(signupButton).perform();

        //    4. Enter name and email address
        //    5. Click 'Signup' button
        WebElement nameBox = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        actions.click(nameBox)
                .sendKeys("Talha")
                .sendKeys(Keys.TAB)
                .sendKeys("otal@dh.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //    6. Fill details: Title, Name, Email, Password, Date of birth
        //    7. Select checkbox 'Sign up for our newsletter!'
        //    8. Select checkbox 'Receive special offers from our partners!'
        //    9. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement titleRadioButton = driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        actions.click(titleRadioButton)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("123456")
                .sendKeys(Keys.TAB)
                .sendKeys("4")
                .sendKeys(Keys.TAB)
                .sendKeys("JANUARY")
                .sendKeys(Keys.TAB)
                .sendKeys("2004")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
              //  .sendKeys(Keys.TAB)
                .sendKeys("Talha")
                .sendKeys(Keys.TAB)
                .sendKeys("Kotjk")
                .sendKeys(Keys.TAB)
                .sendKeys("kendim")
                .sendKeys(Keys.TAB)
                .sendKeys("Ulu cadde no.95")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("SINGAPORE")
                .sendKeys(Keys.TAB)
                .sendKeys("SING")
                .sendKeys(Keys.TAB)
                .sendKeys("Merkez")
                .sendKeys(Keys.TAB)
                .sendKeys("17805")
                .sendKeys(Keys.TAB)
                .sendKeys("01976545324")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //    10.Click 'Create Account button'
        //    11.Verify that 'ACCOUNT CREATED!' is visible
        String expValue = "ACCOUNT CREATED!";
        String actValue = driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        Assert.assertEquals(expValue,actValue);
        System.out.println(expValue);
        System.out.println(actValue);

        driver.close();
}

}
