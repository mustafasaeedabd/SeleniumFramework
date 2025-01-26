package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Shopping cart")
    public WebElement ShoppingCartTxt ;
    @FindBy(name = "removefromcart")
    WebElement removeFromCartOption;
    @FindBy(name = "updatecart")
    WebElement updateCartBtn;
    @FindBy(css = "div.order-summary-content")
    public WebElement YourShoppingCartIsEmptyMessage ;
    @FindBy(id = "termsofservice")
    WebElement TermsOfServiceOption ;
    @FindBy(id = "checkout")
    WebElement CheckOutBtn;

    public void RemoveTheCart() {
        clickBtn(removeFromCartOption);
        clickBtn(updateCartBtn);
    }
    public void CheckOutProduct (){
        clickBtn(TermsOfServiceOption);
        clickBtn(CheckOutBtn);
    }
}
