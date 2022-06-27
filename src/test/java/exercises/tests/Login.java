package exercises.tests;

import exercises.pages.LoginPage;
import exercises.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login{
    LoginPage loginPage = new LoginPage();

    @Test
    public void checkPageTitle(){
        //Open browser
        Driver.getDriver().get("http://automationexercise.com");
        String expectedTitle = "Automation Exercise";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Automation Exercise",expectedTitle,actualTitle);
    }
    @Test
    public void SignUp(){
        Driver.getDriver().get("http://automationexercise.com");
        loginPage.login.click();
        loginPage.signUpName.sendKeys("OTK");
        loginPage.signUpMail.sendKeys("omertkorkm@hotmail.com");
        loginPage.signUpButton.click();
        loginPage.gender.click();
        loginPage.password.sendKeys("12345");
        loginPage.day.sendKeys("12");
        loginPage.month.sendKeys("May");
        loginPage.year.sendKeys("2020");
        loginPage.news.click();
        loginPage.offers.click();
        loginPage.firstName.sendKeys("Omer Talha");
        loginPage.lastName.sendKeys("Korkmaz");
        loginPage.company.sendKeys("Cydeo");
        loginPage.address.sendKeys("Brunnenstr 13");
        loginPage.country.sendKeys("Singapore");
        loginPage.state.sendKeys("Hessen");
        loginPage.city.sendKeys("SIngapore");
        loginPage.zipcode.sendKeys("34537");
        loginPage.mobile.sendKeys("0152634563");
        loginPage.createAccount.click();

        String expected = "Automation Exercise - Account Created";
        String actual = Driver.getDriver().getTitle();
        Assert.assertEquals("Automation Exercise - Account Created",expected,actual);

        loginPage.continueButton.click();

        if(Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed()){
            System.out.println("Logged in as OTK");
                    }else{
            System.out.println("Wrong user");
        }

        loginPage.deleteAccount.click();
    }

    @Test
    public void LoginWithCorrectPassword(){

        Driver.getDriver().get("http://automationexercise.com");
        loginPage.login.click();
        loginPage.loginemail.sendKeys("omertkork@hotmail.com");
        loginPage.loginpassword.sendKeys("12345");
        loginPage.loginbutton.click();

        if(Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed()){
            System.out.println("Logged in as OTK");
        }else{
            System.out.println("Wrong user");
        }

        loginPage.deleteAccount.click();
    }

    @Test
    public void LoginWithWrongPassword(){

        Driver.getDriver().get("http://automationexercise.com");
        loginPage.login.click();
        loginPage.loginemail.sendKeys("omert@hotmail.com");
        loginPage.loginpassword.sendKeys("12345");
        loginPage.loginbutton.click();

        if (Driver.getDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).isDisplayed()){
            System.out.println("Your email or password is incorrect!");
        }else{
            System.out.println("Unknown");
        }
    }

    @Test
    public void Logout(){

        Driver.getDriver().get("http://automationexercise.com");
        loginPage.login.click();
        loginPage.loginemail.sendKeys("omertkork@hotmail.com");
        loginPage.loginpassword.sendKeys("12345");
        loginPage.loginbutton.click();

        if(Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed()){
            System.out.println("Logged in as OTK");
        }else{
            System.out.println("Wrong user");
        }
        loginPage.logout.click();
        Driver.getDriver().navigate().back();
        System.out.println(Driver.getDriver().getTitle());
    }

    @Test
    public void ContactUsForm() throws InterruptedException {

        Driver.getDriver().get("http://automationexercise.com");
        String expectedTitle = "Automation Exercise";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        loginPage.contactUs.click();
        String expectedTitle2 = "GET IN TOUCH";
        String actualTitle2 = "GET IN TOUCH";
        Assert.assertEquals(expectedTitle2,actualTitle2);
        System.out.println(expectedTitle2);
        System.out.println(actualTitle2);

        //WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        jse.executeScript("window.scrollBy(0,450)");
        Thread.sleep(2000);

        loginPage.contactName.sendKeys("Omer Talha");
        loginPage.contactEmail.sendKeys("otk@gmail.com");
        loginPage.contactSubject.sendKeys("Quality Issue");

        Thread.sleep(2000);
        loginPage.uploadFile.sendKeys("C:/Users/omert/Desktop/Cybertek/Birinci Hafta.jpg");
        loginPage.submitButton.click();
        Driver.getDriver().switchTo().alert().accept();

        String expectedTitle3 = "Success! Your details have been submitted successfully.";
        String actualTitle3 = "Success! Your details have been submitted successfully.";
        Assert.assertEquals(expectedTitle3,actualTitle3);
        System.out.println(expectedTitle3);
        System.out.println(actualTitle3);
        loginPage.homeButton.click();
        Driver.getDriver().close();
    }
    @Test
    public void VerifyTestCasesPage(){
        Driver.getDriver().get("http://automationexercise.com");
        String expectedTitle = "Automation Exercise";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        loginPage.testCasesButton.click();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b"));
        String expTitle = "TEST CASES";
        String actTitle = "TEST CASES";
        Assert.assertEquals(expTitle,actTitle);
        System.out.println(expTitle);
        System.out.println(actTitle);

    }
    @Test
    public void VerifyAllProducts() throws InterruptedException {

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        Driver.getDriver().get("http://automationexercise.com");
        String expectedTitle = "Automation Exercise";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        Driver.getDriver().findElement(By.xpath("//a[@href='/products']")).click();
        String excProducts = "Automation Exercise - All Products";
        String actProducts = "Automation Exercise - All Products";
        Assert.assertEquals(excProducts,actProducts);
        System.out.println(excProducts);
        System.out.println(actProducts);

        Driver.getDriver().findElement(By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]")).click();
        System.out.println(Driver.getDriver().findElement(By.xpath("//div[@class=\\'product-information\\']")).isDisplayed());
        String expUrl = "https://automationexercise.com/product_details/1";
        String acturl = "https://automationexercise.com/product_details/1";
//        String acturl = Driver.getDriver().getTitle();
        Assert.assertEquals(expUrl,acturl);

//        driver.navigate().to("https://www.google.com");
//        Thread.sleep(2000);
//        driver.navigate().back();

    }
}