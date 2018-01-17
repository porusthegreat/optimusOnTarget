package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchResultsPage extends BasePage {
    private AppiumDriver driver;

    @FindBys(@FindBy(id = "plp_v2_title"))
    private List<WebElement> searchResults;

    @FindBy(id = "pdp_v2_title_text")
    private WebElement singleProductTitle;

    @FindBy(id = "pdp_v2_fulfillment_display_text")
    private WebElement deliveryOptions;

    public SearchResultsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String returnTitleOfFirstElementInSearchResults() {
        waitForElementToBeVisible(searchResults.get(0));
        return searchResults.get(0).getText();
    }

    public String returnTitleOfElementSelected() {
        searchResults.get(0).click();
        waitForElementToBeVisible(singleProductTitle);
        return singleProductTitle.getText();
    }

    public void swipeVerticallyOnSearchScreen() throws InterruptedException {
        scrollTo("delivery");
    }

}
