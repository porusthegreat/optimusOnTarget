package steps;

import cucumber.api.java.en.And;
import org.junit.Assert;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginSteps extends BaseSteps {

    LoginPage loginPage = new LoginPage(getDriverInstanceFor("optimus"));

    @And("user chooses to skip login")
    public void userChoosesToSkipLogin() {
        loginPage.skipLogin();
    }

    @And("user chooses to Login and gets error due to invalid credentials")
    public void userChoosesToLogin(){
        loginPage.clickOnLoginBtn();
        boolean error = loginPage.typeCredentials("cd@cp.co", "test123456");
        Assert.assertTrue(error);
    }

    @And("user logs in with valid credentials")
    public void userChoosesToLoginWithValidCredentials() throws InterruptedException {
        loginPage.clickOnLoginBtn();
        loginPage.typeValidCredentials("reddy@yopmail.com", "abcd@1234");
        TimeUnit.SECONDS.sleep(3);
    }
}
