package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchedPage extends BasePage{

    @FindBy(xpath = "//div[@id='productsBlock']//div[@class='col s12']/h6")
    WebElement searchedText;

    @FindBy(xpath = "//div[@class='product-list']//li/a")
    WebElement firstProductLink;

    public String getSearchText(){
        return searchedText.getText();
    }

    public void clickOnFirstProduct(){
        firstProductLink.click();
    }
}
