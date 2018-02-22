package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.SearchResultsPage;

public class SearchResultsTest extends BaseSteps {
    SearchResultsPage resultsPage = new SearchResultsPage(getDriverInstanceFor("optimus"));

    @Then("user adds a shoe to cart")
    public void addsShoeToCart() {
        resultsPage.selectSizeOfShoes();
        resultsPage.addItemToCart();
    }

    @Then("user verifies search results")
    public void verifySearchResults() {
        String getTitle = resultsPage.returnTitleOfFirstElement();
        String verifyTitle = resultsPage.returnTitleOfElementSelected();
        Assert.assertEquals(getTitle, verifyTitle);
    }

    @And("user navigates back")
    public void userNavigatesBck(){
        resultsPage.navigateBack();
    }
}

