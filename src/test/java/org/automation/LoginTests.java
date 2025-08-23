package org.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void openBrowserheName() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Page title does not match expected title.");
    }

    @Test
    public void loginWithoutUser() throws InterruptedException {

        LoginPageLazyPageFactory loginPage = new LoginPageLazyPageFactory(driver);
        loginPage.clickLogin();
        Thread.sleep(2);

        Assert.assertTrue(loginPage.isErrorButtonDisplayed(), "Error button is not displayed.");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required", "Error message text does not match.");
        loginPage.clickErrorCrossButton();
        Assert.assertFalse(loginPage.isErrorMessagePresent(), "Error message is still displayed after clicking the cross button.");

//        By loginButton = By.id("login-button");
//        By loginButtonByDataTest = By.cssSelector("input[data-test='login-button']");
//        By loginButtonByClass = By.cssSelector("input.submit-button.btn_action");
//        By loginButtonByName = By.name("login-button");
//        driver.findElement(loginButton).click();
//
//        By errorButton = By.cssSelector("button.error-button[data-test='error-button']");
//        Assert.assertTrue(driver.findElement(errorButton).isDisplayed(), "Error button is not displayed.");
//
//        By errorMessage = By.cssSelector("div.error-message-container h3");
//        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Epic sadface: Username is required", "Error message text does not match.");
//
//        By crossButton = By.cssSelector("button.error-button");
//        driver.findElement(crossButton).click();
//        Assert.assertTrue(driver.findElements(errorMessage).isEmpty(), "Error message is still displayed after clicking the cross button.");
    }

    @Test
    public void loginStandardUser() {

        LoginPageLazyInit loginPage = new LoginPageLazyInit(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginByDataTest();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "URL after login does not match expected URL.");

//        By inputUsername = By.id("user-name");
//        driver.findElement(inputUsername).sendKeys("standard_user");
//
//        By passwordInput = By.id("password");
//        WebElement passwordField = driver.findElement(passwordInput);
//        passwordField.click();
//        passwordField.sendKeys("secret_sauce");
//
//        driver.findElement(loginButtonByDataTest).click();
//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "URL after login does not match expected URL.");

    }
}
