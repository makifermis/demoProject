package com.demo.step_definitions;


import com.demo.pages.SearchPage;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class Add_Delete_Favorites_StepDefinition {

    Actions actions;
    SearchPage searchPage = new SearchPage();

    @When("user clicks on second page")
    public void user_clicks_on_second_page() {
        searchPage.secondPage.click();
    }

    @When("adds the third product into favorites")
    public void adds_the_third_product_into_favorites() {
        searchPage.thirdProductAddToFavorites.click();
        actions = new Actions(Driver.getDriver());

        actions.moveToElement(searchPage.myAccount).perform();

        searchPage.myFavoritesAndLists.click();

    }

    @Then("deletes the product from favorites")
    public void deletes_the_product_from_favorites() {

        searchPage.myFavoritesLink.click();
        searchPage.deleteFromFavorites.click();
        searchPage.deletedConfirmation.click();

    }

    @Then("user logs out")
    public void userLogsOut() {

        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].click();",searchPage.logout);
    }
}
