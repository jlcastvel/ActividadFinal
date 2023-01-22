package step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.HomePage;
import page_objects.ProductPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddProductStepDef {

    private WebDriver driver;

    private ProductPage productPage;

    private HomePage homePage;


    @Before
    public void Init() {
        System.setProperty("web-driver.chrome.driver", "src/test/resources/drivers");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);


    }

    @Given("Usuario entra en la web en categoria moviles")
    public void usuario_entra_en_la_web_en_categoria_moviles() {
        driver.get("https://www.demoblaze.com/index.html");
        Dimension d = new Dimension(800, 1280);
        //Resize current window to the set dimension
        driver.manage().window().setSize(d);
        homePage.enterCategoryPhone();

    }

    @When("Elige un movil A {string}")
    public void elige_un_movil_a(String product1) {
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
        driver.findElement(By.linkText(product1)).click();
        productPage = new ProductPage(driver);
        productPage.pressCart();
    }

    @Then("Se confirma que se añade la compra")
    public void se_confirma_que_se_añade_la_compra() {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
        waiter.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        productPage.pressHomePage();
    }


    @When("Elige un movil B {string}")
    public void elige_un_movil_b(String product2) {
        homePage.enterCategoryPhone();
        driver.findElement(By.linkText(product2)).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        productPage.pressCart();
    }

    @Then("Se confirma que se añade la compra 2")
    public void se_confirma_que_se_añade_la_compra_2() {
        driver.switchTo().alert().accept();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        productPage.pressHomePage();
    }


    @When("Elige un portatil {string}")
    public void elige_un_portatil(String product3) {
        homePage.enterCategoryLaptops();
        driver.findElement(By.linkText(product3)).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        productPage.pressCart();
    }

    @Then("Se confirma que se añade la compra 3")
    public void se_confirma_que_se_añade_la_compra_3() {
        driver.switchTo().alert().accept();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        productPage.pressHomePage();
    }
}