package Pages;


import org.checkerframework.checker.units.qual.N;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends  PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
        // added object now, because I didn't it in "PageBase"page to get "scroll Down Btn" method.
        javascriptExecutor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registerBtn ;
    @FindBy(linkText = "Log in")
    public  WebElement LoginBtn ;
    @FindBy(linkText = "Log out")
    public   WebElement signOutBtn ;

    @FindBy (linkText =  "Contact us")
    WebElement ContactUSBtn ;
    @FindBy (id = "customerCurrency")
    WebElement currencyDrl;

    @FindBy (linkText = "Computers")
    WebElement computerMenu;
    @FindBy (linkText = "Notebooks")
    WebElement NotebooksOption ;

    public void OpenRegistrationPage (){
        registerBtn.click();
    }
    public void OpenLoginPage() {
        LoginBtn.click();
    }
    public void userLogOut (){
        clickBtn(signOutBtn);
    }
    public void openContactUsPage () {
        scrollDownBtn();
        ContactUSBtn.click();
    }
    public void changeCurrency () {
        select =  new Select(currencyDrl);
        select.selectByVisibleText("Euro");
    }
    public void SelectNoteBooksMenu () {
        clickBtn(computerMenu);
        actions.moveToElement(NotebooksOption).click().build().perform();
    }

}
