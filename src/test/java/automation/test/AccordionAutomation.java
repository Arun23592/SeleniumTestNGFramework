package automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AccordionAutomation {


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
    public void accordionTest(){
        //1. Locate all accordian headers
        List<WebElement> accordionHeaders = driver.findElements(By.xpath("//div[@id='accordionExample']//following-sibling::button"));

        System.out.println("Total accordion sections: "+accordionHeaders.size());

        //2. iteraqte through all accordian items
        for(int i=0; i<accordionHeaders.size(); i++){
            WebElement header = accordionHeaders.get(i);
            //expand section
            wait.until(ExpectedConditions.elementToBeClickable(header)).click();
            //wait for content to be visible
            WebElement body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='accordion-body']//p[@class='text-justify']")));
            System.out.println(body.getText());
        }

        System.out.println("\n Accordion Test completed successfully");

    }

    @AfterClass
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
