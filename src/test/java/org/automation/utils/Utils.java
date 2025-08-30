package org.automation.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Utils {

    // Verify an alert is present
    public static void verifyAlertIsPresent(WebDriver driver) {
    boolean isAlertPresent;
        try {
        Alert alert = driver.switchTo().alert();
        isAlertPresent = true;
        alert.accept(); // Optionally close the alert
    } catch (
    NoAlertPresentException e) {
        isAlertPresent = false;
    }
        Assert.assertTrue(isAlertPresent, "Alert is not displayed.");

}
}
