package org.automation;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ScreenshotUtils {

    // driver is your WebDriver instance
    public static void takeScreenshot(WebDriver driver, String path) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(path));
    }

    // method to get the pathname of the screenshot
    public static String takeScreenShotAndGetScreenshotPath(WebDriver driver, String screenshotName) throws IOException {

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "screenshots/" + screenshotName + ".png";
        FileUtils.copyFile(screenshot, new File(path));
        return path;
    }

    //method to  compare two screenshots and return true if they are identical, false otherwise

    public static boolean compareScreenshots(WebDriver driver, String baselinePath) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage actualImage = ImageIO.read(screenshot);
        BufferedImage expectedImage = ImageIO.read(new File(baselinePath));

        if (actualImage.getWidth() != expectedImage.getWidth() ||
                actualImage.getHeight() != expectedImage.getHeight()) {
            return false;
        }

        for (int x = 0; x < actualImage.getWidth(); x++) {
            for (int y = 0; y < actualImage.getHeight(); y++) {
                if (actualImage.getRGB(x, y) != expectedImage.getRGB(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean takeAndCompareScreenshot(WebDriver driver, String baselinePath) throws IOException {
        File baselineFile = new File(baselinePath);
        if (!baselineFile.exists()) {
            takeScreenshot(driver, baselinePath);
            return true; // First run, baseline created
        }
        return compareScreenshots(driver, baselinePath);
    }
}
