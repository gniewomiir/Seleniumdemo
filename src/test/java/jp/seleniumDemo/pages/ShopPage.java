package jp.seleniumDemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {

    @FindBy(xpath="//a[@aria-label='Add “BDD Cucumber” to your cart']")
    private WebElement BddCucumberAddButton;

    @FindBy(xpath="//a[@aria-label='Add “GIT basics” to your cart']")
    private WebElement GitBasicsAddButton;

    @FindBy(xpath="//a[@aria-label='Add “Java Selenium WebDriver” to your cart']")
    private WebElement JavaSelWebDriAddButton;

    @FindBy(xpath="//a[@href='http://seleniumdemo.com/?page_id=5']")
    private WebElement CartButton;



    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();




    public ShopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public void addBddCucumberToCart(int numberOfItemsToAdd) throws InterruptedException {
        for (int i = 0; i<numberOfItemsToAdd;i++){
            Thread.sleep(1000);
            logger.info("Performing click on 'Add to cart Button'");
            BddCucumberAddButton.click();
            logger.info("Clicked button");
            Thread.sleep(500);
        }
        logger.info("Totally added products : " + numberOfItemsToAdd);

    }

    public void addGITToCart(int numberOfItemsToAdd) throws InterruptedException {
        for (int i = 0; i<numberOfItemsToAdd;i++){
            Thread.sleep(1000);
            logger.info("Performing click on 'Add to cart Button'");
            GitBasicsAddButton.click();
            logger.info("Clicked button");
            Thread.sleep(500);
        }
        logger.info("Totally added products : " + numberOfItemsToAdd);
    }

    public void addJavaSelWebDriToCart(int numberOfItemsToAdd) throws InterruptedException {
        for (int i = 0; i<numberOfItemsToAdd;i++){
            Thread.sleep(1000);
            logger.info("Performing click on 'Add to cart Button'");
            JavaSelWebDriAddButton.click();
            logger.info("Clicked button");
            Thread.sleep(500);
        }
        logger.info("Totally added products : " + numberOfItemsToAdd);

    }

    public void swapToCart(){
        logger.info("Performing click on 'Cart' button");
        CartButton.click();
        logger.info("Clicked button");
    }



}
