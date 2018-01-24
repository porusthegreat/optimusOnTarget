package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchByCategoryPage extends BasePage {
    private AppiumDriver driver;

    @FindBys(@FindBy(id = "skyfeed_cell_title"))
    private List<WebElement> categotyList;

    public SearchByCategoryPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectCategory(String text) {
        scrollDownTo(text);
        for (WebElement category : categotyList) {
            if (category.getText().equals(text)) {
                category.click();
                break;
            }
        }
        waitForPageLoad();
    }
}
