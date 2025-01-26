package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends  PageBase {

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "gender-male")
    WebElement maleOption ;
    @FindBy(id = "FirstName")
    WebElement firstNameTxtBox;
    @FindBy(id = "LastName")
    WebElement LastNameTxtBox;
    @FindBy(id = "Email")
    WebElement emailTxtBox;

    @FindBy(id ="Password")
    WebElement passwordTxtBox;
    @FindBy(id = "ConfirmPassword")
    WebElement ConfirmPasswordTxtBox ;
    @FindBy(id ="register-button")
    WebElement registerBtn;
    @FindBy (css = "div.result")
    public WebElement successMessage ;
    @FindBy(linkText ="Log out")
    public   WebElement signOutBtn ;
    @FindBy (css = "input.button-1.register-continue-button")
    WebElement continueBtn ;


    public void userRegistration(String firstName,String lastName ,
                                 String email,String password, String confirmPassword) {
        clickBtn(maleOption);
        setTextInElement(firstNameTxtBox, firstName);
        setTextInElement(LastNameTxtBox , lastName);
        setTextInElement(emailTxtBox, email);
        setTextInElement(passwordTxtBox, password);
        setTextInElement(ConfirmPasswordTxtBox , confirmPassword);
        clickBtn(registerBtn);

    }
    public void clickOnContinueBtn (){
        clickBtn(continueBtn);
    }

}