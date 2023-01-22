package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private int timeout = 3000;
    @FindBy(how = How.ID, using = "tbodyid")
    WebElement cartTable;
    @FindBy(how = How.LINK_TEXT, using = "Add to cart")
    WebElement addToCartButton;

    @FindBy(how = How.XPATH, using = "/html/body/nav/div/div/ul/li[1]/a")
    WebElement buttonHomePage;

    @FindBy(how = How.CLASS_NAME, using = "btn btn-success btn-lg")
    WebElement buttonCart;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitProductPageVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
    }

    public void clickAddToCart(){
        addToCartButton.click();
    }

    public void pressHomePage () {

        buttonHomePage.click();
    }
    public void pressCart () {
        buttonCart.click();
    }
}