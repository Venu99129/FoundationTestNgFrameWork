package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagPage extends BasePage{

    @FindBy(css = ".light")
    WebElement bagText;

    @FindBy(xpath = "//p[@class='no-wrap']/b")
    WebElement productPrice;

    @FindBy(xpath = "//div[text()='Subtotal']/following-sibling::div")
    WebElement subTotalPrice;

    public boolean verifyBagPage(){
        return bagText.isDisplayed();
    }

    public boolean verifyPrices(){
        String productPriceStr = productPrice.getText().substring(1);
        String subTotalPriceStr = subTotalPrice.getText().substring(1);

        return productPriceStr.equals(subTotalPriceStr);
    }

}
