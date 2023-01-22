package steps_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import libraries.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.CartPage;
import page_objects.HomePage;
import page_objects.OrderPage;
import page_objects.ProductPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class placeAndPurchaseSteps {
    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;
    WebDriverWait waiter;
    ProductPage productPage;
    OrderPage orderPage;
    CommonFunctions env;

    private String HomeLinkText = "index.html";
    
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        env = new CommonFunctions();
        env.setUp(driver);
    }

    @Given("User adds some products to cart {string} {string} {string}")
    public void user_adds_some_products_to_cart(String product1, String product2, String product3) {
        waiter = new WebDriverWait(driver, Duration.ofMillis(1000));

        //add product1
        driver.findElement(By.linkText(product1)).click();

        productPage = new ProductPage(driver);
        productPage.waitProductPageVisible();

        productPage.clickAddToCart();

        waiter.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        //add product2
        //driver.findElement(By.linkText(HomeLinkText)).click();
        //homePage.waitHomeVisible();


    }
    @And("User clicks on place order")
    public void user_clicks_on_place_order() {
        homePage.openCart();

        cartPage = new CartPage(driver);
        cartPage.waitCartVisible();
        cartPage.clickPlaceOrder();


        orderPage = new OrderPage(driver);
        orderPage.waitOrderVisible();
    }
    @And("User fulfill order form from place order screen")
    public void user_fulfill_order_form_from_place_order_screen() {
        orderPage.fillPlaceOrderForm();
    }
    @And("User clicks on purchase")
    public void user_clicks_on_purchase() {
        orderPage.clickPurchase();
        orderPage.waitPurchaseOkVisible();
    }


    @Then("User should see {string}  message")
    public void userShouldSeeMessage(String message) {
        assertThat( driver.findElement(By.xpath("/html/body/div[10]/h2")).getText()).isEqualTo(message);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
