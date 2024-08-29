package org.qa.tests;

import org.qa.pages.pages.BasePage;
import org.qa.pages.pages.HomePage;
import org.qa.pages.pages.LoginPage;
import org.qa.pages.pages.RegisterAccountPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    RegisterAccountPage registerAccountPage = new RegisterAccountPage();
    LoginPage loginPage = new LoginPage();


    @Test(priority = 1)
    public void test2_LoginFunctionality(){

        extentTest = extentReports.createTest("Verify user should be able to Login successully");
        basePage.setDriver(driver);;
        extentTest.info("Click on Login option");
        loginPage.clickOnLoginOption();
        extentTest.info("Enter user mail id ");
        loginPage.enterLoginUserEmailId("arunsubramani20@gmail.com");
        extentTest.info("Enter user password");
        loginPage.enterLoginUserPassword("Arun@2351992");
        extentTest.info("Click on Login Button");
        loginPage.clickOnLoginButton();
        extentTest.info("Click on Logout Button");
        registerAccountPage.clickOnLogoutButton();

    }

    @Test(priority = 2)
    public void test2_InValidLoginFunctionality(){
        extentTest = extentReports.createTest("Verify user should not be able to Login");
        basePage.setDriver(driver);
        extentTest.info("Click on Login option");
        loginPage.clickOnLoginOption();
        extentTest.info("Enter invalid user Id");
        loginPage.enterLoginUserEmailId("arunsubramani200@gmail.com");
        extentTest.info("Enter invalid user password");
        loginPage.enterLoginUserPassword("Arun@2351000");
        extentTest.info("Click on Login Button");
        loginPage.clickOnLoginButton();
        extentTest.info("Warning message is displayed");
        loginPage.loginWarningMessage();

    }
}
