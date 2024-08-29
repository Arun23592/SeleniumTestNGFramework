package org.qa.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    private final By myAccount = By.xpath("(//span[contains(text(),' My account')])[2]");
    private final By loginOption = By.xpath("//span[contains(text(),' Login')]");
    private final By emailId = By.id("input-email");
    private final By password = By.id("input-password");
    private final By loginBtn = By.xpath("//input[@type='submit']");
    private final By warningMessage = By.xpath("//div[contains(@class,'alert-danger')]");



    public void clickOnLoginOption(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccount));
        Actions act = new Actions(driver);
        act.moveToElement(find(myAccount)).perform();
        click(loginOption);
    }

    public void enterLoginUserEmailId(String email){
        type(emailId, email);
    }

    public void enterLoginUserPassword(String pwd){
        type(password, pwd);
    }

    public void clickOnLoginButton(){
        click(loginBtn);
    }

    public void loginWarningMessage(){
        String text = getText(warningMessage);
        System.out.println("Login warning message:  "+text);
    }
}
