package automation.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class Handling_webTable {

    private static WebDriver driver;
    private static WebDriverWait wait;
    public void setUp(){

        driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
        driver.manage().window().maximize();

    }


    @Test
    public void handleWebTable(){




    }
}
