package org.automation.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

//Yes, if you annotate your `BaseTest` class with `@Listeners`,
// all test classes that extend `BaseTest` will inherit the listener annotation.
// The listener will be active for all child test classes,
// so you do not need to annotate each subclass separately.

@Listeners(org.automation.listeners.FormattedTestListener.class)
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
//        WebDriverManager manager = WebDriverManager.chromedriver();
//        manager.setup();
//        driver = new ChromeDriver();


    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                driver.quit();
            } catch (Exception ignored) {
                // Ignore errors if session already closed
            }
            driver = null;
        }
        /**
         * Setting `driver = null` after quitting the driver ensures that:
         *
         * - The reference does not point to a closed or invalid session, preventing accidental reuse.
         * - In subsequent tests, you can reliably check if the driver needs to be re-initialized.
         * - It helps avoid `NoSuchSessionException` or similar errors if `tearDown()` is called multiple times or if tests run in parallel.
         *
         * This is a good practice for resource cleanup and test stability.
         */
    }

}
