package steps;

import cucumber.api.java.en.And;
import pages.HomePage;

public class HomePageTest extends BaseSteps {

    HomePage homePage = new HomePage(getDriverInstanceFor("optimus"));

    @And("^user allows required permissions$")
    public void userAllowsPermissionsRequired() {
        homePage.allowPermissions();
    }

    @And("^user searches by text$")
    public void userChoosesToSearchByItems() {
        homePage.searchByItem("pillows");
    }

    @And("user selects search by category")
    public void user_selects_search_by_category() {
        homePage.clickOnSearchByCategory();
    }
}
