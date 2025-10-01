package automation.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerifyTextInLandingPage {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        userNameField.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
        signIn.click();

        WebElement dashboardText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        String actualText = dashboardText.getText();
        String expectedText = "Dashboard";
        if(actualText.equals(expectedText)){
            System.out.println("Text verification passed: " + actualText);
        } else {
            System.out.println("Text verification failed. Expected: " + expectedText + ", but got: " + actualText);
        }


        driver.quit();

    }
}


/*
Assume that there is a webpage, you need to go to that webpage, enter username, password, and click the signIn then in landing page verify the text.
For this scenario write the automation script(standalone)
 */