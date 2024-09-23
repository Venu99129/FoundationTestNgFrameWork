package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.ActionListener;
import java.beans.Visibility;
import java.time.Duration;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//div[@class='col s12 pname']")
    WebElement productText;

    @FindBy(xpath = "//a[normalize-space()='XL']")
    WebElement XLSize;

    @FindBy(xpath = "//button[@class='btn btn-large btn-100 waves-effect waves-light z-depth-0 orange darken-3 white-text']")
    WebElement addToBagButton;

    @FindBy(css = ".badge-cart")
    WebElement badgeNumber;

    @FindBy(xpath = "//span[text()='Bag']/../..")
    WebElement bagIcon;

    public boolean verifyProductPage(){
        // adding explicit wait
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(productText));

        return productText.isDisplayed();
    }

    public void selectSizeAsXL(){
        XLSize.click();
    }

    public void clickOnAddToBagButton(){
        addToBagButton.click();
    }

    public String getBadgeNumber(){
        return badgeNumber.getText();
    }

    public void clickOnBagIcon(){
        bagIcon.click();
    }
}
