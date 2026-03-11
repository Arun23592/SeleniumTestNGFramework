package ExceptionHandling;

import org.openqa.selenium.*;


public class ClickElementInterceptedException {

    private WebDriver driver;
    private JavascriptExecutor js;

    public ClickElementInterceptedException(WebDriver driver){
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void safeClick(By locator){
        try {
            driver.findElement(locator).click();
        }catch (ElementClickInterceptedException e){
            System.out.println("Click interceoted - dismissing overlay and using JS click");

            dismissBanner();
            WebElement el = driver.findElement(locator);
            js.executeScript("arguments[0].scrollIntoView(true);", el);
            js.executeScript("arguments[0].click();", el);


        }
    }


    private void dismissBanner(){
        try{
            driver.findElement(By.id("accept-cookies")).click();
        }catch (NoSuchElementException ignored){
            //No banner present - continue
        }
    }



}
