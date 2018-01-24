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
        String shoeTitle = results.returnTitleOfFirstElementInSearchResults();
        String singleShoe = results.returnTitleOfElementSelected();
        Assert.assertEquals(shoeTitle, singleShoe);
    }

}
