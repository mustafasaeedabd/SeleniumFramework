package Tests;

import Pages.SearchPage;
import Pages.productDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends  TestBase {

    String productName = "14.1-inch Laptop" ;
    SearchPage searchPageObject ;
    productDetailsPage productDetailsPageObject;

    @Test
    public void userCanSearchAboutProduct () {
        searchPageObject = new SearchPage(driver) ;
        productDetailsPageObject = new productDetailsPage(driver);
        searchPageObject.productSearch(productName);
        searchPageObject.openProductDetails();
        System.out.println(productDetailsPageObject.productNameBreadCrumb.getText());
        Assert.assertTrue(productDetailsPageObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
   //     Assert.assertEquals(productdetailspage.productNameBreadCrumb.getText() , productName);
    }



}
