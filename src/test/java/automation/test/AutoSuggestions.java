package automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AutoSuggestions {

    private static WebDriver driver;
    private static WebDriverWait wait;

    String searchKeys = "as";
    String selectOptions = "JavaScript";

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.tutorialspoint.com/selenium/practice/auto-complete.php");


    }

    @Test
    public void autocompleteTest(){

        //Locate autocomplete input box
        WebElement autocompleteInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#tags")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#tags")));

        //Enter partial text
        autocompleteInput.click();
        autocompleteInput.sendKeys(searchKeys);

        //wait for auto suggestions
        List<WebElement> suggestionsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("ul#ui-id-1 li")));


        //iterate and select required options
        for(WebElement option: suggestionsList){
            String texts = option.getText();
            System.out.println("List of texts options: "+texts);

            if(texts.equalsIgnoreCase(selectOptions)){
                option.click();
                break;
            }
        }

        //validation
        String selectValue = autocompleteInput.getAttribute("value");
        System.out.println("Selected values: "+selectValue);

        System.out.println("==== Autocomplete test completed successfully");
    }

    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}


/**
 *
 * 👉 𝐃𝐚𝐲-16: 𝐀𝐮𝐭𝐨-𝐂𝐨𝐦𝐩𝐥𝐞𝐭𝐞 𝐀𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 (𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 + 𝐉𝐚𝐯𝐚)
 *
 * In auto-suggestion scenarios, the real stability comes from using the right wait at the right place.
 *
 * What this test demonstrates:
 *
 * - Use `elementToBeClickable()` for input fields instead of only visibility
 * - Avoid redundant waits (visibility + clickable together)
 * - Rely purely on explicit waits, no `Thread.sleep`
 * - Handle dynamic suggestion lists using `visibilityOfAllElementsLocatedBy`
 * - Select values based on text comparison, not index
 *
 * Key takeaway:
 * If an element needs user interaction (click/type), clickable > visible.
 *
 * This approach keeps tests:
 * - Faster
 * - Cleaner
 * - Less flaky
 * - Interview-ready
 *
 * Real automation is not about writing more waits, it’s about writing the right one.
 *
 *
 *
 *
 *
 *
 * */