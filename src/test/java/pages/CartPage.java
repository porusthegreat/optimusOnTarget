package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{
    private AppiumDriver driver;


    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    @FindBy(id = "custom_title")
    private WebElement pageTitle;

    public CartPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String proceedTocheckout(){
        waitForElementToBeVisible(checkoutBtn);
        checkoutBtn.click();
        waitForPageLoad();
        return pageTitle.getText();
    }
}
