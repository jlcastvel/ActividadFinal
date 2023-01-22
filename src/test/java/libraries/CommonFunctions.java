package libraries;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import page_objects.HomePage;
import page_objects.SignUpPage;


public class CommonFunctions {

    public CommonFunctions(){}

    public void setUp(WebDriver driver) {
        System.setProperty("web-driver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().setSize(new Dimension(1200, 800));
    }

    public void sleep(int time) {
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }


}