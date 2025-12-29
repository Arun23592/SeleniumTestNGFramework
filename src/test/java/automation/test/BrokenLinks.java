package automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinks {
    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testBrokenLink() throws IOException {

        List<WebElement> elementList = driver.findElements(By.tagName("a"));

        //Extract href attributes and filter out invalid ones
        List<String> linkAddress = new ArrayList<>();

        for (WebElement ele: elementList){
            linkAddress.add(ele.getAttribute("href"));
        }

        //print total number of valid links
        System.out.println("total links are: "+linkAddress.size());

        //loop through each link and check its HTTP response code

        for(String link: linkAddress){
            URL url = new URL(link);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(Integer.parseInt("3000"));
            httpURLConnection.connect();
            System.out.println(link);
            System.out.println(httpURLConnection.getResponseCode());

            int responseCode = httpURLConnection.getResponseCode();

            if(responseCode >= 400){
                System.out.println("Broken Links " + link + "Response code "+ responseCode);
            }else {
                System.out.println("Broken Links " + link + "Response code "+ responseCode);
            }
        }

    }
}
