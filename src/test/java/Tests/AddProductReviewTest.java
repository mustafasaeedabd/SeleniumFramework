package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AddProductReviewTest extends  TestBase{
    HomePage homeObject ;
    UserRegistrationPage registrationObject ;
    SearchPage searchPageObject ;
    productDetailsPage productDetailsPageObject ;
    ProductReviewPage ProductReviewTestObject ;
    Random ran = new Random();

    int  n = ran.nextInt(100000) ;
    String userNameTxt = "Mohamed"+n  ;
    String lastName = "Hassan"+n;
    String passwordTxt = "Mohamed@1000" +n;
    String emailTxt = "mohamedhassan"+n+"@gmail.com" ;
    String productName  = "14.1-INCH LAPTOP";
    String title  = "Good Work" ;
    String review =title + " Thanks, Eng. Mustafa";

    @Test(priority=1) // user register.
    public void userCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.OpenRegistrationPage();
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(userNameTxt,lastName,emailTxt ,passwordTxt , passwordTxt);
        System.out.println(registrationObject.successMessage.getText());
        Assert.assertTrue(registrationObject.successMessage.getText().equalsIgnoreCase("Your registration completed"));
        registrationObject.clickOnContinueBtn();
        System.out.println(homeObject.signOutBtn.getText());
        Assert.assertTrue(homeObject.signOutBtn.getText().contains("Log out"));
    }


    @Test  (priority = 2)  // user search for element needed.
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
    @Test (priority = 3)
    public void openReviewPage (){
        productDetailsPageObject.openAddYourReviewPage();
        ProductReviewTestObject = new ProductReviewPage(driver);
        ProductReviewTestObject.ClickOnAddProductReviewBtn(title , review);
        System.out.println(ProductReviewTestObject.reviewNotification.getText());
        Assert.assertTrue(ProductReviewTestObject.reviewNotification.getText()
                .contains("Product review is successfully added."));
    }
    @Test (priority = 4)
    public void userLogOut () {
        homeObject.userLogOut();
        System.out.println(homeObject.LoginBtn.getText());
        Assert.assertTrue(homeObject.LoginBtn.getText().contains("Log in"));
    }

}
