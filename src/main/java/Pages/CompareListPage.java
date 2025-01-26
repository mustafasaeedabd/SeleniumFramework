package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareListPage extends  PageBase{
    public CompareListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = "div.page-title")
    public WebElement CompareProductsMessage ;


}
