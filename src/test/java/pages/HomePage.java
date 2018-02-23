package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
    private AppiumDriver driver;

    @FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private WebElement allowPermissionsBtn;

    @FindBy(id = "shop_expanded_top_toolbar_search_icon")
    private WebElement searchIcon;

    @FindBy(id = "search_field")
    private WebElement searchField;

    @FindBys(@FindBy(id = "prd_search_suggestion_title"))
    private List<WebElement> productSuggestions;

    @FindBy(id = "skyfeed_cell_title")
    private List<WebElement> searchByCategories;

    @FindBy(id = "shop_expanded_top_toolbar_subtitle")
    private WebElement selectStore;

    @FindBy(id = "menu_account")
    private WebElement accountBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
    private WebElement moreOptionsBtn;

    @FindBy(xpath = "//*[contains(@text, 'sign out')]")
    private WebElement signOutBtn;

    @FindBy(id = "cart_icon")
    private WebElement cartBtn;


    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void allowPermissions() {
        try {
            waitForElementToBeVisible(allowPermissionsBtn);
            allowPermissionsBtn.click();
        }catch (TimeoutException e ){
            e.printStackTrace();
        }
    }

    public void searchByItem(String text) {
        waitForElementToBeClickable(searchIcon);
        searchIcon.click();
        sendKeys(searchField, text);
        waitForElementToBeVisible(productSuggestions.get(0));
        productSuggestions.get(0).click();
        waitForPageLoad();
    }

    public void clickOnSearchByCategory() {
        waitForElementToBeVisible(searchByCategories.get(0));
        searchByCategories.get(0).click();
        waitForPageLoad();
    }

    public void userChoosesToChangeStore() {
        waitForElementToBeVisible(selectStore);
        selectStore.click();
    }

    public String getStoreTitle() {
        return selectStore.getText();
    }


    public void clickOnSignOutBtn() throws InterruptedException {
        waitForElementToBeVisible(accountBtn);
        accountBtn.click();
        waitForElementToBeVisible(moreOptionsBtn);
        moreOptionsBtn.click();
        waitForElementToBeVisible(signOutBtn);
        signOutBtn.click();
        TimeUnit.SECONDS.sleep(3);
    }

    public void clickOnCartIcon() {
        waitForElementToBeVisible(cartBtn);
        cartBtn.click();
        waitForPageLoad();
    }

    public void scrollDownToEnd(){
        int height = driver.manage().window().getSize().getHeight();
        new TouchAction(driver).press(5, height * 3 / 5)
                .waitAction(Duration.ofMillis(1000))
                .moveTo(5, height / 4)
                .release().perform();
    }
}
