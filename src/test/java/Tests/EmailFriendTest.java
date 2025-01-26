package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class EmailFriendTest extends TestBase{
    HomePage homeObject ;
    UserRegistrationPage registrationObject ;
    SearchPage searchPageObject ;
    productDetailsPage productDetailsPageObject;
    EmailPage emailPageObject ;
    Random ran = new Random();
    int  n = ran.nextInt(1000) ;
    String userNameTxt = "Mohamed"+n  ;
    String lastName = "Hassan"+n;
    String passwordTxt = "Mohamed@1000" +n;
    String emailTxt = "mohamedhassan"+n+"@gmail.com" ;
    String productName = "14.1-inch Laptop" ;
    String emailOfFriend = "mohsen"+n+"@gmail.com";
    String expectedEmailMessage = "";

    @Test (priority = 1)  // user register on the system.
    public void userCanRegisterSuccessfully(){
        homeObject  = new HomePage(driver);
        homeObject.OpenRegistrationPage();
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(userNameTxt,lastName,emailTxt ,passwordTxt , passwordTxt);
        System.out.println(userNameTxt+" " +lastName+" "+emailTxt+" "+ passwordTxt);
        Assert.assertTrue(registrationObject.successMessage.getText().equalsIgnoreCase("Your registration completed"));
        registrationObject.clickOnContinueBtn();
        Assert.assertTrue(homeObject.signOutBtn.getText().contains("Log out"));
    }

    @Test (priority = 1)    // user search for product.
    public void userCanSearchAboutProduct () {
        searchPageObject = new SearchPage(driver);
        productDetailsPageObject = new productDetailsPage(driver);
        searchPageObject.productSearch(productName);
        searchPageObject.openProductDetails();
        System.out.println(productDetailsPageObject.productNameBreadCrumb.getText());
        Assert.assertTrue(productDetailsPageObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
        //     Assert.assertEquals(productdetailspage.productNameBreadCrumb.getText() , productName);
    }
    @Test (priority = 2)    // send mail to friend.
    public void RegisteredUserCanSendProductToFriend() {
        productDetailsPageObject.openEmailAFriendPage();
        emailPageObject = new EmailPage(driver);
        emailPageObject.sendEmailToFriend( emailOfFriend ,"Hello Eng.Mohsen, How are you.");
        System.out.println(emailPageObject.sendMessageSuccess.getText());
        Assert.assertEquals(emailPageObject.sendMessageSuccess.getText() , "Your message has been sent.");
    }

    @Test (priority = 3)// user logged out
    public void userLogOut () {
        homeObject = new HomePage(driver);
        homeObject.userLogOut();
        System.out.println(homeObject.LoginBtn.getText());
        Assert.assertTrue(homeObject.LoginBtn.getText().contains("Log in"));
    }
}
