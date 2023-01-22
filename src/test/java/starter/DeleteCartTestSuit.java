package starter;

        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;
        import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"steps_definitions"},
        features = "src/test/resources/features/deleteFromCart.feature")
public class DeleteCartTestSuit {


}
