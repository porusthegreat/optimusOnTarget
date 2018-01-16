package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.concurrent.TimeUnit;

public class LaunchPage extends BasePage {
    private AppiumDriver driver;


    @FindBy(id = "first_run_get_started_button")
    private WebElement getStarted;


    public static final String MESSAGE = "Welcome to Optimus!! You are all ready to experience Automation like never before.";
    public LaunchPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void clickOnGetStartedButton() {
        waitForElementToBeVisible(getStarted);
        getStarted.click();
    }

    public void swipeRightOnLaunchScreen() throws InterruptedException {
        swipeRightToLeft();
        TimeUnit.SECONDS.sleep(1);
    }


}
