package com.demo.step_definitions;



import com.demo.pages.n11HomePage;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class n11_Home_Page_StepDefinitions {

    com.demo.pages.n11HomePage n11HomePage = new n11HomePage();

    @When("user is on n11 home page")
    public void user_is_on_n11_home_page() {
        Driver.getDriver().get("https://www.n11.com/");
    }
    @Then("user should see title contains n11")
    public void user_should_see_title_contains_n11() {

        Assert.assertTrue(Driver.getDriver().getTitle().contains("n11"));
    }

    @When("user types {string} and clicks enter")
    public void user_types_and_clicks_enter(String string) {
        n11HomePage.searchBox.sendKeys(string + Keys.ENTER);
    }

    @Then("user sees {string} in the page title")
    public void user_sees_in_the_page_title(String string) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }


}
