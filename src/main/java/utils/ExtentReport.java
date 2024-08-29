//    package utils;
//
//    import com.aventstack.extentreports.ExtentReports;
//    import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//    import com.aventstack.extentreports.reporter.configuration.Theme;
//
//    import java.io.File;
//    import java.io.FileInputStream;
//    import java.io.InputStream;
//    import java.util.Properties;
//
//    public class ExtentReport {
//
//
//
//        public static void generateExtentReport(){
//            ExtentReports extentReports = new ExtentReports();
//            File extentReportFile = new File(System.getProperty("user.dir")+ File.separator + "Reports" + File.separator + "AutomationReports.html");
//            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
//
//            sparkReporter.config().setTheme(Theme.DARK);
//            sparkReporter.config().setReportName("Automation Test Results");
//            sparkReporter.config().setDocumentTitle("Ecommerce website Automation");
//            sparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");
//            extentReports.setSystemInfo("HostName", "RHEL8");
//            extentReports.setSystemInfo("Username", "root");
//
//            extentReports.attachReporter(sparkReporter);
//
//
//
//        }
//
//
//    }
