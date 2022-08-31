package com.demo.pages;


import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "2")
    public WebElement secondPage;

    @FindBy(xpath = "(//span[@class='followBtn'])[3]")
    public WebElement thirdProductAddToFavorites;

    @FindBy(xpath = "//a[@title='Hesabım']")
    public WebElement myAccount;

    @FindBy(xpath = "//a[@title='Favorilerim / Listelerim']")
    public WebElement myFavoritesAndLists;

    @FindBy(xpath = "(//h4[@class='listItemTitle'])[1]")
    public WebElement myFavoritesLink;

    @FindBy(xpath = "//span[.='Sil']")
    public WebElement deleteFromFavorites;

    @FindBy(xpath = "//span[@class='btn btnBlack confirm']")
    public WebElement deletedConfirmation;

    @FindBy(xpath = "//a[@class='logoutBtn']")
    public WebElement logout;

}
