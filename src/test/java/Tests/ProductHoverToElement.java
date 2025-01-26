package Tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductHoverToElement extends TestBase{

    HomePage homePageObject ;

    @Test
    public void UserCanSelectSubCategoryFromMainMenu() {
        homePageObject = new HomePage(driver);
        homePageObject.SelectNoteBooksMenu();
        try{
            Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));

        }catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        }
    }


}
