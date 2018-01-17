package steps;

import cucumber.api.java.en.And;
import org.junit.Assert;
import pages.PetsCategoryPage;
import pages.SearchResultsPage;

public class PetsCategoryTest extends BaseSteps {

    @And("user selects a recipe for pets")
    public void selectRecipeForPets(){
        PetsCategoryPage pets = new PetsCategoryPage(getDriverInstanceFor("optimus"));
        String title = pets.selectRecipeForPet();
        Assert.assertEquals(title,"Made with real meat");
        SearchResultsPage results = new SearchResultsPage(getDriverInstanceFor("optimus"));
        String recipeTitle = results.returnTitleOfFirstElementInSearchResults();
        String singleRecipe = results.returnTitleOfElementSelected();
        Assert.assertEquals(recipeTitle, singleRecipe);
    }

}
