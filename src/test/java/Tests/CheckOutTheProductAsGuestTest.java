package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CheckOutTheProductAsGuestTest extends TestBase{
    SearchPage searchPageObject ;
    productDetailsPage productDetailsPageObject ;
    ShoppingCartPage shoppingCartPageObject ;
    CheckOutPage checkOutAsGuestObject ;

    Random ran = new Random();
    int  n = ran.nextInt(1000) ;
    String fName = "Mohamed"+n  ;
    String lName = "Hassan"+n;
    String email = "mohamedhassan"+n+"@gmail.com" ;
    String productName  = "14.1-INCH LAPTOP";
    String city = "Alex" ;
    String address1 = city +"_address1";
    String code = "03";
    String PN = "01066336698";

    @Test(priority = 1)
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
        shoppingCartPageObject.CheckOutProduct();
        checkOutAsGuestObject = new CheckOutPage(driver);
        System.out.println(checkOutAsGuestObject.WelcomeMessage.getText());
        Assert.assertTrue(checkOutAsGuestObject.WelcomeMessage.getText()
                .contains("Welcome, Please Sign In!"));
        checkOutAsGuestObject.openCheckOutAsGuest();
        shoppingCartPageObject = new ShoppingCartPage(driver);
        System.out.println(shoppingCartPageObject.ShoppingCartTxt.getText());
        Assert.assertTrue(shoppingCartPageObject.ShoppingCartTxt.getText().
                contains("Shopping cart"));
    }
    @Test (priority = 3)
    public void userCanCheckedOutAsGuestSuccessfully () {
        checkOutAsGuestObject = new CheckOutPage(driver);
        checkOutAsGuestObject.BillingAddressAsGuest(fName,lName,email,city,address1,code,PN);
        checkOutAsGuestObject.ShippingAddress();
        checkOutAsGuestObject.PaymentMethodAndPaymentInformation();
        checkOutAsGuestObject.ConfirmOrder();
        System.out.println(checkOutAsGuestObject.YourOrderSuccessfullyMessage.getText());
        Assert.assertTrue(checkOutAsGuestObject.YourOrderSuccessfullyMessage.getText()
                .contains("Your order has been successfully processed!"));
        checkOutAsGuestObject.continueToCompleted();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl()
                , "https://demowebshop.tricentis.com/");

    }

}

