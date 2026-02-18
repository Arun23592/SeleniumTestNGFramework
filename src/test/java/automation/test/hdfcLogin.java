package automation.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(hdfcLogin.class);
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
        System.out.println("STEP 1: Launching HDFC Bank website");
        driver.get("https://www.hdfcbank.com");

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    @Test
    public void LoginHDFC(){


        //2. Mouse hover on Login
        System.out.println("STEP 2: Clicking on Login button");
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Login']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(loginBtn).perform();


        //3. Click on Login
        loginBtn.click();
        log.info("2. User Clicked on Login button");

        JavascriptExecutor js = (JavascriptExecutor) driver;


        //wait for dropdown container
        System.out.println("Login dropdown should now be visible");

        System.out.println("STEP 3: Waiting for login dropdown container");
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-ddwrap show']")));

//        Actions actions1 = new Actions(driver);
//        actions1.moveToElement(dropdown).perform();

        //4. Click on Know More
        System.out.println("STEP 4: Locating 'Know more' under Credit Card Portal");
        WebElement knowMore = dropdown.findElement(By.xpath("(//a[@title='Know more'][normalize-space()='Know more'])[3]"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", knowMore);
        System.out.println("STEP 5: Scrolling into view");


        System.out.println("STEP 6: Clicking on 'Know more'");

        wait.until(ExpectedConditions.elementToBeClickable(knowMore)).click();

        System.out.println("'Know more' clicked successfully");

    }

//    @AfterClass
//    public void tearDown(){
//        if(driver != null){
//            driver.quit();
//        }
//    }

}


