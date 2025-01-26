package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "FullName")
    WebElement fullNameTxtBox ;
    @FindBy(id = "Email")
    WebElement  emailTxtBox;
    @FindBy(id = "Enquiry")
    WebElement enquiryMemo ;
    @FindBy(name ="send-email")
    WebElement submitBtn ;
    @FindBy (css = "div.result")
    public WebElement successMessage ;


    public void contactUs (String fullName , String enquiry) {
        setTextInElement(fullNameTxtBox, fullName);

        setTextInElement(enquiryMemo, enquiry);
        clickBtn(submitBtn);
    }
}

