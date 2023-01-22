package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "signin2")
    WebElement signUpOption;
    @FindBy(how = How.ID, using = "cartur")
    WebElement cartOption;
    @FindBy(how = How.ID, using = "cat")
    WebElement categoriesLabel;
    @FindBy (how = How.ID, using = "login2")
    WebElement buttonLogin;
    @FindBy (how = How.XPATH, using = "/html/body/div[5]/div/div[1]/div/a[2]")
    WebElement categoryPhone;
    @FindBy (how = How.XPATH, using = "/html/body/div[5]/div/div[1]/div/a[4]")
    WebElement categoryMonitors;
    @FindBy (how = How.XPATH, using = "/html/body/div[5]/div/div[1]/div/a[3]")
    WebElement categoryLaptops;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void openSignUp(){
        signUpOption.click();
    }
    public void openCart(){
        cartOption.click();
    }

    public void waitHomeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        wait.until(ExpectedConditions.visibilityOf(categoriesLabel));
    }

    public void enterLoginPage() {
        buttonLogin.click();
    }
    public void enterCategoryPhone(){
        categoryPhone.click();
    }
    public void enterCategoryLaptops(){
        categoryLaptops.click();
    }
    public void enterCategoryMonitors(){
        categoryMonitors.click();
    }

}


