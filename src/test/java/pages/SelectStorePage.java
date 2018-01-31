package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectStorePage extends BasePage {

    private AppiumDriver driver;

    @FindBy(id = "action_list")
    private WebElement actionListImage;

    @FindBy(id = "map_search_bar")
    private WebElement mapSearchBar;

    @FindBy(id = "custom_title")
    private WebElement pageTitle;

    @FindBys(@FindBy(id = "map_search_suggestion_title"))
    private List<WebElement> searchSuggestions;

    @FindBy(id = "autocomplete_map_search")
    private WebElement mapSearchInputField;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'Bridgeton')]")
    private WebElement bridgetonStore;

    @FindBy(id = "set_store_checkbox")
    private WebElement setAsMystore;

    @FindBy(id = "dialog_close_button")
    private WebElement closeBtn;

    @FindBys(@FindBy(id = "store_list_item"))
    private List<WebElement> storeTitles;


    public SelectStorePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String returnPageTitle() {
        waitForElementToBeVisible(pageTitle);
        return pageTitle.getText();
    }

    public void selectAction() {
        waitForElementToBeClickable(actionListImage);
        actionListImage.click();
    }

    public void enterPincodeOfRegionAndSelectStore(String pinCode) {
        waitForElementToBeClickable(mapSearchBar);
        mapSearchBar.click();
        waitForElementToBeVisible(mapSearchInputField);
        sendKeys(mapSearchInputField, pinCode);
    }

    public void searchSuggestionSelect() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForElementToBeVisible(searchSuggestions.get(0));
        searchSuggestions.get(0).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForElementToBeVisible(storeTitles.get(0));
        storeTitles.get(0).click();
        waitForElementToBeVisible(setAsMystore);
        setAsMystore.click();
        navigateBack();
        navigateBack();
    }
}
