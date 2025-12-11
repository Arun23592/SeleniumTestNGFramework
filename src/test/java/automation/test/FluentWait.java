package automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWait {
    public static WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/dynamic-prop.php");
    }

    @Test
    public void dynamicProperties(){
        WebElement colorBtn = driver.findElement(By.id("colorChange"));
        colorBtn.click();

        //FluentWait for "Visible after 5 seconds" Button - Use Fluent wait over explcit wait
        Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        WebElement visibleBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        visibleBtn.click();
        System.out.println("Clicked visible button!");


    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

}




/*
*
*
* 𝐀𝐮𝐭𝐨𝐦𝐚𝐭𝐞 𝐃𝐲𝐧𝐚𝐦𝐢𝐜 𝐖𝐞𝐛𝐄𝐥𝐞𝐦𝐞𝐧𝐭𝐬 𝐔𝐬𝐢𝐧𝐠 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 + 𝐉𝐚𝐯𝐚

Dynamic elements that appear, enable, or change after a delay can easily break UI tests if not handled properly.
So I created a simple demo showing how to automate such scenarios using FluentWait in Selenium.

This script waits for the “Visible After 5 Seconds” button using polling and timeout logic, making the test more stable than a basic explicit wait.

A clean way to handle delayed or changing UI elements in Selenium + Java.

*
*
* */