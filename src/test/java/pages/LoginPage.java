package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
    private AppiumDriver driver;

    @FindBy(id = "gate_anonymous_login_button")
    private WebElement skipLoginBtn;

    @FindBy(id = "gate_login_button")
    private WebElement loginBtn;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"email address\"]")
    private WebElement emailField;

    @FindBy(xpath = "//android.view.View[@content-desc=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"sign in\"]")
    private WebElement signInBtn;

    @FindBy(xpath = "\"//*[contains(@content-desc, 'Sorry')]\"")
    private WebElement errorLogin;

    public LoginPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void skipLogin() {
        waitForElementToBeVisible(skipLoginBtn);
        skipLoginBtn.click();
    }

    public void clickOnLoginBtn(){
        waitForElementToBeClickable(loginBtn);
        loginBtn.click();
        waitForElementToBeVisible(emailField);
    }

    public String typeCredentials(String email, String pwd) {
        sendKeys(passwordField, pwd);
        sendKeys(emailField, email);
        signInBtn.click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return errorLogin.getAttribute("contentDescription");
    }
}
