package automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OracleLogin {

    public static void main(String[] args) {
        // This is a placeholder for the Oracle login test
        System.out.println("Oracle Login Test Placeholder");

        // Here you would typically initialize your WebDriver, navigate to the Oracle login page,
        // perform the login actions, and validate the login success.

        // Example:
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://hcwt.login.us2.oraclecloud.com/");
        // Perform login actions...
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='userid']"));
        usernameField.sendKeys("arunsubramani");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("123445");

        WebElement selectLanguagedropDown = wait.until(ExpectedConditions.elementToBeClickable(By.name("Languages")));

        Select langSelect = new Select(selectLanguagedropDown);
        langSelect.selectByVisibleText("English");
        //click on login button
        WebElement logInButton = driver.findElement(By.id("btnActive"));
        logInButton.click();


    }
}
