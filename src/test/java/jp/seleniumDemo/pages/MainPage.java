package jp.seleniumDemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(id="menu-item-22")
    private WebElement myAccountButton;

    @FindBy(id="menu-item-21")
    private WebElement shopButton;

    @FindBy(id="menu-item-20")
    private WebElement cartButton;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }



    public void enterMyAccount(){
        logger.info("Performing click on ' My Account button '");
        myAccountButton.click();
        logger.info("Button clicked");
    }

    public void enterShop(){
        logger.info("Performing click on 'Shop' button");
        shopButton.click();
        logger.info("Button clicked");
    }

    public void enterCart(){
        logger.info("Performing click on 'Cart' button");
        cartButton.click();
        logger.info("Button clicked");
    }

}
