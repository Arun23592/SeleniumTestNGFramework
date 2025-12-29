package automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class modalDialougeTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.tutorialspoint.com/selenium/practice/modal-dialogs.php");


    }


    @Test(priority = 1)
    public void modalDialogTests(){

        WebElement smallModalBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Small Modal']")));

        if (smallModalBtn.isEnabled()){
            smallModalBtn.click();
        }

        WebElement modal1 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-primary[data-bs-target='#exampleModalToggle2']")));

        if (modal1.isEnabled()){
            modal1.click();
            System.out.println("Modal 1 validated successfully");
        }
    }

    @Test(priority = 2)
    public void largeDialogTest(){
        WebElement largeDialogBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Large Modal']")));

        if(largeDialogBtn.isEnabled()){
            largeDialogBtn.click();
        }


        WebElement modal2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='modal-dialog modal-lg'] button[class='btn btn-primary']")));

        if (modal2.isEnabled()){
            modal2.click();
            System.out.println("Modal 2 validated successfully");
        }
    }

}
