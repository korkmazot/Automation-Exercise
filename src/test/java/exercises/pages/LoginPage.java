package exercises.pages;


import exercises.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    public WebElement login;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginemail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement loginpassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginbutton;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/p")
    public WebElement wrongpassword;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement logout;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement signUpName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement signUpMail;

    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement gender;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement day;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement month;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement year;

    @FindBy(xpath = "//input[@name='newsletter']")
    public WebElement news;

    @FindBy(xpath = "//input[@name='optin']")
    public WebElement offers;

    @FindBy(xpath = "//input[@data-qa='first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@data-qa='last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@data-qa='company']")
    public WebElement company;

    @FindBy(xpath = "//input[@data-qa='address']")
    public WebElement address;

    @FindBy(xpath = "//select[@name='country']")
    public WebElement country;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement state;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@name='zipcode']")
    public WebElement zipcode;

    @FindBy(xpath = "//input[@name='mobile_number']")
    public WebElement mobile;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccount;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;

    @FindBy(xpath = "//i[@class=\'fa fa-user\']")
    public WebElement loggedAs;

    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccount;

    @FindBy(xpath = "//button[@class='btn btn-danger']")
    public  WebElement delete;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")
    public WebElement contactUs;

    @FindBy(xpath = "//div[@style='display: none']")
    public WebElement getInTouch;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement contactName;

    @FindBy(xpath = "//input[@data-qa='email']")
    public WebElement contactEmail;

    @FindBy(xpath = "//input[@data-qa='subject']")
    public WebElement contactSubject;

    @FindBy(xpath = "//input[@name='upload_file']")
    public WebElement uploadFile;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//i[@class='fa fa-angle-double-left']")
    public WebElement homeButton;

    @FindBy(css= "div[class='item active'] a[class='test_cases_list'] button[type='button']")
    public WebElement testCasesButton;




}

