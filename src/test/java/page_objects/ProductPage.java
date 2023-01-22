package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;


    @FindBy(how = How.XPATH, using = "/html/body/nav/div/div/ul/li[1]/a")
    WebElement buttonHomePage;

    @FindBy(how = How.CLASS_NAME, using = "btn btn-success btn-lg")
    WebElement buttonCart;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        public void pressHomePage () {

            buttonHomePage.click();
        }
        public void pressCart () {
            buttonCart.click();
        }


    }

