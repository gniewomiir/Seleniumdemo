package jp.seleniumDemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    @FindBy(id="reg_email")
    private WebElement RegisterEmail;

    @FindBy(id="reg_password")
    private WebElement RegisterPassword;

    @FindBy(id="username")
    private WebElement LoginEmail;

    @FindBy(id="password")
    private WebElement LoginPassword;

    @FindBy(name="register")
    private WebElement RegisterButton;

    @FindBy(xpath = "//a[text()='Account details']")
    private WebElement AccDetailsButton;

    @FindBy(id="account_first_name")
    private WebElement FirstName;

    @FindBy(id="account_last_name")
    private WebElement LastName;

    @FindBy(name="save_account_details")
    private WebElement SaveAccDetailsButton;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement LogoutButton;

    @FindBy(name="login")
    private WebElement LoginButton;

    @FindBy(id="password_current")
    private WebElement CurrentPassword;

    @FindBy(id="password_1")
    private WebElement NewPassword;

    @FindBy(id="password_2")
    private WebElement ConfirmPassword;


    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();


    public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public void inputRegisterEmail(String email){
        logger.info("Setting random address email :" +email);
        RegisterEmail.sendKeys(email);
        logger.info("Setting address email done");
    }
    public void inputRegisterPassword(String password){
        logger.info("Setting predefined password : "+password);
        RegisterPassword.sendKeys(password);
        logger.info("Setting password done");
    }



    public void clickRegisterButton(){
        logger.info("Performing click 'Register' button");
        RegisterButton.click();
        logger.info("Clicked 'Register' button");

    }

    public void switchToAccountDetails(){
        logger.info("Performing click 'Account Details' button");
        AccDetailsButton.click();
        logger.info("Clicked 'Account Details' button");
    }

    public void inputFirstName(String firstName){
        logger.info("Setting First Name :"+firstName);
        FirstName.sendKeys(firstName);
        logger.info("Setting First Name done");
    }

    public void inputLastName(String lastName){
        logger.info("Setting Last Name "+lastName);
        LastName.sendKeys(lastName);
        logger.info("Setting Last Name done");
    }

    public void clickLastName(){
        logger.info("Performing click on Last Name field");
        LastName.click();
        logger.info("Clicked Last Name field");
    }

    public void saveAccountDetails(){
        logger.info("Performing click on save account details button");
        SaveAccDetailsButton.click();
        logger.info("Button clicked");
    }

    public void logoutButton(){
        logger.info("Performing click on 'logout' button");
        LogoutButton.click();
        logger.info("Button clicked");
    }


    public void inputLoginEmail (String email){
        logger.info("Setting login email" + email);
        LoginEmail.sendKeys(email);
        logger.info("Login email set");
    }

    public void inputLoginPassword(String password){
        logger.info("Setting login password "+password);
        LoginPassword.sendKeys(password);
        logger.info("Login password set");
    }

    public void clickLogin(){
        logger.info("Performing click on 'Login' button");
        LoginButton.click();
        logger.info("Clicked 'Login' button");
    }

    public void changingPassword(String oldPassword,String newPassword){
        logger.info("Inputting old password: "+oldPassword);
        CurrentPassword.sendKeys(oldPassword);
        logger.info("Inputting new predefined password : "+newPassword);
        NewPassword.sendKeys(newPassword);
        logger.info("Inputting new predefined password into confirmation field");
        ConfirmPassword.sendKeys(newPassword);
        logger.info("All mandatory fields filled");
    }

}
