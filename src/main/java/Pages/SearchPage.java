package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends  PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "small-searchterms" )
    WebElement searchTxtBox ;
    @FindBy(css = "input.button-1.search-box-button")
    WebElement searchBtn ;
    @FindBy(css="li.ui-menu-item")
    List<WebElement> productList ;
    @FindBy(linkText = "14.1-inch Laptop")
     WebElement productTitle ;


//    @FindBy(css ="")
//    WebElement pro
    public void productSearch (String productName) {
        setTextInElement(searchTxtBox , productName);
        clickBtn(searchBtn);
    }

    public void openProductDetails () {
        clickBtn(productTitle);
    }

    public void productSearchUsingAutoSuggest(String search) {
        setTextInElement(searchTxtBox , search);
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Search error is : " +e.getMessage());
        }
        // select first result appears
        productList.get(0).click();
    }

}
