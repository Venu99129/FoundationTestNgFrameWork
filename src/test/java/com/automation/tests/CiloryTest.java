package com.automation.tests;

import com.automation.utils.AllureReportManager;
import com.automation.utils.ExtendReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CiloryTest extends BaseTest{

    @Test
    public void productAddToBagTest() throws IOException {

        homePage.goToWebSuite();

        Assert.assertTrue(homePage.verifyHomePage());

        // log and adding screenshots in report of assert
        ExtendReportManager.getTest().info("homepage is verified !");
        ExtendReportManager.addScreenshot();
        AllureReportManager.attachScreenshot();
        AllureReportManager.attachLog("homePage is verified !");

        String searchText = "t shirt men";
        homePage.searchOnSearchBar(searchText);

        Assert.assertTrue(searchedPage.getSearchText().contains(searchText));
        //log and screenShot of assert
        ExtendReportManager.getTest().info("searched page  is verified with your search text ");
        ExtendReportManager.addScreenshot();
        AllureReportManager.attachScreenshot();
        AllureReportManager.attachLog("searched page  is verified with your search text ");

        searchedPage.clickOnFirstProduct();

        Assert.assertTrue(productPage.verifyProductPage());

        //logs
        ExtendReportManager.getTest().info("product page is verified !");
        AllureReportManager.attachLog("product page is verified !");

        productPage.selectSizeAsXL();
        productPage.clickOnAddToBagButton();

        String numOfAddProd = productPage.getBadgeNumber();

        // assert with 1 we added only one product
        Assert.assertEquals("1" , numOfAddProd);
        // logs and screenshots
        ExtendReportManager.getTest().info("checked the badge icon number");
        ExtendReportManager.addScreenshot();
        AllureReportManager.attachScreenshot();
        AllureReportManager.attachLog("checked the badge icon number");

        productPage.clickOnBagIcon();

        Assert.assertFalse(bagPage.verifyBagPage());


        ExtendReportManager.getTest().info("verified product price and sub total price are equal");
        ExtendReportManager.addScreenshot();
        AllureReportManager.attachScreenshot();
        AllureReportManager.attachLog("verified product price and sub total price are equal");


    }

}
