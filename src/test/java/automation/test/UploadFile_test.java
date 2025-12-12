package automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class UploadFile_test {

    public static WebDriver driver;


    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void uploadFiles() throws IOException {

        String uploadFolder = System.getProperty("user.dir") + File.separator + "upload";
        String uploadFile = uploadFolder + File.separator + "testUploaded.txt";
        Files.createDirectories(Paths.get(uploadFolder));
        Path filePath = Paths.get(uploadFile);

        if(!Files.exists(filePath)) Files.createFile(filePath);

        List<String> content = Arrays.asList(
                "Sample file for uplaod testing",
                "Line 1", "Line 2"
        );
        Files.write(filePath, content, StandardOpenOption.TRUNCATE_EXISTING);
        driver.findElement(By.id("uploadFile")).sendKeys(filePath.toString());
        System.out.println("uploadFile: "+filePath);


    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}


/*
* Automation practice website:
*
* https://www.tutorialspoint.com/selenium/practice/upload-download.php
* https://testautomationpractice.blogspot.com/
*
* */