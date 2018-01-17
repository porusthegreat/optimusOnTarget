package steps;

import cucumber.api.java.en.And;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps extends BaseSteps {

    LoginPage loginPage = new LoginPage(getDriverInstanceFor("optimus"));

    @And("user chooses to skip login")
    public void userChoosesToSkipLogin() {
        loginPage.skipLogin();
    }

    @And("user chooses to Login and gets error due to invalid credentials")
    public void userChoosesToLogin(){
        loginPage.clickOnLoginBtn();
        String error = loginPage.typeCredentials("reddy@yopmail.com", "test123456");
        Assert.assertEquals(error,
                "Sorry, either your e-mail or password didn't match what we have on file. Try it again?");
    }
}
