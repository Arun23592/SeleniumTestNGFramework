package org.qa.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.qa.pages.pages.BasePage;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;



import java.io.File;
import java.io.IOException;

public class BaseTest {

//    protected static ThreadLocal<webDriver> driver = new ThreadLocal<webDriver>();

    public static WebDriver driver;
    public static ExtentReports extentReports;
    protected ExtentTest extentTest;


    @BeforeClass
    public static void generateExtentReport(){
        extentReports = new ExtentReports();
        File extentReportFile = new File(System.getProperty("user.dir")+ File.separator + "Reports" + File.separator + "AutomationReports.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Automation Test Results");
        sparkReporter.config().setDocumentTitle("Ecommerce website Automation");
        sparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");
        extentReports.setSystemInfo("HostName", "RHEL8");
        extentReports.setSystemInfo("Username", "root");

        extentReports.attachReporter(sparkReporter);



    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser, ITestContext context){

        if(browser.equalsIgnoreCase("chrome")){
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
        }else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new EdgeDriver(options);

        }

        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");

        context.setAttribute("WebDriver", driver);
    }


    @AfterMethod
    public void tearDown(ITestResult result){

            if(result.getStatus() == ITestResult.FAILURE){
                takeScreenshot(result);
                extentTest.fail(result.getThrowable());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                extentTest.pass("Test passed");
            } else if (result.getStatus() == ITestResult.SKIP) {
                extentTest.skip(result.getThrowable());
            }
            if (driver != null){
                driver.quit();
            }
//            extentReports.flush();


    }


    public void takeScreenshot(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/Resources/Screenshots/" +
                    result.getName()+ ".png");
            try {
                FileHandler.copy(source, destination);
                extentTest.addScreenCaptureFromPath(destination.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void flushReports(){
        if(extentReports !=null){
            extentReports.flush();
        }
    }

}
