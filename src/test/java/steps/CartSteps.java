package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;

public class CartSteps extends BaseSteps {
    CartPage cart = new CartPage(getDriverInstanceFor("optimus"));
    HomePage user = new HomePage(getDriverInstanceFor("optimus"));
    CheckoutPage checkoutPage = new CheckoutPage(getDriverInstanceFor("optimus"));

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
    public String userNavigatesToCartScreen() throws Throwable {
        user.clickOnCartIcon();
        String amount = cart.getCartValue();
        cart.proceedTocheckout();
        return amount;
    }

    @And("^user navigates to cart screen to pay bills and verify amount$")
    public void verifyAmount() throws Throwable {
        String amount = userNavigatesToCartScreen();
        String verifyAmount = checkoutPage.returnAmountInCheckoutPage();
        Assert.assertEquals(amount, verifyAmount);
    }
}
