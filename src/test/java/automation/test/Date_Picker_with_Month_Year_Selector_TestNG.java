package automation.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Date_Picker_with_Month_Year_Selector_TestNG {
    String month = "6";
    String date = "19";
    String year = "2025";

    String[] expectedList = {month, date, year};

    static WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void datePicker(){
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
                .get(Integer.parseInt(month) - 1).click();
        driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

        String selectedDate = driver
                .findElement(By.xpath("//div[@class='react-date-picker__inputGroup']/input[@name='date']"))
                .getDomAttribute("value");

        System.out.println(selectedDate);

        List<WebElement> actualList =
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
