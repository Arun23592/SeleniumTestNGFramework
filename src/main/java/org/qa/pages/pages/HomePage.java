package org.qa.pages.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private final By myAccount = By.xpath("(//span[contains(text(),' My account')])[2]");
    private final By continueButton = By.xpath("//div[@id='content']//a[text()='Continue']");



    public  RegisterAccountPage clickOnMyAccount(){
        click(myAccount);
        return new RegisterAccountPage();
    }

    public void clickOnContinueButton(){
        click(continueButton);
    }

}
