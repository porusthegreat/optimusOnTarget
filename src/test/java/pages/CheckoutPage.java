package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.security.krb5.internal.PAData;

public class CheckoutPage extends BasePage {
    private AppiumDriver driver;

    @FindBy(id = "order_summary_subtotal_value")
    private WebElement amountToBeVerfied;

    public CheckoutPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String returnAmountInCheckoutPage(){
        waitForElementToBeVisible(amountToBeVerfied);
        return amountToBeVerfied.getText();
    }
}
