package steps;

import cucumber.api.java.en.And;
import org.junit.Assert;
import pages.ShoesCategoryPage;
import pages.SearchResultsPage;

public class ShoesCategorySteps extends BaseSteps {

    @And("user selects an Item")
    public void selectRecipeForPets(){
        ShoesCategoryPage shoes = new ShoesCategoryPage(getDriverInstanceFor("optimus"));
        String title = shoes.returnPageTitle();
        Assert.assertEquals(title,"shoes");
        shoes.clickOnWomenCategory();
        shoes.selectNewYearStyles();
        SearchResultsPage results = new SearchResultsPage(getDriverInstanceFor("optimus"));
        String shoeTitle = results.returnTitleOfFirstElementInSearchResults(0);
        String singleShoe = results.returnTitleOfElementSelected();
        Assert.assertEquals(shoeTitle, singleShoe);
    }

    @And("user selects items to add to cart")
    public void searchResults(){
        SearchResultsPage results = new SearchResultsPage(getDriverInstanceFor("optimus"));
        for(int i =0; i<2; i++) {
            String title = results.returnTitleOfFirstElementInSearchResults(i);
            String title2 = results.returnElementTitle();
            Assert.assertEquals(title, title2);
            results.navigateBack();
        }

    }

}
