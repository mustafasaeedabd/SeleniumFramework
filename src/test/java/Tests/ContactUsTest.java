package Tests;

import Pages.ContactUsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends  TestBase{
    ContactUsPage contactUsPageObject ;
    HomePage homePageObject ;
    String fullName = "Test user" ;
    String email  = "test@test.com" ;
    String enquiry = "Hello Admin, this is for you";

    @Test (priority = 1)
    public void contactUs () {
        homePageObject = new HomePage(driver);
        homePageObject.openContactUsPage();
        contactUsPageObject = new ContactUsPage(driver);
        contactUsPageObject.contactUs(fullName  , enquiry);
        System.out.println(contactUsPageObject.successMessage.getText());
        Assert.assertTrue (contactUsPageObject.successMessage.getText().
                contains("Your enquiry has been successfully sent to the store owner."));
    }
    @Test (priority = 2)// user logged out
    public void userLogOut () {
        homePageObject = new HomePage(driver);
        homePageObject.userLogOut();
        System.out.println(homePageObject.LoginBtn.getText());
        Assert.assertTrue(homePageObject.LoginBtn.getText().contains("Log in"));
    }
}

