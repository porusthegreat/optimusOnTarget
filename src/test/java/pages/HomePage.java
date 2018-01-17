package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
    private WebElement searchByCategory;

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void allowPermissions() {
        waitForElementToBeVisible(allowPermissionsBtn);
        allowPermissionsBtn.click();
    }

    public void searchByItem(String text) {
        waitForElementToBeClickable(searchIcon);
        searchIcon.click();
        sendKeys(searchField, text);
        waitForElementToBeVisible(productSuggestions.get(0));
        productSuggestions.get(0).click();
    }

    public void clickOnSearchByCategory() {
        waitForElementToBeVisible(searchByCategory);
        searchByCategory.click();
    }


}
