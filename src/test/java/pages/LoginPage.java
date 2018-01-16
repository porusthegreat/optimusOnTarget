package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    private AppiumDriver driver;

    @FindBy(id = "gate_anonymous_login_button")
    private WebElement skipLogin;

    public LoginPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void skipLogin(){
        waitForElementToBeVisible(skipLogin);
        skipLogin.click();
    }

}
