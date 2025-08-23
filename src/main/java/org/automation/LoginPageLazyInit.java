package org.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Lazy initialization for web elements -
//use methods that locate elements only when needed,
// and avoid storing By locators as fields unless reused.
// Here’s a refactored version using lazy element lookup:

public class LoginPageLazyInit {
    private final WebDriver driver;

    public LoginPageLazyInit(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getUsernameInput() {
        return driver.findElement(By.id("user-name"));
    }

    private WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }

    private WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    private WebElement getLoginButtonByDataTest() {
        return driver.findElement(By.cssSelector("input[data-test='login-button']"));
    }

    private WebElement getErrorButton() {
        return driver.findElement(By.cssSelector("button.error-button[data-test='error-button']"));
    }

    private WebElement getErrorMessage() {
        return driver.findElement(By.cssSelector("div.error-message-container h3"));
    }

    private WebElement getCrossButton() {
        return driver.findElement(By.cssSelector("button.error-button"));
    }

    public void enterUsername(String username) {
        getUsernameInput().sendKeys(username);
    }

    public void enterPassword(String password) {
        getPasswordInput().sendKeys(password);
    }

    public void clickLogin() {
        getLoginButton().click();
    }

    public void clickLoginByDataTest() {
        getLoginButtonByDataTest().click();
    }

    public boolean isErrorButtonDisplayed() {
        return getErrorButton().isDisplayed();
    }

    public String getErrorMessageText() {
        return getErrorMessage().getText();
    }

    public void clickErrorCrossButton() {
        getCrossButton().click();
    }

    public boolean isErrorMessagePresent() {
        return driver.findElements(By.cssSelector("div.error-message-container h3")).isEmpty();
    }
}