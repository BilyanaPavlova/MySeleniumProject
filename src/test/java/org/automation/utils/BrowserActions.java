package org.automation.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    // In each Step pass the driver, that is holding it's state, so that the state is passed to the step

    @Step("Open Url")
    public void getUrl(WebDriver driver, String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(1000);
    }

    @Step("Change the url")
    public void changeTheUrl(WebDriver driver, String url) throws InterruptedException {
        driver.navigate().to(url);
        Thread.sleep(1000);
    }

    @Step("Navigate forth and back")
    public void navigateBackAndForth(WebDriver driver) throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
        Thread.sleep(1000);
    }

    @Step("Change the tab")
    public void switchToAnotherTab(WebDriver driver) throws InterruptedException {

        //After calling driver.close(), the current tab is closed,
        // but the WebDriver still needs to be switched to an open window.
        // The loop gets all remaining window handles, switches to the first one,
        // and then breaks (so it only switches once). This ensures your WebDriver is pointing to a valid,
        // open browser tab.
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            break;
        }
        Thread.sleep(1000);
    }




}
