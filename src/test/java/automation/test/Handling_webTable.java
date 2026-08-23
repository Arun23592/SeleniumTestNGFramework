package automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Handling_webTable {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeMethod
    public void setUp(){

        driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public void handleWebTable(){

        int total = 0;

        while(true){
            List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));

            total += rows.size();

            System.out.println("Total rows in the table: "+total);

            break;
        }


    }
}
