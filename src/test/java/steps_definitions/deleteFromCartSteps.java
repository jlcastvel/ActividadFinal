package steps_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import libraries.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.CartPage;
import page_objects.HomePage;
import page_objects.ProductPage;

import java.time.Duration;
import java.util.List;

public class deleteFromCartSteps {
    private WebDriver driver;
    private WebDriverWait waiter;
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CommonFunctions env;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        env = new CommonFunctions();
        env.setUp(driver);
    }


    @Given("User adds product to cart {string}")
    public void user_adds_product_to_cart(String product1) {
        waiter = new WebDriverWait(driver, Duration.ofMillis(1000));

        driver.findElement(By.linkText(product1)).click();

        productPage = new ProductPage(driver);
        productPage.waitProductPageVisible();

        productPage.clickAddToCart();

        waiter.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

    }
    @When("User navigates to cart screen")
    public void user_navigates_to_cart_screen() {
        homePage.openCart();

        cartPage = new CartPage(driver);
        cartPage.waitCartVisible();

    }
    @And("User click on delete product {string}")
    public void user_click_on_delete_product(String product) {
        cartPage.deleteProduct(product);

    }
    @Then("User shall not see product {string} at cart")
    public void user_shall_not_see_product_at_cart(String string) {
        cartPage.waitCartVisible();
        cartPage.verifyNoProducts();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
