package Tests;

import Pages.CompareListPage;
import Pages.SearchPage;
import Pages.productDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCompareListTest extends TestBase{

    String productName  = "14.1-INCH LAPTOP";
    SearchPage searchPageObject ;
    productDetailsPage productDetailsPageObject ;
    CompareListPage compareListPageObject;


    @Test (priority = 1)
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

    @Test (priority = 2)
    public void UserCanAddProductToCompare(){
        productDetailsPageObject.openAddToComparePage();
        compareListPageObject = new CompareListPage(driver);
        System.out.println(compareListPageObject.CompareProductsMessage.getText());
        Assert.assertTrue(compareListPageObject.CompareProductsMessage.getText().contains("Compare products"));
    }


}
