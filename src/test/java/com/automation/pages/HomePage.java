package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//h5[text()='Best Sellers']")
    WebElement bestSellerText;

    @FindBy(id = "search")
    WebElement searchBar;

    public void goToWebSuite(){
        driver.get(ConfigReader.getPropertyValue("base.url"));
    }

    public boolean verifyHomePage(){
        return bestSellerText.isDisplayed();
    }

    public void searchOnSearchBar(String text){

        searchBar.click();
        searchBar.sendKeys(text);
        searchBar.sendKeys(Keys.ENTER);
    }


}
