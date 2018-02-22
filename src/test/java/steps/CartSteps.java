package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.junit.Assert;
import pages.CartPage;
import pages.HomePage;

public class CartSteps extends BaseSteps {
    CartPage cart = new CartPage(getDriverInstanceFor("optimus"));
    HomePage user = new HomePage(getDriverInstanceFor("optimus"));

    @And("user proceeds to checkout")
    public void userChoosesToCheckout() {
        String title = cart.proceedTocheckout();
        Assert.assertEquals(title, "checkout");
    }

    @And("user navigates and deletes cart items")
    public void deleteCartItems() {
        user.clickOnCartIcon();
        cart.emptyCartItems();
    }

    @And("^user navigates to cart screen to pay bills$")
    public void userNavigatesToCartScreen() throws Throwable {
        user.clickOnCartIcon();
        cart.proceedTocheckout();
    }
}
