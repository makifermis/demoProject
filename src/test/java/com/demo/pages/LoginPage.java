package com.demo.pages;

import com.demo.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "email")
    public WebElement usernameBox;

    @FindBy(name = "pass")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginButton;


}
