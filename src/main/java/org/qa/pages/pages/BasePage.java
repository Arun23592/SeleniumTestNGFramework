package org.qa.pages.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    public static WebDriver driver;

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void dropDownList(By locator){
        List<WebElement> options =  driver.findElements(locator);
        for (WebElement option : options) {
            if (option.getText().equals("Tablets")) {
                option.click();

            }

        }
    }

    protected void click(By locator){
        find(locator).click();
    }

    protected void type(By locator, String text){
        find(locator).sendKeys(text);
    }


    protected String generateRandomEmail(){
        return RandomStringUtils.random(4, true, true) + "@gmail.com";
    }


    protected String getText(By locator){
        String text = find(locator).getText();
//        System.out.println("Registration Success message: "+text);
        return text;
    }



}
