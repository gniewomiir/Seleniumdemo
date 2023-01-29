package jp.seleniumDemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import jp.seleniumDemo.pages.CartPage;
import jp.seleniumDemo.pages.MainPage;
import jp.seleniumDemo.pages.ShopPage;
import jp.seleniumDemo.utils.SeleniumHelper;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.Random;


public class CartTests extends BaseTest {


    @Test
    public void CompareQuantityInShopCart() throws InterruptedException, IOException {
        ExtentTest test = extentReports.createTest("Comparing added quantity of items to visible one at cart page");

        MainPage mainPage = new MainPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        CartPage cartPage = new CartPage(driver);
        int randomNumber= new Random().nextInt(9)+1;
        int randomNumber2=new Random().nextInt(9)+1;
        int randomNumber3=new Random().nextInt(9)+1;

        //   quantity_624395f009c5c

        mainPage.enterShop();
        test.log(Status.PASS,"Entered 'shop' page", SeleniumHelper.getScreenshot_(driver));
        shopPage.addBddCucumberToCart(randomNumber);
        test.log(Status.PASS,"Added BDDCucumber"+ randomNumber + " times to cart.", SeleniumHelper.getScreenshot_(driver));
        shopPage.addJavaSelWebDriToCart(randomNumber2);
        test.log(Status.PASS,"Added Java Selenium Web Driver"+ randomNumber2 + " times to cart.", SeleniumHelper.getScreenshot_(driver));
        shopPage.addGITToCart(randomNumber3);
        test.log(Status.PASS,"Added GIT basics"+ randomNumber3 + " times to cart.", SeleniumHelper.getScreenshot_(driver));
        shopPage.swapToCart();
        test.log(Status.PASS,"Swapped to 'Cart' page", SeleniumHelper.getScreenshot_(driver));
        cartPage.cucumberQuantityChecker(randomNumber);
        test.log(Status.PASS,"Checked if declared amount of added BDD Cucumber is the same as one is that visible at cart summary ");
        cartPage.javaQuantityChecker(randomNumber2);
        test.log(Status.PASS,"Checked if declared amount of added Java Selenium WebDriver is the same as one is that visible at cart summary ");
        cartPage.gitQuantityChecker(randomNumber3);
        test.log(Status.PASS,"Checked if declared amount of added GIT basics is the same as one is that visible at cart summary ");


    }

//    @Test
//    public void ComparePriceInShopCart(){
//
//    }



}
