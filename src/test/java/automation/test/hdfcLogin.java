package automation.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

/**
 * 1.	Open HDFC Bank website
 * 	2.	Mouse hover on Login
 * 	3.	Click on Login
 * 	4.	Click on Know More
 * 	5.	Capture all the language texts displayed
 *
 *
 *
 * */

public class hdfcLogin {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //1.	Open HDFC Bank website
        driver.get("https://www.hdfcbank.com");

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    @Test
    public void LoginHDFC(){

//        try{
//            driver.findElement(By.xpath("//div[@class='popup-close']")).click();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        //2. Mouse hover on Login
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".loginWrapdesktopToggle button")));
        Actions actions = new Actions(driver);
        actions.moveToElement(loginBtn).perform();

        //3. Click on Login
        loginBtn.click();

        //4. Click on Know More
        WebElement knowMore = driver.findElement(By.xpath("(//div[@class='reg-know-btn']//a[@href='/stay-secure/verified-by-visa-mastercard-securecode'])[last()]"));
        knowMore.click();

    }

//    @AfterClass
//    public void tearDown(){
//        if(driver != null){
//            driver.quit();
//        }
//    }

}


