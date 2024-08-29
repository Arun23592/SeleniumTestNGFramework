package org.qa.tests;

import org.qa.pages.pages.BasePage;
import org.qa.pages.pages.HomePage;
import org.qa.pages.pages.LoginPage;
import org.qa.pages.pages.SearchProductPage;
import org.testng.annotations.Test;

public class SearchProductTest extends BaseTest{
    SearchProductPage searchProductPage = new SearchProductPage();
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();

    @Test
    public void test3_SearchProducts(){
        extentTest = extentReports.createTest("Verify user should be able to search products");
        basePage.setDriver(driver);
        extentTest.info("Click on login option");
        loginPage.clickOnLoginOption();
        extentTest.info("Enter user email id");
        loginPage.enterLoginUserEmailId("arunsubramani20@gmail.com");
        extentTest.info("Enter password");
        loginPage.enterLoginUserPassword("Arun@2351992");
        extentTest.info("Click on Login button");
        loginPage.clickOnLoginButton();
        extentTest.info("Select the category from the dropdown");
        searchProductPage.selectCategoryFromDropdown();
        extentTest.info("Search product from search box");
        searchProductPage.searchForTheProduct("Apple");
        extentTest.info("Click on search button");
        searchProductPage.clickOnSearchButton();
    }
}
