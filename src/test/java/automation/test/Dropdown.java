package automation.test;

import ch.qos.logback.core.net.SyslogOutputStream;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Dropdown {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Code to set up the test environment, e.g., initializing WebDriver, opening browser, etc.
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.makemytrip.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testDropdownFunctionality(){

        WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-cy='closeModal']")));
        closePopup.click();
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='fromCity']")));
        dropdown.click();

        WebElement fromOption = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromOption.sendKeys("Delhi");

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='listbox']")));

        for (WebElement option : options) {
            System.out.println(option.getText());
            if(option.getText().contains("Delhi, India")) {
                option.click();
                break;
            }
        }

    }


//    @AfterClass
//    public void tearDown(){
//        if(driver != null){
//            driver.quit();
//        }
//    }
}
