package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class UserRegistrationTestWithDDTAndJavaFake extends TestBase {
    HomePage homeObject ;
    UserRegistrationPage registrationObject ;
    LoginPage loginPageObject ;

    Faker fake = new Faker();
    String firstName = fake.name().firstName();
    String lastName  = fake.name().lastName();
    String email = fake.internet().emailAddress();
    String password = fake.number().digits(8);
   // user register on system & verify from confirmation message display & verify from log in option.
    @Test (priority=1)
    public void userCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.OpenRegistrationPage();
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(firstName,lastName,email ,password , password);
        System.out.println("the user data :" +firstName+" "+lastName+" "+email+" "+password);
        System.out.println(registrationObject.successMessage.getText());
        Assert.assertTrue(registrationObject.successMessage.getText().equalsIgnoreCase("Your registration completed"));
        registrationObject.clickOnContinueBtn();
        System.out.println(homeObject.signOutBtn.getText());
        Assert.assertTrue(homeObject.signOutBtn.getText().contains("Log out"));
    }
    // user can log out successfully & verify from log in option appears.
    @Test (dependsOnMethods =  "userCanRegisterSuccessfully")
    public void userLogOut () {
        homeObject.userLogOut();
        System.out.println(homeObject.LoginBtn.getText());
        Assert.assertTrue(homeObject.LoginBtn.getText().contains("Log in"));
    }
    // user login into system & verify from sign out option.
    @Test (dependsOnMethods = "userLogOut")
    public void userLogin (){
        homeObject.OpenLoginPage();
        loginPageObject = new LoginPage(driver);
        loginPageObject.userLogin(email , password);
        System.out.println(homeObject.signOutBtn.getText());
        Assert.assertTrue(homeObject.signOutBtn.getText().contains("Log out"));
    }

//
//    public void run(){
//        driver.navigate().to("https://www.selenium.dev/");
//        WebElement logo = driver.findElement(By.id("Layer_1"));
//        System.out.println(logo.getText());
//        Assert.assertTrue(logo.isDisplayed());
//    }

}
