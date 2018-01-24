package steps;

import cucumber.api.java.en.And;
import org.junit.Assert;
import pages.CartPage;

public class CartSteps extends BaseSteps {

    @And("user proceeds to checkout")
    public void userChoosesToCheckout(){
        CartPage cart = new CartPage(getDriverInstanceFor("optimus"));
        String title = cart.proceedTocheckout();
        Assert.assertEquals(title, "checkout");
    }
}
