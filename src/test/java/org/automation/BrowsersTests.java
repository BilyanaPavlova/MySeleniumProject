package org.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class BrowsersTests extends BaseTest {

    @Test
    public void testInFirefox() throws InterruptedException {
        // Clos ethe browser opened from the BaseTest setup
        driver.quit();
        driver = WebDriverManager.firefoxdriver().create();
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(3000);
        driver.navigate().to("https://facebook.com/");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);

        // Open a new tab and switch to it
        driver.switchTo().newWindow(WindowType.TAB);
        // Navigate to a URL in the new tab
        driver.get("https://facebook.com");
        Thread.sleep(3000);
        // Close the new tab and switch back to the original tab
        driver.close();

        //After calling driver.close(), the current tab is closed, but the WebDriver still needs to be switched to an open window. The loop gets all remaining window handles, switches to the first one, and then breaks (so it only switches once). This ensures your WebDriver is pointing to a valid, open browser tab.
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            break;
        }
        Thread.sleep(3000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.ebay.de/");
        Thread.sleep(3000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        Thread.sleep(3000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");
        Thread.sleep(3000);

        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(0)); // Switch to the first tab
        Thread.sleep(3000);
        driver.switchTo().window(handles.get(1)); // Switch to the second tab
        Thread.sleep(3000);
        driver.switchTo().window(handles.get(2)); // Switch to the third tab
        Thread.sleep(3000);
        driver.switchTo().window(handles.get(3)); // Switch to the fourth tab
        Thread.sleep(3000);


    }
}
