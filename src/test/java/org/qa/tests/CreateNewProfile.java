package org.qa.tests;


import org.qa.pages.pages.BasePage;
import org.qa.pages.pages.HomePage;
import org.qa.pages.pages.RegisterAccountPage;
import org.testng.annotations.Test;

public class CreateNewProfile extends BaseTest{

    HomePage homePage = new HomePage();
    BasePage basePage = new BasePage();

    RegisterAccountPage registerAccountPage = new RegisterAccountPage();
    @Test
    public void test1_createNewProfile(){
        extentTest = extentReports.createTest("Verify user complete the registration form for create new profile");
        basePage.setDriver(driver);
          extentTest.info("Click on My Account option");
          homePage.clickOnMyAccount();
          extentTest.info("Click on Continue button");
          homePage.clickOnContinueButton();
          extentTest.info("Enter the first name");
          registerAccountPage.enterFirstName();
          extentTest.info("Enter the last name");
          registerAccountPage.enterLastName();
          extentTest.info("Enter the email id");
          registerAccountPage.enterEmail();
          extentTest.info("Enter the phone number");
          registerAccountPage.enterPhone();
          extentTest.info("Enter the password");
          registerAccountPage.enterPassword();
          extentTest.info("Enter the confirm password");
          registerAccountPage.enterConfirmPassword();
          extentTest.info("Click on Read and Agree check box");
          registerAccountPage.clickOnReadandAgreeCheckBox();
          extentTest.info("Click on Registration continue button");
          registerAccountPage.clickOnRegistrationContinueButton();
          extentTest.info("Rregistration success message is displayed");
          registerAccountPage.RegistrationSuccessMessage();
          extentTest.info("Click on Logout button");
          registerAccountPage.clickOnLogoutButton();


    }
}
