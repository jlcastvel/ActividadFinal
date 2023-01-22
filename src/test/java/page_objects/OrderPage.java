package page_objects;

        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.How;
        import org.openqa.selenium.support.PageFactory;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.time.Duration;

public class OrderPage {

    private WebDriver driver;
    private int timeout = 2000;
    @FindBy(how = How.ID, using = "name")
    WebElement nameField;
    @FindBy(how = How.ID, using = "country")
    WebElement countryField;
    @FindBy(how = How.ID, using = "city")
    WebElement cityField;
    @FindBy(how = How.ID, using = "card")
    WebElement cardField;
    @FindBy(how = How.ID, using = "month")
    WebElement monthField;
    @FindBy(how = How.ID, using = "year")
    WebElement yearField;
    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div[3]/button[2]")
    WebElement purchaseButton;
    @FindBy(how = How.XPATH, using = "/html/body/div[10]/div[7]/div/button")
    WebElement purchaseOkButton;

    public OrderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitOrderVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOf(purchaseButton));
    }
    public void waitPurchaseOkVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOf(purchaseOkButton));
    }

    public void fillPlaceOrderForm(){
        nameField.sendKeys("username" + Keys.ENTER);
        cardField.sendKeys("card" + Keys.ENTER);
    }
    public void clickPurchase(){
        purchaseButton.click();
    }
}
