package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage{
    private AppiumDriver driver;


    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    @FindBy(id = "custom_title")
    private WebElement pageTitle;

    @FindBy(id = "cart_product_overflow_menu")
    private List<WebElement> overflowMenuList;

    @FindBy(id = "title")
    private List<WebElement> options;

    @FindBy(id = "order_summary_subtotal_value")
    private WebElement cartValue;

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

    public String getCartValue(){
        scrollDownTo("subtotal");
        waitForElementToBeVisible(cartValue);
        return cartValue.getText();
    }

    public void emptyCartItems() {
        try {
            waitForElementToBeVisible(overflowMenuList.get(0));
            while (overflowMenuList.size() > 0) {
                overflowMenuList.get(0).click();
                waitForPageLoad();
                waitForElementToBeVisible(options.get(0));
                options.get(1).click();
                waitForPageLoad();
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("The cart is empty");
        }
    }
}
