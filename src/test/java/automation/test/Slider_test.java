package automation.test;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Slider_test {


    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.tutorialspoint.com/selenium/practice/accordion.php");


    }

    @Test
    public void verifySlider(){

    }


    private void sliderController(WebElement slider, int targetValue, WebElement output){
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, targetValue, 0).perform();
    }
}
