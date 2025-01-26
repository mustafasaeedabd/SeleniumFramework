package Tests;

import Pages.HomePage;
import Pages.SearchPage;
import Pages.productDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends TestBase {
    HomePage homePageObject;
    productDetailsPage productDetailsPageObject;
    String productName = "14.1-inch Laptop";
    SearchPage searchPageObject;

    @Test (priority = 1)
    public void UserCanChangeCurrency() {
        homePageObject = new HomePage(driver);
        homePageObject.changeCurrency();
    }

    @Test  (priority = 2)
    public void UserCanSearchUsingAutoSuggest() {
        try {
            searchPageObject = new SearchPage(driver);
            searchPageObject.productSearchUsingAutoSuggest("14.1-inch");
            productDetailsPageObject = new productDetailsPage(driver);
            System.out.println(productDetailsPageObject.productNameBreadCrumb.getText());
            Assert.assertEquals(productDetailsPageObject.productNameBreadCrumb.getText(), productName);
            System.out.println(productDetailsPageObject.productPriceLbl.getText());
            Assert.assertTrue(productDetailsPageObject.productPriceLbl.getText().contains("$"));
        } catch (Exception e) {
            System.out.println("Error occurred " + e.getMessage());
        }
    }
}
