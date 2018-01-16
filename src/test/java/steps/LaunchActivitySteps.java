package steps;

import cucumber.api.java.en.Given;
import pages.LaunchPage;

public class LaunchActivitySteps extends BaseSteps {
    LaunchPage helloOptimusPage = new LaunchPage(getDriverInstanceFor("optimus"));
    @Given("^user in on landing and chooses to get started$")
    public void iGetAWelcomeMessageOnSuccessfulExecutionOfMyHelloOptimusProject() throws Throwable {
        helloOptimusPage.clickOnGetStartedButton();
    }

    @Given("^user swipes right to see all screens$")
    public void userSwipesRightOnLaunchingScreen() throws InterruptedException {
        for(int i=0; i<4; i++) {
            helloOptimusPage.swipeRightOnLaunchScreen();
        }
    }
}
