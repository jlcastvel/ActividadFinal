package step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.HomePage;
import page_objects.LoginPage;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;


public class LoginStepDef {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;



    @Before
      public void Init(){
        System.setProperty("web-driver.chrome.driver", "src/test/resources/drivers");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);


    }

    @Given("Abrir sitio web")
    public void abrir_sitio_web() {
       driver.get("https://www.demoblaze.com/index.html");
       Dimension d = new Dimension(800,1280);
       //Resize current window to the set dimension
       driver.manage().window().setSize(d);
       homePage.enterLoginPage();
       loginPage.waitLoginVisible();

    }

    @When("Se escriben las credenciales usando para usuario {string} y para contraseña {string}")
    public void se_escriben_las_credenciales_usando_para_usuario_y_para_contraseña(String username, String password) {
        loginPage.EnterName(username);
        loginPage.EnterPassword(password);


    }



    @Then("El usuario clica en Login y se logea")
    public void el_usuario_clica_en_login_y_se_logea() {
        loginPage.ClickLogin();
    }
}


