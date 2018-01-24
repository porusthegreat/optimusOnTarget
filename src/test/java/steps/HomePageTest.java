package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
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

    @And("user chooses to change store")
    public void userChoosesToSelectStore(){
        homePage.userChoosesToChangeStore();
    }

    @Then("user verifies the store title")
    public void verifyStoreTitle(){
        String storeTitle = homePage.getStoreTitle();
        Assert.assertEquals(storeTitle, "Mankato");
    }

    @Then("user chooses to logout")
    public void userChoosesToLogout() throws InterruptedException {
        homePage.clickOnSignOutBtn();
    }
}
