package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{
    public EmailPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id = "FriendEmail")
    WebElement friendEmailTxtBox ;
    @FindBy (id = "YourEmailAddress")
    WebElement YourEmailAddressTxtBox ;
    @FindBy (id = "PersonalMessage")
    WebElement PersonalMessageMemo;
    @FindBy (css = "input.button-1.send-email-a-friend-button")
    WebElement sendEmailBtn ;
    @FindBy (css =  "div.result")
    public  WebElement sendMessageSuccess;

    public void sendEmailToFriend(String friendEmail , String PMessage) {
        setTextInElement(friendEmailTxtBox , friendEmail);
        setTextInElement(PersonalMessageMemo , PMessage);
        clickBtn(sendEmailBtn);
    }

}
