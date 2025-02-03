package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
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
        }
        else  if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
            // headless Browser testing.
        else if (browserName.equalsIgnoreCase("headless")){
            DesiredCapabilities  caps = new DesiredCapabilities ();
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY ,
                   System.getProperty("user.dir")+"\\drivers\\phantomjs.exe");
            String[] phantomJsArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS , phantomJsArgs);
            driver = new PhantomJSDriver(caps);
        }
        else if (browserName.equalsIgnoreCase("chrome-headless")) {
            WebDriverManager.edgedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size-1920,1080");
            driver = new ChromeDriver(options);
        }
        else if (browserName.equalsIgnoreCase("edge")) {
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
