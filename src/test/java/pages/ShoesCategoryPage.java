package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoesCategoryPage extends BasePage {
    private AppiumDriver driver;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Recipes for picky carnivores Made with real meat\"]")
    private WebElement recipeMeat;

    @FindBy(id = "custom_title")
    private WebElement pageTitle;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"women's shoes\"]")
    private WebElement shoesForWomen;

    @FindBy(xpath = "//android.widget.FrameLayout[contains(@content-desc, 'Bring in spring')]")
    private WebElement springCollection;

    public ShoesCategoryPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String returnPageTitle() {
        waitForElementToBeVisible(pageTitle);
        return pageTitle.getText();
    }

    public void clickOnWomenCategory() {
        waitForElementToBeVisible(shoesForWomen);
        shoesForWomen.click();
        waitForPageLoad();
    }

    public void selectNewYearStyles() {
        waitForElementToBeVisible(springCollection);
        springCollection.click();
        waitForPageLoad();
    }
}
