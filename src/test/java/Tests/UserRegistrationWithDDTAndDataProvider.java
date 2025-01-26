package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Random;


public class UserRegistrationWithDDTAndDataProvider extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registrationObject;
    LoginPage loginPageObject;


    @DataProvider(name = "testData")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"Mohamed", "Mustafa", "testuserxx"+n+"xx@gmail.com", "123456"},
                {"Ahmed", "Ali", "testuser12"+n+"@gmail.com", "1245678"}
        };
    }


    Random ran = new Random();
    int n = ran.nextInt(1000);


    // user register on system & verify from confirmation message display & verify from log in option.
    @Test(priority = 1, dataProvider = "testData")
    public void userCanRegisterSuccessfully(String firstNameTxt, String lastName,
                                            String emailTxt, String passwordTxt) {
        homeObject = new HomePage(driver);
        homeObject.OpenRegistrationPage();
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(firstNameTxt, lastName, emailTxt, passwordTxt, passwordTxt);
        System.out.println(registrationObject.successMessage.getText());
        Assert.assertTrue(registrationObject.successMessage.getText().equalsIgnoreCase("Your registration completed"));
        registrationObject.clickOnContinueBtn();
        System.out.println(homeObject.signOutBtn.getText());
        Assert.assertTrue(homeObject.signOutBtn.getText().contains("Log out"));

        homeObject.userLogOut();//userLogout
        System.out.println(homeObject.LoginBtn.getText());
        Assert.assertTrue(homeObject.LoginBtn.getText().contains("Log in"));

        homeObject.OpenLoginPage(); //userLogin
        loginPageObject = new LoginPage(driver);
        loginPageObject.userLogin(emailTxt, passwordTxt);
        System.out.println(homeObject.signOutBtn.getText());
        Assert.assertTrue(homeObject.signOutBtn.getText().contains("Log out"));
        homeObject.userLogOut();//userLogout
        System.out.println(homeObject.LoginBtn.getText());
        Assert.assertTrue(homeObject.LoginBtn.getText().contains("Log in"));
    }
}