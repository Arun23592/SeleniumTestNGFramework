package ExceptionHandling;

import org.openqa.selenium.*;


public class ClickElementInterceptedException {

    private WebDriver driver;
    private JavascriptExecutor js;

    public SafeActions(WebDriver driver){
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void safeClick(By locator){
        try {
            driver.findElement(locator).click();
        }catch (ElementClickInterceptedException e){
            System.out.println("Click interceoted - dismissing overlay and using JS click");


            WebElement el = driver.findElement(locator);

        }
    }



}
