package org.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Standard POM implementation.
// Locators are defined as private fields and initialized in the constructor.
// Methods interact with these elements.
// WebElements are initialized when the driver interacts with them, dynamically during the test.
public class LoginPage {
    private WebDriver driver;

    // Locators
    private By inputUsername = By.id("user-name");
    private By inputPassword = By.id("password");
    private By loginButton = By.id("login-button");
    private By loginButtonByDataTest = By.cssSelector("input[data-test='login-button']");
    private By loginButtonByClass = By.cssSelector("input.submit-button.btn_action");
    private By loginButtonByName = By.name("login-button");
    private By errorButton = By.cssSelector("button.error-button[data-test='error-button']");
    private By errorMessage = By.cssSelector("div.error-message-container h3");
    private By crossButton = By.cssSelector("button.error-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(inputUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickLoginByDataTest() {
        driver.findElement(loginButtonByDataTest).click();
    }

    public boolean isErrorButtonDisplayed() {
        return driver.findElement(errorButton).isDisplayed();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void clickErrorCrossButton() {
        driver.findElement(crossButton).click();
    }

    public boolean isErrorMessagePresent() {
        return driver.findElements(errorMessage).isEmpty();
    }
}
