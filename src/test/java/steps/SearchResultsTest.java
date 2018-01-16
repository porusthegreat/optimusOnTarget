package steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.SearchResultsPage;

public class SearchResultsTest extends BaseSteps {
    SearchResultsPage resultsPage = new SearchResultsPage(getDriverInstanceFor("optimus"));

    @Then("user verifies search results")
    public void verifySearchResults() throws InterruptedException {
        String getTitle = resultsPage.returnTitleOfFirstElementInSearchResults();
        String verifyTitle = resultsPage.returnTitleOfElementSelected();
        Assert.assertEquals(getTitle,verifyTitle);
        resultsPage.swipeVerticallyOnSearchScereen();
    }
}