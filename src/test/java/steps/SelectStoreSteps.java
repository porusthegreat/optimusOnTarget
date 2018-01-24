package steps;

import cucumber.api.java.en.And;
import org.junit.Assert;
import pages.SelectStorePage;

public class SelectStoreSteps extends BaseSteps {

    SelectStorePage select = new SelectStorePage(getDriverInstanceFor("optimus"));

    @And("user enters the ([^\\\"]*) and selects a store")
    public void selectStoreByPinCode(String pin) {
        Assert.assertEquals(select.returnPageTitle(), "store locator");
        select.selectAction();
        select.enterPincodeOfRegionAndSelectStore(pin);
        select.searchSuggestionSelect();
    }
}
