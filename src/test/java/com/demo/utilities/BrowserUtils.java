package com.demo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

        /*
    This method will accept int (in seconds) and execute Thread.sleep for given duration
     */

    public static void sleep(int second){
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch(InterruptedException e){

        }
    }

    /*
    This method accepts 3 arguments
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String;
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle){

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {
            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL:" + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        //5. Assert: Title contains “expectedTitle”
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    /*
    This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }

    /*
    Creating a utility method for ExplicitWait so we don't have to repeat lines. When we use explicit wait, implicitly wait method will be out of order
     */
    public static void waitForInvisibilityOf(WebElement webElement){

        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));

    }

    /**
     * This method will accept a String as expected value and verify actual URL CONTAINS the value.
     * @param expectedInURL
     */
    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    /**
     * This method will accept a dropdown as a WebElement
     * and return all the options' text in a List of String
     * @param dropdownElement
     * @return List<String> actualOptionsAsString
     */

    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);
        // List of all ACTUAL month <options> as a web element
        List<WebElement> actualOptionsAsWebElement = select.getOptions();
        // List of all ACTUAL month <options> as a string
        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement eachWebElement : actualOptionsAsWebElement) {
            actualOptionsAsString.add(eachWebElement.getText());
        }

        return actualOptionsAsString;
    }

}
