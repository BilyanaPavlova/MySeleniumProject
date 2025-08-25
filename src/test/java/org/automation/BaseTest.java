package org.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    // Explicit wait instance for use in tests
    public WebDriverWait explicitWait;

    @BeforeMethod
    public void setUp() {

//        System.setProperty("webdriver.chrome.driver", "/home/bili/Documents/Chromedriver/chromedriver-linux64/chromedriver");

        // Using WebDriverManager to manage driver binaries are always up to date with the Chrome browser version
        // that is automatically downloaded by the system.
        // Then we do not need to manually download and set the path for the System as shown above.
        WebDriverManager manager = WebDriverManager.chromedriver();
        manager.setup();
        driver = new ChromeDriver();

        // If we test on iOS Safari browser... etc for different browsers
//        WebDriverManager iOSmanager = WebDriverManager.safaridriver();
//        iOSmanager.setup();
//        driver = new SafariDriver();

        driver.get("https://www.saucedemo.com/");

        // implicit wait is generally discouraged in favor of explicit waits
        // it can lead to unpredictable wait times and complicate debugging
        // if you do use it, set it once in the setup.
        // It waits for each element lookup.
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            try {
                Thread.sleep(4000); // Pause for 4 seconds to observe the test result
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }

}
