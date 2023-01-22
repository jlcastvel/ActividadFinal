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


public class LoginPage {
    private WebDriver driver;

    @FindBy(how = How.ID, using = "loginusername")
    WebElement buttonLoginName;

    @FindBy (how = How.ID, using = "loginpassword")
    WebElement buttonLoginPassword;

    @FindBy (how = How.XPATH, using = "/html/body/div[3]/div/div/div[3]/button[2]")
    WebElement buttonLogin;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void EnterName(String username){
        buttonLoginName.sendKeys(username + Keys.ENTER);
        }
    public void EnterPassword(String password){
        buttonLoginPassword.sendKeys(password + Keys.ENTER);
        }
    public void ClickLogin(){
        buttonLogin.click();
        }
    public void waitLoginVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        wait.until(ExpectedConditions.visibilityOf(buttonLoginName));
    }


    }

