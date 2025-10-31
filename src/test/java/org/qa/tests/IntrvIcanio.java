package org.qa.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class IntrvIcanio {

    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void navigateToHomePage(){
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    public void productSearch(){
        WebElement serchbox = driver.findElement(By.id("twotabsearchtextbox"));
        serchbox.sendKeys("laptop");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
        product.click();



    }

    @Test(priority = 3)
    public void applyFilter() throws InterruptedException {
        WebElement priceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='a-section s-range-input-container s-lower-bound aok-relative']")));

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 100)");
//      priceFilter.click();
        Thread.sleep(5000);
//        WebElement priceFilter2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='p_36/range-slider_slider-item_upper-bound-slider']")));
        Actions actions = new Actions(driver);


        actions.moveToElement(priceFilter)
                .click()
                .dragAndDropBy(priceFilter, 100, 0)
                .build()
                .perform();


        WebElement go = driver.findElement(By.xpath("//input[@aria-label='Go - Submit price range']"));
        go.click();

    }

    @Test(priority = 4)
    public void verifyProductResults() {

        List<WebElement> prodList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='a-price-whole' and number(translate(text(),',₹','')) < 32000]")));

        if (!prodList.isEmpty()) {
            System.out.println("Found " + prodList.size() + " products fall within the specified price range :");

            for (WebElement prod : prodList) {
                // Find the corresponding product title element
                WebElement parent = prod.findElement(By.xpath("./ancestor::div[@class='sg-col-inner']"));
                List<WebElement> titleElement = parent.findElements(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']"));
                    for (WebElement title : titleElement){
                        String productTitle = title.getText();
                        System.out.println(productTitle + " - ₹" + prod.getText());
                    }
//                String productTitle = titleElement

            }
        } else {
            System.out.println("No products found below ₹32,000.");
        }

    }


    public void windowHandes(){
        WebElement newTabBtn = driver.findElement(By.id("tabButton"));

        String mainWIndow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();

        for(String childwindow : allWindows){
            if (!mainWIndow.equalsIgnoreCase(childwindow)){
                driver.switchTo().window(childwindow);
                System.out.println("Switched to new Window: "+driver.getTitle());
                driver.close();
            }
        }

        driver.switchTo().window(mainWIndow);
    }
}
