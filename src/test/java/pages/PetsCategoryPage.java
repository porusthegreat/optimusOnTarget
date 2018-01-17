package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PetsCategoryPage extends BasePage{
    private AppiumDriver driver;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Recipes for picky carnivores Made with real meat\"]")
    private WebElement recipeMeat;

    @FindBy(id = "custom_title")
    private WebElement pageTitle;

    public PetsCategoryPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String selectRecipeForPet(){
        waitForElementToBeVisible(recipeMeat);
        recipeMeat.click();
        return pageTitle.getText();
    }
}
