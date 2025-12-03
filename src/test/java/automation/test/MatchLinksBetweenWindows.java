package automation.test;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MatchLinksBetweenWindows {


    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //collect links from parentwindow
        List<WebElement>  parentLinks = driver.findElements(By.tagName("a"));
        List<String> parenTextList = new ArrayList<>();

        for(WebElement link: parentLinks){
            parenTextList.add(link.getText().trim());
            System.out.println("Link texts are: "+parenTextList);
        }

        //2. Click on any that open a child window
        driver.findElement(By.linkText("Flight Booking")).click();

        //3. Switch to child window
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();

        for (String childWindow: allWindow){
            if(!mainWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
            }
        }

        //4. Collect all links from child window
        List<WebElement> childLinks = driver.findElements(By.linkText("a"));
        List<String> childLinkText = new ArrayList<>();

        for (WebElement links: childLinks){
            childLinkText.add(links.getText().trim());
            System.out.println(childLinkText);
        }

        //5. Find matching links
        parenTextList.retainAll(childLinkText);

//        System.out.println("Matching links: ");
//        for (String linkMatch: parenTextList){
//            System.out.println(linkMatch);
//        }

        if(parenTextList.isEmpty()){
            System.out.println("No matching links are found");
        }else {
            System.out.println("Matching links are found "+parenTextList);
        }

        //6. Close the child window and return to parent
        driver.close();
        driver.switchTo().window(mainWindow);

    }
}
