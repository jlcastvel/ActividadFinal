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


}
