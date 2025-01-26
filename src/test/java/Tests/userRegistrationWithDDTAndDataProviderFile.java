package Tests;

import Data.LoadProperties;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.Random;


public class userRegistrationWithDDTAndDataProviderFile extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registrationObject;
    LoginPage loginPageObject;
    Random ran = new Random();
    int n = ran.nextInt(1000);
    String firstNameTxt = LoadProperties.userdata.getProperty("firstname");
    String lastName = LoadProperties.userdata.getProperty("lastname");
    String passwordTxt = LoadProperties.userdata.getProperty("password");
    String emailTxt =  LoadProperties.userdata.getProperty("email");

    public userRegistrationWithDDTAndDataProviderFile() throws FileNotFoundException {
    }

    // user register on system & verify from confirmation message display & verify from log in option.
    @Test (priority=1)
    public void userCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.OpenRegistrationPage();
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(firstNameTxt,lastName,emailTxt ,passwordTxt , passwordTxt);
        System.out.println(registrationObject.successMessage.getText());
        Assert.assertTrue(registrationObject.successMessage.getText().equalsIgnoreCase("Your registration completed"));
        registrationObject.clickOnContinueBtn();
        System.out.println(homeObject.signOutBtn.getText());
        Assert.assertTrue(homeObject.signOutBtn.getText().contains("Log out"));

        homeObject.userLogOut();
        System.out.println(homeObject.LoginBtn.getText());
        Assert.assertTrue(homeObject.LoginBtn.getText().contains("Log in"));

        homeObject.OpenLoginPage();
        loginPageObject = new LoginPage(driver);
        loginPageObject.userLogin(emailTxt , passwordTxt);
        System.out.println(homeObject.signOutBtn.getText());
        Assert.assertTrue(homeObject.signOutBtn.getText().contains("Log out"));
    }

}