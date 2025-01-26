package Tests;

import Pages.SearchPage;
import Pages.ShoppingCartPage;
import Pages.productDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddThenRemoveProductToShoppingCartTest extends TestBase{
    productDetailsPage productDetailsPageObject ;
    ShoppingCartPage shoppingCartPageObject ;

    String productName  = "14.1-INCH LAPTOP";
    SearchPage searchPageObject ;

    @Test (priority = 1)
    public void UserCanSearchUsingAutoSuggest () {
        try {
            searchPageObject = new SearchPage(driver);
            searchPageObject.productSearchUsingAutoSuggest("14.1-inch");
            productDetailsPageObject = new productDetailsPage(driver);
            System.out.println(productDetailsPageObject.productNameBreadCrumb.getText());
            Assert.assertEquals(productDetailsPageObject.productNameBreadCrumb.getText() , productName);
        } catch (Exception e) {
            System.out.println("Error occurred " + e.getMessage());
        }
    }
    @Test (priority = 2)
    public void CheckOnProductShoppingCart (){
        productDetailsPageObject = new productDetailsPage(driver);
        productDetailsPageObject.clickAddToShoppingCartBtn();
        System.out.println(productDetailsPageObject.AddShoppingCartMessage.getText());
        productDetailsPageObject.openShoppingCartPage();
        shoppingCartPageObject  = new ShoppingCartPage(driver);
        System.out.println(shoppingCartPageObject.ShoppingCartTxt.getText());
        Assert.assertTrue(shoppingCartPageObject.ShoppingCartTxt.
                getText().contains("Shopping cart"));
    }
    @Test (priority = 3)
    public void RemoveProductFromShoppingCart (){
        shoppingCartPageObject  = new ShoppingCartPage(driver);
        shoppingCartPageObject.RemoveTheCart();
        System.out.println(shoppingCartPageObject.YourShoppingCartIsEmptyMessage.getText());
        shoppingCartPageObject.YourShoppingCartIsEmptyMessage.getText().
                equalsIgnoreCase("Your Shopping Cart is empty!");
    }



}
