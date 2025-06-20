package automation.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Dropdown {
    private static WebDriver driver;
    public void setUp() {
        // Code to set up the test environment, e.g., initializing WebDriver, opening browser, etc.
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
    }

    public void testDropdownFunctionality(){
        WebElement dropdown = driver.findElement(By.xpath("//label[@for='fromCity']"));
        dropdown.click();

        WebElement fromOption = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromOption.sendKeys("Delhi");



    }


    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
