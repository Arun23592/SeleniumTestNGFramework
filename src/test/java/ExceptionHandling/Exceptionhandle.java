package ExceptionHandling;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Exceptionhandle {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://testautomationpractice.blogspot.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.sta")));
            element.click();
            System.out.println("clicked successfully");
            
        }catch (NoSuchElementException e){
            System.out.println("ElementNotFound: "+e.getMessage());

        }catch (TimeoutException e){
            System.out.println("Time out waiting for element : "+ e.getMessage());
        }catch (ElementClickInterceptedException e){
            //Fallback: javascript
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.id("submit-btn")));
        }catch (WebDriverException e){
            System.out.println("WebDriver error: " + e.getMessage());
        }finally {
            driver.quit();
        }
    }
}
