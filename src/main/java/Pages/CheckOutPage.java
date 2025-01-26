package Pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id = "BillingNewAddress_FirstName")
    WebElement firstNameTxtBox ;
    @FindBy (id = "BillingNewAddress_LastName")
    WebElement lastNameTxtBox;
    @FindBy(id = "BillingNewAddress_Email")
    WebElement emailTxtBox ;
    @FindBy(css = "input.button-1.register-button")
    WebElement registerBtn ;
    @FindBy(css = "div.page-title")
    public WebElement WelcomeMessage;
    @FindBy (id = "BillingNewAddress_CountryId")
    WebElement country ;
    @FindBy (id = "BillingNewAddress_City")
    WebElement CityTxtBox ;
    @FindBy (id = "BillingNewAddress_Address1")
    WebElement Address1TxtBox;
    @FindBy (id = "BillingNewAddress_ZipPostalCode")
    WebElement ZipPostalCodeTxtBox;
    @FindBy (id = "BillingNewAddress_PhoneNumber")
    WebElement PhoneNumberTxtBox;
    @FindBy (css = "input.button-1.new-address-next-step-button")
    WebElement continueBtn ;
    @FindBy(xpath = "//*[@id='shipping-buttons-container']/input")
    WebElement continueBtn2;
    @FindBy(xpath = "//*[@id='payment-method-buttons-container']/input")
    WebElement paymentMethodContinueBtn ;
    @FindBy (css = "input.button-1.confirm-order-next-step-button")
    WebElement  confirmContinueBtn;
    @FindBy (xpath = "//*[@id='payment-info-buttons-container']/input")
    WebElement paymentInfoContinueBtn ;
    @FindBy (id = "PickUpInStore")
    WebElement PickUpInStoreOption ;
    @FindBy (css = "div.title")
    public WebElement YourOrderSuccessfullyMessage;
    @FindBy (css = "input.button-2.order-completed-continue-button")
    WebElement continueToCompletedBtn ;
    @FindBy (css = "input.button-1.checkout-as-guest-button")
    WebElement CheckOutAsGuestBtn ;


    public void openRegisterPage() {
        clickBtn(registerBtn);
    }
    public void selectTheCountry() {
        select = new Select(country);
        select.selectByValue("31");
    }
    public void BillingAddress (String city ,String add1 ,String code ,String PhN) {
        selectTheCountry();
        setTextInElement(CityTxtBox , city);
        setTextInElement(Address1TxtBox , add1);
        setTextInElement(ZipPostalCodeTxtBox , code);
        setTextInElement(PhoneNumberTxtBox , PhN);
        clickBtn(continueBtn);
    }
    public void ShippingAddress () {
        clickBtn(PickUpInStoreOption);
        waitingElementToClick(continueBtn2);
    }
    public void PaymentMethodAndPaymentInformation() {
        clickBtn(paymentMethodContinueBtn);
        clickBtn(paymentInfoContinueBtn);
    }
    public void ConfirmOrder(){
       clickBtn(confirmContinueBtn);
    }
    public void continueToCompleted (){
        clickBtn(continueToCompletedBtn);
    }
    public void openCheckOutAsGuest () {
       clickBtn(CheckOutAsGuestBtn);
    }
    public void BillingAddressAsGuest(String fName ,String lName,String email,
                                      String city , String add1, String code, String PhN) {
        setTextInElement(firstNameTxtBox , fName);
        setTextInElement(lastNameTxtBox ,lName);
        setTextInElement(emailTxtBox , email);
        selectTheCountry();
        setTextInElement(CityTxtBox , city);
        setTextInElement(Address1TxtBox , add1);
        setTextInElement(ZipPostalCodeTxtBox , code);
        setTextInElement(PhoneNumberTxtBox , PhN);
        clickBtn(continueBtn);
    }



}
