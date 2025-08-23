package org.automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

// Lazy initialization with PageFactory in the constructor of a POM page
// @FindBy(id = "login-button")
// private WebElement loginButton;
// Elements are initialized when the driver interacts with them, dynamically during the test.
//PageFactory.initElements(driver, this) does not initialize all elements immediately in the constructor.
// Instead, it creates proxy objects for the fields annotated with @FindBy.
// The actual lookup and initialization of each WebElement happen lazily, i.e.,
// only when you first interact with the element (e.g., call click(), sendKeys(), etc.).
// This helps avoid stale element issues and improves performance.
public class LoginPageLazyPageFactory {

        private final WebDriver driver;

        @FindBy(id = "user-name")
        private WebElement inputUsername;

        @FindBy(id = "password")
        private WebElement inputPassword;

        @FindBy(id = "login-button")
        private WebElement loginButton;

        @FindBy(css = "input[data-test='login-button']")
        private WebElement loginButtonByDataTest;

        @FindBy(css = "button.error-button[data-test='error-button']")
        private WebElement errorButton;

        @FindBy(css = "div.error-message-container h3")
        private WebElement errorMessage;

        @FindBy(css = "button.error-button")
        private WebElement crossButton;

        public LoginPageLazyPageFactory(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void enterUsername(String username) {
            inputUsername.sendKeys(username);
        }

        public void enterPassword(String password) {
            inputPassword.sendKeys(password);
        }

        public void clickLogin() {
            loginButton.click();
        }

        public void clickLoginByDataTest() {
            loginButtonByDataTest.click();
        }

        public boolean isErrorButtonDisplayed() {
            return errorButton.isDisplayed();
        }

        public String getErrorMessageText() {
            return errorMessage.getText();
        }

        public void clickErrorCrossButton() {
            crossButton.click();
        }

        public boolean isErrorMessagePresent() {
            try {
                return errorMessage.isDisplayed();
            } catch (Exception e) {
                return false;
            }        }
    }

