package page_objects;

import libraries.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage {

    private WebDriver driver;
    private CommonFunctions env;
    WebElement[] cellElements;
    private int timeout = 2000;
    @FindBy(how = How.ID, using = "tbodyid")
    WebElement cartTable;
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[2]/button")
    WebElement placeOrderButton;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitCartVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOf(cartTable));
    }

    public void deleteProduct(String product){
        cellElements = new WebElement[]{};
        env = new CommonFunctions();

        env.sleep(500);
        List<WebElement> rowElements = cartTable.findElements(By.className("success"));

        for (int row=0;row<rowElements.size();++row) {
            List<WebElement> cellElements = rowElements.get(row).findElements(By.cssSelector("td"));
            if(product.compareToIgnoreCase(cellElements.get(1).getText()) == 0){
                (cellElements.get(3).findElement(By.cssSelector("a"))).click();
                env.sleep(5000);
            }
        }
    }
    public void verifyNoProducts(){

        List<WebElement> elements = cartTable.findElements(By.className("success"));
        assertThat( elements.size()).isEqualTo(0);
    }
    public void clickPlaceOrder(){
        placeOrderButton.click();
    }
}
