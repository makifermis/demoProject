package com.demo.step_definitions;


import com.demo.pages.LoginPage;
import com.demo.pages.n11HomePage;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Login_StepDefinitions {

    com.demo.pages.n11HomePage n11HomePage = new n11HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("user clicks on sign in")
    public void user_clicks_on_sign_in() {
        n11HomePage.signIn.click();
    }
    @When("user sign in with Facebook credentials")
    public void user_sign_in_with_facebook_credentials() {
        n11HomePage.facebookSignInButton.click();

        //get all the opened windows handles
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        //System.out.println("windowHandles = " + windowHandles);

        // get your current windowHandle
        String mainWindowHandle =    Driver.getDriver().getWindowHandle();

        //to switch to window which we are NOT at
        for (String eachWindowHandle : windowHandles) {
            if (!eachWindowHandle.equals(mainWindowHandle)){
                Driver.getDriver().switchTo().window(eachWindowHandle);
            }
        }

        n11HomePage.onlyEssentialCookiesButton.click();

        loginPage.usernameBox.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButton.click();

        Driver.getDriver().switchTo().window(mainWindowHandle);


    }
    @Then("user should be logged in")
    public void user_should_be_logged_in() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        //use the "wait" object to create our expected condition
        wait.until(ExpectedConditions.titleIs("n11 - Hayat Sana Gelir"));

        Assert.assertTrue(n11HomePage.usernameElement.isDisplayed());
    }

}
