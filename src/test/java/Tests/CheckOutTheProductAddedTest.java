package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CheckOutTheProductAddedTest extends TestBase{
    String productName  = "14.1-INCH LAPTOP";
    SearchPage searchPageObject ;
    productDetailsPage productDetailsPageObject ;
    ShoppingCartPage shoppingCartPageObject ;
    UserRegistrationPage registrationObject ;
    HomePage homeObject ;
    CheckOutPage checkOutAsGuestObject ;
    Random ran = new Random();
    int  n = ran.nextInt(1000) ;
    String userNameTxt = "Mohamed"+n  ;
    String lastName = "Hassan"+n;
    String passwordTxt = "Mohamed@1000" +n;
    String emailTxt = "mohamedhassan"+n+"@gmail.com" ;
    String city = "Alex" ;
    String address1 = city +"_address1";
    String code = "03";
    String PN = "01066336698";
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
        try {
            shoppingCartPageObject.CheckOutProduct();
            checkOutAsGuestObject = new CheckOutPage(driver);
            System.out.println(checkOutAsGuestObject.WelcomeMessage.getText());
            Thread.sleep(500);
            Assert.assertTrue(checkOutAsGuestObject.WelcomeMessage.getText()
                    .contains("Welcome, Please Sign In!"));
        }catch (Exception e){
            System.out.println("Error occurred: "+e.getMessage() + " title : "+driver.getTitle());
        }
    }

    // user register on system & verify from confirmation message display & verify from log in option.
    @Test (priority=3)
    public void userCanRegisterSuccessfully(){
        checkOutAsGuestObject  = new CheckOutPage(driver);
        checkOutAsGuestObject.openRegisterPage();
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(userNameTxt,lastName,emailTxt ,passwordTxt , passwordTxt);
        System.out.println(registrationObject.successMessage.getText());
        Assert.assertTrue(registrationObject.successMessage.getText().equalsIgnoreCase("Your registration completed"));
        registrationObject.clickOnContinueBtn();
        shoppingCartPageObject = new ShoppingCartPage(driver);
        System.out.println(shoppingCartPageObject.ShoppingCartTxt.getText());
        Assert.assertTrue(shoppingCartPageObject.ShoppingCartTxt.getText().
                contains("Shopping cart"));
        shoppingCartPageObject.CheckOutProduct();
    }

    @Test (priority = 4)
    public void InsertCheckOutRequired(){
        checkOutAsGuestObject  = new CheckOutPage(driver);
        checkOutAsGuestObject.BillingAddress(city,address1,code,PN);
        checkOutAsGuestObject.ShippingAddress();
        checkOutAsGuestObject.PaymentMethodAndPaymentInformation();
        checkOutAsGuestObject.ConfirmOrder();
        System.out.println(checkOutAsGuestObject.YourOrderSuccessfullyMessage.getText());
        Assert.assertTrue(checkOutAsGuestObject.YourOrderSuccessfullyMessage.getText()
                .contains("Your order has been successfully processed!"));
        checkOutAsGuestObject.continueToCompleted();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://demowebshop.tricentis.com/");
    }
    @Test (priority = 5)
    public void LogOut (){
        homeObject = new HomePage(driver);
        homeObject.userLogOut();
        System.out.println(homeObject.LoginBtn.getText());
        Assert.assertTrue(homeObject.LoginBtn.getText().contains("Log in"));
    }
}
