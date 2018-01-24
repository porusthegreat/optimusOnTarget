package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import javax.naming.Context;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
    private AppiumDriver driver;

    @FindBy(id = "gate_anonymous_login_button")
    private WebElement skipLoginBtn;

    @FindBy(id = "gate_login_button")
    private WebElement loginBtn;

    @FindBy(id = "username")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement signInBtn;

    @FindBy(id = "alertMessage")
    private WebElement errorLogin;

    @FindBy(id = "button")
    private WebElement returnToAppBtn;

    public LoginPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void skipLogin() {
        waitForElementToBeVisible(skipLoginBtn);
        skipLoginBtn.click();
    }

    public void clickOnLoginBtn() {
        waitForElementToBeClickable(loginBtn);
        loginBtn.click();
        waitForPageLoad();
        waitForElementToBeVisible(emailField);
    }

    public String typeCredentials(String email, String pwd) {
        sendKeys(emailField, email);
        sendKeys(passwordField, pwd);
        signInBtn.click();
        waitForPageLoad();
        waitForElementToBeVisible(errorLogin);
        return errorLogin.getText();
    }

    public void typeValidCredentials(String email, String pwd){
        sendKeys(emailField, email);
        sendKeys(passwordField, pwd);
        signInBtn.click();
        waitForPageLoad();
        waitForElementToBeVisible(returnToAppBtn);
        returnToAppBtn.click();
    }
}
