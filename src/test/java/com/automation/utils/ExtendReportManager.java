package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Random;


public class ExtendReportManager {

    static ExtentReports extentReports;
    static ExtentSparkReporter sparkReporter;
    static ExtentTest test;

    public static ExtentTest getTest() {
        return test;
    }

    public static void addScreenshot() throws IOException {
        test.addScreenCaptureFromPath(takeScreenShot());
    }

    private static String takeScreenShot() throws IOException {
        TakesScreenshot shot = (TakesScreenshot) DriverManager.getDriver();

        File file = shot.getScreenshotAs(OutputType.FILE);
        Random random = new Random();
        int num = random.nextInt(100000)+1;

        String filepath = "src/test/resources/screenshots/img_"+num+".png";

        FileUtils.copyFile(file, new File(filepath));

        return System.getProperty("user.dir")+"/"+filepath;

    }

    public static void createTest(ITestResult result){
        test = extentReports.createTest(result.getMethod().getMethodName());
    }

    public static void initReport(){
        String filepath =  "src/test/resources/reports/avinstackReport.html";
        sparkReporter = new ExtentSparkReporter(filepath);
        sparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.setSystemInfo("teter","Venumadhav");
    }

    public static void flush(){
        extentReports.attachReporter(sparkReporter);
        extentReports.flush();
    }
}
