package org.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class handleCheckBoxes {

    public static WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkBoxesTest(){

        driver.get("https://testautomationpractice.blogspot.com/");
        //locator

        WebElement DaysCheckBox = driver.findElement(By.xpath("(//input[@class='form-check-input' and @type='checkbox'])[1]"));

        //Actions

        selectCheckBox(DaysCheckBox);

        //Validate they are selected
        Assert.assertTrue(isCheckboxSelected(DaysCheckBox), "checkbox should be selected.");


    }

    // Reusable method to check if a checkbox is selected
    public boolean isCheckboxSelected(WebElement checkBox){
        return checkBox.isSelected();
    }

    // Reusable method to Select the checkbox
    public void selectCheckBox(WebElement checkBox){
        if(!isCheckboxSelected(checkBox)){
            checkBox.click();
        }

    }


    // Reusable method to deselect the checkbox
    public void deselectCheckBox(WebElement checkBox){
        if(isCheckboxSelected(checkBox)){
            checkBox.click();
        }
    }

}
