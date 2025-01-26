package Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UserRegistration {

    WebDriver driver;

    @Given("user open website")
    public void user_open_website (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

    }
    @When("User set all mandatory fields")
    public void User_set_all_mandatory_fields() {
         driver.findElement(By.id(""));
    }
    @Then("user should navigate in home page")
    public void user_should_navigate_in_home_page() {

    }
}
