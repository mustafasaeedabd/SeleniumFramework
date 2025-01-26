package Tests;

import Data.ExcelReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class UserRegistrationTestWithDDTAndExcel extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registrationObject;
    LoginPage loginPageObject;

    @DataProvider(name = "ExcelData")
    public Object[][] userRegisterData() throws IOException {
        // get excel data from excel reader class.
        ExcelReader EX = new ExcelReader();
        return EX.getExcelData();
    }

    // user register on system & verify from confirmation message display & verify from log in option.
    @Test(priority = 1, dataProvider = "ExcelData")
    public void userCanRegisterSuccessfully(String firstName, String lastName, String email, String password) {
        homeObject = new HomePage(driver);
        homeObject.OpenRegistrationPage();
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(firstName, lastName, email, password, password);
        System.out.println(registrationObject.successMessage.getText());
        Assert.assertTrue(registrationObject.successMessage.getText().equalsIgnoreCase("Your registration completed"));
        registrationObject.clickOnContinueBtn();
        System.out.println(homeObject.signOutBtn.getText());
        Assert.assertTrue(homeObject.signOutBtn.getText().contains("Log out"));
        homeObject.userLogOut();
        homeObject.OpenLoginPage();
        loginPageObject = new LoginPage(driver);
        loginPageObject.userLogin(email, password);
        System.out.println(homeObject.signOutBtn.getText());
        Assert.assertTrue(homeObject.signOutBtn.getText().contains("Log out"));
        homeObject.userLogOut();

    }
}

