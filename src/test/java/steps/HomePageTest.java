package steps;

import cucumber.api.java.en.And;
import pages.HomePage;

public class HomePageTest extends BaseSteps{

    HomePage homePage = new HomePage(getDriverInstanceFor("optimus"));

    @And("^user allows required permissions$")
    public void userAllowsPermissionsRequired(){
        homePage.allowPermissions();
    }
    @And("^user searches by text$")
    public void userChoosesToSearchByItems(){
        homePage.searchByItem("pillows");
    }
}
