package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productDetailsPage extends  PageBase{
    public productDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="strong.current-item")
    public WebElement productNameBreadCrumb ;
    @FindBy(css = "input.button-2.email-a-friend-button")
    WebElement EmailAFriendBtn;
    @FindBy (linkText ="Add your review")
    WebElement AddYourReviewBtn ;
    @FindBy (css = "span.price-value-4")
    public WebElement productPriceLbl ;
    @FindBy (css = "input.button-2.add-to-compare-list-button")
    WebElement AddToCompareBtn;
    @FindBy (id = "add-to-cart-button-31")
    WebElement AddToShoppingCartBtn ;
    @FindBy(css = "p.content")
    public WebElement AddShoppingCartMessage ;
    @FindBy (linkText = "shopping cart")
    public WebElement ShoppingCartBtn;

    public void openEmailAFriendPage () {
        clickBtn(EmailAFriendBtn);
    }
    public void openAddYourReviewPage () {
        clickBtn(AddYourReviewBtn);
    }
    public void openAddToComparePage() {
        clickBtn(AddToCompareBtn);
    }
    public void clickAddToShoppingCartBtn () {
        clickBtn(AddToShoppingCartBtn);
    }
    public void openShoppingCartPage () {
        clickBtn(ShoppingCartBtn);
    }
}
