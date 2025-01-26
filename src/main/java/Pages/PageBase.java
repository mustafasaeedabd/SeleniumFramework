package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageBase {
    public JavascriptExecutor javascriptExecutor ;
    protected WebDriver driver ;
    public Select select ;
    public Actions actions ;


    // Create constructor
    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver , this);
    }
    public void clickBtn (WebElement button){
        button.click();
    }
    public void setTextInElement (WebElement element,String value ) {
        element.sendKeys(value);
    }
    public void scrollDownBtn() {
        javascriptExecutor.executeScript("scrollBy(0,2500)");
    }
    public void acceptCookie (WebElement element) {
        element.click();
    }
    public void waitingElementToClick (WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15)) ;
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }
    public void Enter (WebElement element){
        element.sendKeys(Keys.ENTER);
    }

}
