package org.qa.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class RegisterAccountPage extends BasePage{

    private final By firstName = By.id("input-firstname");
    private final By lastName = By.id("input-lastname");
    private final By email = By.id("input-email");
    private final By phone = By.id("input-telephone");
    private final By password = By.id("input-password");
    private final By passwordConfirm = By.id("input-confirm");
    private final By agreeCheckBox = By.xpath("//label[@for='input-agree']");
    private final By registrationContinueButton = By.xpath("//input[@type='submit']");
    private final By registerSuccessMessage = By.xpath("//h1[@class='page-title my-3']");
    private final By myAccount = By.xpath("(//span[contains(text(),' My account')])[2]");
    private final By logout = By.xpath("//div[@id='widget-navbar-217834']//span[contains(text(), 'Logout')]");



    public void enterFirstName(){
      type(firstName, "Arun");

    }

    public void enterLastName(){
        type(lastName, "Subramani");

    }



    public void enterEmail(){
        type(email, generateRandomEmail());

    }


    public void enterPhone(){
        type(phone, "994027866");

    }

    public void enterPassword(){
        type(password, "Pass@1234");

    }

    public void enterConfirmPassword(){
        type(passwordConfirm, "Pass@1234");

    }

    public void clickOnReadandAgreeCheckBox(){
        click(agreeCheckBox);
    }

    public void clickOnRegistrationContinueButton(){
        click(registrationContinueButton);
    }

    public void RegistrationSuccessMessage(){
        String text = getText(registerSuccessMessage);
        System.out.println("Registration Success message: "+text);
    }

    public void clickOnLogoutButton(){
        Actions act = new Actions(driver);
         act.moveToElement(find(myAccount)).perform();
         click(logout);
    }
}
