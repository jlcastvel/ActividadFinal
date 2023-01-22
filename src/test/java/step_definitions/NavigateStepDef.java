package step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.HomePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class NavigateStepDef {

    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void Init() {
        System.setProperty("web-driver.chrome.driver", "src/test/resources/drivers");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
    }

    @Given("Usuario entra en la web")
    public void usuario_entra_en_la_web() {
        driver.get("https://www.demoblaze.com/index.html");
        Dimension d = new Dimension(800,1280);
        //Resize current window to the set dimension
        driver.manage().window().setSize(d);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @When("Usuario clica en {string} Phone")
    public void usuario_clica_en_phone(String string) {
        homePage.enterCategoryPhone();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("Usuario clica en {string} Laptops")
    public void usuario_clica_en_laptops(String string) {
        homePage.enterCategoryLaptops();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    ;
    @Then("Usuario clica en {string} Monitors")
    public void usuario_clica_en_monitors(String string) {
        homePage.enterCategoryMonitors();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


}