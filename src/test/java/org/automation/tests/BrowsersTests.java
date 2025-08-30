package org.automation.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.automation.utils.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

import io.qameta.allure.Description;
import io.qameta.allure.Step;



public class BrowsersTests extends BaseTest {

    @Test(description = "This test opens Firefox Browser")
    @Description("Different browser navigation steps are checked here")
    public void testInChromeDriver() throws InterruptedException {
        // If we test on iOS Safari browser... etc for different browsers
//        WebDriverManager iOSmanager = WebDriverManager.safaridriver();
//        iOSmanager.setup();
//        driver = new SafariDriver();

        //automatic download of last chromedriver binary
        WebDriverManager manager = WebDriverManager.chromedriver();
        manager.setup();

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        // implicit wait is generally discouraged in favor of explicit waits
        // it can lead to unpredictable wait times and complicate debugging
        // if you do use it, set it once in the setup.
        // It waits for each element lookup.
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }

    @Test
    @Description("Open Firefox browser and load urls")
    public void openFireFoxBrowser() throws InterruptedException {
        BrowserActions actions = new BrowserActions();

        driver = WebDriverManager.firefoxdriver().create();
        actions.getUrl(driver, "https://the-internet.herokuapp.com/");
        actions.changeTheUrl(driver, "https://facebook.com/");
        actions.navigateBackAndForth(driver);
        driver.close();
    }

    @Test()
    @Description("Test switching between tabs and opening different urls in Firefox")
    public void openNewBrowserAndSwitchBetweenTabs() throws InterruptedException {

        /**
         * `WebDriverManager.firefoxdriver().create();` is a utility from the WebDriverManager library that:
         * - Automatically downloads and sets up the correct version of the FirefoxDriver binary for your system.
         * - Returns a new instance of `FirefoxDriver`.
         * Using `new FirefoxDriver()` directly requires you to manually set the path to the driver binary (via system properties), which can be error-prone and less portable.
         * So, `WebDriverManager.firefoxdriver().create();` simplifies driver management and avoids manual setup.
         */
        driver = WebDriverManager.firefoxdriver().create();

        BrowserActions actions = new BrowserActions();
        actions.getUrl(driver, "https://the-internet.herokuapp.com/");
        // Open a new tab and switch to it
        driver.switchTo().newWindow(WindowType.TAB);
        // Navigate to a URL in the new tab
        actions.getUrl(driver, "https://facebook.com");
        Thread.sleep(1000);
        // Close the new tab and switch back to the original tab
        driver.close();
        actions.switchToAnotherTab(driver);
        driver.switchTo().newWindow(WindowType.TAB); //open new browser tab and switches there
        actions.getUrl(driver, "https://www.ebay.de/");
        driver.switchTo().newWindow(WindowType.TAB);
        actions.getUrl(driver,"https://www.linkedin.com");
        driver.switchTo().newWindow(WindowType.TAB);
        actions.getUrl(driver, "https://www.google.com");

        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(0)); // Switch to the first tab
        Thread.sleep(1000);
        driver.switchTo().window(handles.get(1)); // Switch to the second tab
        Thread.sleep(1000);
        driver.switchTo().window(handles.get(2)); // Switch to the third tab
        Thread.sleep(1000);
        driver.switchTo().window(handles.get(3)); // Switch to the fourth tab
        Thread.sleep(1000);
    }



}

