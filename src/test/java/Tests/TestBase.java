package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase {
 public static WebDriver driver ;



    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(String browserName){
        if (browserName.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver" ,System.getProperty("user.dir"+ "/drivers/chromedriver.exe"));
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else  if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120 , TimeUnit.SECONDS);
        driver.navigate().to("https://demowebshop.tricentis.com/");
    }

    @AfterSuite
    public void closeDriver(){
         driver.quit();
    }
}
