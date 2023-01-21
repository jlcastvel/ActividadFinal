package page_objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    private WebDriver driver;
    @FindBy(how = How.ID, using = "sign-username")
    WebElement usernameField;
    @FindBy(how = How.ID, using = "sign-password")
    WebElement passField;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div[3]/button[2]")
    WebElement signUpButton;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillUsername(String username){
        usernameField.sendKeys(username + Keys.ENTER);
    }
    public void fillPass(String pass){
        passField.sendKeys(pass + Keys.ENTER);
    }
    public void clickSignUp(){
        signUpButton.click();
    }
}
