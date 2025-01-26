package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.PageBase;
import Pages.UserRegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class UserRegistrationTest extends TestBase {
    HomePage homeObject ;
    UserRegistrationPage registrationObject ;
    LoginPage loginPageObject ;


    Random ran = new Random();
    int  n = ran.nextInt(1000) ;
    String userNameTxt = "Mohamed"+n  ;
    String lastName = "Hassan"+n;
    String passwordTxt = "Mohamed@1000" +n;
    String emailTxt = "mohamedhassan"+n+"@gmail.com" ;

   // user register on system & verify from confirmation message display & verify from log in option.
    @Test (priority=1)
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
        loginPageObject.userLogin(emailTxt , passwordTxt);
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
