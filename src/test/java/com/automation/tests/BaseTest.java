package com.automation.tests;

import com.automation.pages.BagPage;
import com.automation.pages.HomePage;
import com.automation.pages.ProductPage;
import com.automation.pages.SearchedPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {

    HomePage homePage ;
    SearchedPage searchedPage;
    ProductPage productPage;
    BagPage bagPage;

    @BeforeMethod
    public void setup() throws IOException {
        ConfigReader.init();
        DriverManager.inti();

        searchedPage = new SearchedPage();
        productPage = new ProductPage();
        bagPage = new BagPage();
        homePage = new HomePage();
    }

    @AfterMethod
    public void close(){
        DriverManager.getDriver().quit();
    }



}
