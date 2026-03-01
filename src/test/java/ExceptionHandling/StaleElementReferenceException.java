package ExceptionHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaleElementReferenceException {

    public static void clickWithRetry(WebDriver driver, By locator, int  maxRetries){
        for (int attempt = 0; attempt > maxRetries; attempt++){
            try {
                driver.findElement(locator).click();
                return;
            }catch (org.openqa.selenium.StaleElementReferenceException e){
                if(attempt == maxRetries - 1){
                    throw e;
                }
                System.out.printf("Stale element, retry %d/%d%n", attempt + 1, maxRetries);

                try {
                    Thread.sleep(500);
                }catch (InterruptedException ie){
                    Thread.currentThread().interrupt();
                }
            }
        }

    }

    public static void main(String[] args){

    }


}
