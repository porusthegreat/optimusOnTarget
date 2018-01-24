package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(id = "add_to_cart_button")
    private WebElement addToCartBtn;

    @FindBys(@FindBy(id = "pdp_v2_size_amount_variation_selected"))
    private List<WebElement> sizes;

    @FindBy(id = "sb__text")
    private WebElement successMessageOfCart;


    public SearchResultsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String returnTitleOfFirstElementInSearchResults() {
        waitForElementToBeVisible(searchResults.get(0));
        String str =  searchResults.get(0).getText();
        searchResults.get(0).click();
        waitForPageLoad();
        return str;
    }

    public String returnTitleOfElementSelected() {
        waitForElementToBeVisible(singleProductTitle);
        return singleProductTitle.getText();
    }

    public void selectSizeOfShoes() {
        scrollDownTo("delivery");
        waitForElementToBeVisible(sizes.get(0));
        sizes.get(0).click();

    }

    public void addItemToCart() {
        waitForElementToBeVisible(addToCartBtn);
        addToCartBtn.click();
    }
}
