//package utils;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.io.FileHandler;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import java.io.File;
//import java.io.IOException;
//
//import static org.qa.pages.pages.BasePage.driver;
//
//public class SuiteListners implements ITestListener {
//    //    private final WebDriver driver;
//
////    public SuiteListners(WebDriver driver){
////        this.driver = driver;
////    }
//
//
//   private ExtentReports extentReports;
//    private ExtentTest extentTest;
//
//
//
//
//    @Override
//    public void onStart(ITestContext context) {
//        System.out.println("Executing start of the project");
//        ExtentReport.generateExtentReport();
//
//    }
//    @Override
//    public void onTestStart(ITestResult result) {
//        String testName = result.getName();
//        extentTest = extentReports.createTest(testName);
//        extentTest.log(Status.INFO, testName+" Started Executing");
//
//
//    }
//
//    /**
//     * Invoked each time a test succeeds.
//     *
//     * @param result <code>ITestResult</code> containing information about the run test
//     * @see ITestResult#SUCCESS
//     */
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        String testName = result.getName();
//        extentTest.log(Status.PASS, testName+" Test case Passed");
//        System.out.println(testName+ " -Executed successfully");
//    }
//
//    /**
//     * Invoked each time a test fails.
//     *
//     * @param result <code>ITestResult</code> containing information about the run test
//     * @see ITestResult#FAILURE
//     */
//    @Override
//    public void onTestFailure(ITestResult result) {
//
//
//        String testName = result.getName();
//        extentTest.log(Status.FAIL, testName+" Testcase Failed");
//        System.out.println(testName+ " -Execution failed");
//        extentTest.log(Status.INFO, result.getThrowable());
//    }
//
//    /**
//     * Invoked each time a test is skipped.
//     *
//     * @param result <code>ITestResult</code> containing information about the run test
//     * @see ITestResult#SKIP
//     */
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        String testName = result.getName();
//        extentTest.log(Status.SKIP, testName+ " Testcase Skipped");
//        System.out.println(testName+ " -Execution skipped");
//        extentTest.log(Status.INFO, result.getThrowable());
//    }
//
//
//
//
//
//    /**
//     * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
//     * run and all their Configuration methods have been called.
//     *
//     * @param context The test context
//     */
//    @Override
//    public void onFinish(ITestContext context) {
//        System.out.println(" -Execution Finish of the project");
//        if (extentReports != null){
//            extentReports.flush();
//        }
//
//    }
//}
