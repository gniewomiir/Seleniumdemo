package jp.seleniumDemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(xpath="//input[@type='number' and @aria-labelledby='BDD Cucumber quantity']")
    private WebElement CucumberQuantityInCart;

    @FindBy(xpath="//input[@type='number' and @aria-labelledby='GIT basics quantity']")
    private WebElement GitQuantityInCart;

    @FindBy(xpath="//input[@type='number' and @aria-labelledby='Java Selenium WebDriver quantity']")
    private WebElement JavaSelWebDriInCart;



    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();


    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public void cucumberQuantityChecker(Integer declaredAddedNumber){
        String added = CucumberQuantityInCart.getAttribute("value");
        logger.info("Declared added : " + declaredAddedNumber + " Number that is in a cart : " +added);
        String declared =String.valueOf(declaredAddedNumber);
        if(added.equals(declared)){
            logger.info("Declared quantity match to one that is visible at cart summary");
        }else{
            logger.info("Declared quantity don't match to one that is visible at cart summary");
        }
    }

    public void gitQuantityChecker(Integer declaredAddedNumber){
        String added = GitQuantityInCart.getAttribute("value");
        logger.info("Declared added : " + declaredAddedNumber + " Number that is in a cart : " +added);
        String declared =String.valueOf(declaredAddedNumber);
        if(added.equals(declared)){
            logger.info("Declared quantity match to one that is visible at cart summary");
        }else{
            logger.info("Declared quantity don't match to one that is visible at cart summary");
        }
    }

    public void javaQuantityChecker(Integer declaredAddedNumber){
        String added = JavaSelWebDriInCart.getAttribute("value");
        logger.info("Declared added : " + declaredAddedNumber + " Number that is in a cart : " +added);
        String declared =String.valueOf(declaredAddedNumber);
        if(added.equals(declared)){
            logger.info("Declared quantity match to one that is visible at cart summary");
        }else{
            logger.info("Declared quantity don't match to one that is visible at cart summary");
        }
    }




}
