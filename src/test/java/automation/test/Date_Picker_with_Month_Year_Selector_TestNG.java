package automation.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Date_Picker_with_Month_Year_Selector_TestNG {
    String month = "11";
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

        System.out.println("Selected date is: "+selectedDate);

        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for (int i=0; i<actualList.size(); i++){
            System.out.println(actualList.get(i).getDomAttribute("value"));

            Assert.assertEquals(actualList.get(i).getDomAttribute("value"), expectedList[i]);
        }
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}



/*
*
* *
 * // 1. Navigate to page that contains the date picker
 * // 2. Click the date input so the calendar/date picker widget opens
 * // 3. Click the calendar's navigation label to switch view (likely from day -> month or month -> year)
 * // 4. Click again to move deeper into the year selection (second click usually shows year view)
 * // 5. Click the specific year button (constructed dynamically from the 'year' variable)
 * // 6. From the year view, select the month element.
 * // The selector returns all month elements; we pick index (month-1) because months are 1-based in input.
 * // 7. Click the date element inside the month (usually represented by <abbr> for accessibility)
 *  // 8. Read the selected date value from the input field (using getDomAttribute to get input value attr)
 * // 9. Print selected date for debugging / logging
 * // 10. Get all input fields inside the date-picker input group (maybe there are multiple inputs)
 * // 11. For each actual input element, print and assert it equals expectedList[i]
 * // Assertion: compare actual value with expected value from expectedList
 *
*
* */