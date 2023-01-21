package steps_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import page_objects.HomePage;
import page_objects.SignUpPage;

import java.time.Duration;
import static org.assertj.core.api.Assertions.assertThat;


public class SignUpSteps {
        private WebDriver driver;
        private HomePage homePage;
        private SignUpPage signUpPage;


        @Before
        public void setUp() {
            System.setProperty("web-driver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            homePage = new HomePage(driver);
        }


        @Given("User navigates to sign up form")
        public void user_navigates_to_sign_up_form() {
            driver.get("https://www.demoblaze.com/index.html");
            homePage.openSignUp();
        }

        @When("User fill in Username with {string}")
        public void user_fill_in_username_with(String username) {
            signUpPage = new SignUpPage(driver);
            signUpPage.fillUsername(username);
        }

        @And("User fill in Password with {string}")
        public void user_fill_in_password_with(String pass) {
            signUpPage.fillPass(pass);

        }
        @And("User  press Sign Up")
        public void userPressSignUp() {
            signUpPage.clickSignUp();
        }
        @Then("User should see {string} confirmation message")
        public void user_should_see_confirmation_message(String prompt) {

            assertThat(driver.switchTo().alert().getText()).isEqualTo(prompt);

            driver.switchTo().alert().accept();


        }

        @After
        public void tearDown() {
            driver.quit();
        }


}
