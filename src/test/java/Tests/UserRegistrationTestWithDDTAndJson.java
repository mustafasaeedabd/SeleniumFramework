package Tests;

import Data.JsonDataReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import com.google.gson.stream.JsonReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class UserRegistrationTestWithDDTAndJson extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registrationObject;
    LoginPage loginPageObject;

    // user register on system & verify from confirmation message display & verify from log in option.
    @Test(priority = 1)
    public void userCanRegisterSuccessfully() throws ParseException, IOException {


        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.JsonReader();

        homeObject = new HomePage(driver);
        homeObject.OpenRegistrationPage();
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(jsonReader.firstName ,jsonReader.lastName,
                jsonReader.email, jsonReader.password , jsonReader.password);
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
        loginPageObject.userLogin(jsonReader.email, jsonReader.password);
        System.out.println(homeObject.signOutBtn.getText());
        Assert.assertTrue(homeObject.signOutBtn.getText().contains("Log out"));
        homeObject.userLogOut();

    }
}
