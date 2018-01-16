package steps;

import cucumber.api.java.en.And;
import pages.LoginPage;

public class LoginSteps extends BaseSteps {

    @And("user chooses to skip login")
    public void userChoosesToSkipLogin(){
        LoginPage loginPage = new LoginPage(getDriverInstanceFor("optimus"));
        loginPage.skipLogin();
    }
}
