package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.LaunchPage;

public class LaunchActivitySteps extends BaseSteps {
    LaunchPage helloOptimusPage = new LaunchPage(getDriverInstanceFor("optimus"));

    @And("^user chooses to get started$")
    public void iGetAWelcomeMessageOnSuccessfulExecutionOfMyHelloOptimusProject() throws Throwable {
        helloOptimusPage.clickOnGetStartedButton();
    }

    @Given("^user is on landing page and swipes right to see all screens$")
    public void userSwipesRightOnLaunchingScreen() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            helloOptimusPage.swipeRightOnLaunchScreen();
        }
    }

    @And("user swipes left to see a previous screen")
    public void userSwipesLeftOnLaunchingScreen() throws InterruptedException {
        helloOptimusPage.swipeLeftOnLaunchScreen();
    }
}
