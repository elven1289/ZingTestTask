package support;

import driver.BrowserStackDriverProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
       /// Calendar calendar = Calendar.getInstance();
       /// SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
       /// String methodName = result.getName();
       /// if (!result.isSuccess()) {
       ///     try {
       ///         File scrFile = ((TakesScreenshot) BrowserStackDriverProvider.getDriver()).getScreenshotAs(OutputType.FILE);
       ///         String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
       ///         File destFile = new File( reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
       ///         FileUtils.copyFile(scrFile, destFile);
       ///         URI relative = new File(reportDirectory).toURI().relativize(destFile.toURI());
       ///         Reporter.log("<a href='" + relative.getPath() + "'> <img src='" + relative.getPath() + "' height='1158' width='540'/> </a>");
       ///     } catch (IOException e) {
       ///         e.printStackTrace();
       ///     }
       /// }
    }
}