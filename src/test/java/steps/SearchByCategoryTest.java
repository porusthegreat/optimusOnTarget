package steps;

import cucumber.api.java.en.Then;
import pages.SearchByCategoryPage;

public class SearchByCategoryTest extends BaseSteps {

    @Then("^user selects ([^\\\"]*) products$")
    public void userSelectsCategory(String text) {
        SearchByCategoryPage search = new SearchByCategoryPage(getDriverInstanceFor("optimus"));
        search.selectCategory(text);
    }
}
