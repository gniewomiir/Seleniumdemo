package jp.seleniumDemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import jp.seleniumDemo.pages.MainPage;
import jp.seleniumDemo.pages.MyAccountPage;
import jp.seleniumDemo.utils.SeleniumHelper;
import org.testng.annotations.Test;


import java.io.IOException;


public class AccountTests extends BaseTest  {

    private String email_;
    private String password_="Testowehaslo123";
    private String newPassword="Testowehaslo12";

    @Test
    public void CreateAccount() throws IOException {
        ExtentTest test = extentReports.createTest("Create account test");

        int randomNumber=(int)(Math.random()*1000);
        int randomNumber2=(int)(Math.random()*1000);
        String email = ("test"+randomNumber+"@"+randomNumber2+".pl");
        String password = "Testowehaslo123";

        MainPage mainPage = new MainPage(driver);
        mainPage.enterMyAccount();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.inputRegisterEmail("test"+randomNumber+"@"+randomNumber2+".pl");
        test.log(Status.PASS,"Register email put", SeleniumHelper.getScreenshot_(driver));
        myAccountPage.inputRegisterPassword(password_);
        test.log(Status.PASS,"Register password put", SeleniumHelper.getScreenshot_(driver));
        myAccountPage.clickRegisterButton();
        test.log(Status.PASS,"'Register' button clicked",SeleniumHelper.getScreenshot_(driver));
        myAccountPage.switchToAccountDetails();
        test.log(Status.PASS,"'Account Details' button clicked",SeleniumHelper.getScreenshot_(driver));
        myAccountPage.inputFirstName("Jan");
        test.log(Status.PASS,"First name put correctly",SeleniumHelper.getScreenshot_(driver));
        myAccountPage.inputLastName("Kowalski");
        test.log(Status.PASS,"Last name put correctly",SeleniumHelper.getScreenshot_(driver));
        myAccountPage.saveAccountDetails();
        test.log(Status.PASS,"'Save changes' button clicked ",SeleniumHelper.getScreenshot_(driver));
        myAccountPage.logoutButton();
        test.log(Status.PASS,"'Logout' button clicked",SeleniumHelper.getScreenshot_(driver));

        this.email_=email;

    }

    @Test
    public void LogIn () throws IOException {
        ExtentTest test = extentReports.createTest("Logging with new acc and changing password test");

        MainPage mainPage = new MainPage(driver);
        mainPage.enterMyAccount();


        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.inputLoginEmail(email_);
        test.log(Status.PASS,"Login email put correctly",SeleniumHelper.getScreenshot_(driver));
        myAccountPage.inputLoginPassword(password_);
        test.log(Status.PASS,"Login password put correctly",SeleniumHelper.getScreenshot_(driver));
        myAccountPage.clickLogin();
        test.log(Status.PASS,"'Login' button clicked",SeleniumHelper.getScreenshot_(driver));
        myAccountPage.switchToAccountDetails();
        test.log(Status.PASS,"'Account details' button clicked",SeleniumHelper.getScreenshot_(driver));
        myAccountPage.changingPassword(password_,newPassword);
        test.log(Status.PASS,"All mandatory fields to change password filled",SeleniumHelper.getScreenshot_(driver));
        myAccountPage.saveAccountDetails();
        test.log(Status.PASS,"'Save changes' button clicked",SeleniumHelper.getScreenshot_(driver));
        // trying to log in with new password
        myAccountPage.logoutButton();
        test.log(Status.PASS,"'Logout' button clicked",SeleniumHelper.getScreenshot_(driver));
        myAccountPage.inputLoginEmail(email_);
        test.log(Status.PASS,"Login email put correctly",SeleniumHelper.getScreenshot_(driver));
        myAccountPage.inputLoginPassword(newPassword);
        test.log(Status.PASS,"Login password put correctly",SeleniumHelper.getScreenshot_(driver));
        myAccountPage.clickLogin();
        test.log(Status.PASS,"'Login' button clicked",SeleniumHelper.getScreenshot_(driver));

    }




}
