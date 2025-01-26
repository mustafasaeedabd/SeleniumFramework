package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.collections.functors.WhileClosure;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class UserRegistrationTestWithDDTAndCSV extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registrationObject;
    LoginPage loginPageObject;

    CSVReader csvreader;

//    Random ran = new Random();
//    int  n = ran.nextInt(1000) ;
//    String userNameTxt = "Mohamed"+n  ;
//    String lastName = "Hassan"+n;
//    String passwordTxt = "Mohamed@1000" +n;
//    String emailTxt = "mohamedhassan"+n+"@gmail.com" ;

    // user register on system & verify from confirmation message display & verify from log in option.
    @Test(priority = 1)
    public void userCanRegisterSuccessfully() throws IOException, CsvValidationException {
        String csv_file = System.getProperty("user.dir") + "\\src\\test\\java\\Data\\userdata.csv";
        csvreader = new CSVReader(new FileReader(csv_file));
        String[] csvCel;

        while ((csvCel = csvreader.readNext()) != null) {
            String firstName = csvCel[0];
            String lastName = csvCel[1];
            String email = csvCel[2];
            String password = csvCel[3];
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
            System.out.println(homeObject.LoginBtn.getText());
            Assert.assertTrue(homeObject.LoginBtn.getText().contains("Log in"));
            homeObject.OpenLoginPage();
            loginPageObject = new LoginPage(driver);
            loginPageObject.userLogin(email, password);
            System.out.println(homeObject.signOutBtn.getText());
            Assert.assertTrue(homeObject.signOutBtn.getText().contains("Log out"));
            homeObject.userLogOut();
        }
    }
}