package Tests;

import Pages.SearchPage;
import Pages.productDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProjectUsingAutoSuggest extends TestBase{

    String productName  = "14.1-INCH LAPTOP";
    SearchPage searchPageObject ;
    productDetailsPage productDetailsPageObject ;

    @Test
    public void UserCanSearchUsingAutoSuggest () {
        try {
            searchPageObject = new SearchPage(driver);
            searchPageObject.productSearchUsingAutoSuggest("14.1-inch");
            productDetailsPageObject = new productDetailsPage(driver);
            System.out.println(productDetailsPageObject.productNameBreadCrumb.getText());
            Assert.assertEquals(productDetailsPageObject.productNameBreadCrumb.getText() , productName);
        } catch (Exception e) {
            System.out.println("Error occurred " + e.getMessage());
        }
    }
}
