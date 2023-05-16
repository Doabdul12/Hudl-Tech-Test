package pages;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import helpers.Common;
import lombok.experimental.Delegate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

@Log4j2
@Component
@Scope("cucumber-glue")
@RequiredArgsConstructor
public class LoginPage {

    //Web Element Locators
    private static final By EMAIL_INPUT = By.cssSelector("[data-qa-id='email-input']");
    private static final By PASSWORD_INPUT = By.cssSelector("[data-qa-id='password-input']");
    private static final By LOGIN_BTN = By.cssSelector("[data-qa-id='login-btn']");
    private static final By ERROR_DISPLAY = By.cssSelector("[data-qa-id='error-display']");
    private static final By NEED_HELP_LINK = By.cssSelector("[data-qa-id='need-help-link']");
    private static final By PASSWORD_RESET_SUBMIT_BTN = By.cssSelector("[data-qa-id='password-reset-submit-btn']");
    private static final By PASSWORD_RESET_ERROR_DISPLAY = By.cssSelector("[data-qa-id='password-reset-error-display']");

    @Delegate
    private final Common common;

    // Page Methods/Actions
    public void enterEmailAddress(String email) {
        SelenideElement emailInput = $(EMAIL_INPUT);
        emailInput.shouldBe(visible).sendKeys(email);
    }

    public void enterPassword(String password) {
        SelenideElement passwordInput = $(PASSWORD_INPUT);
        passwordInput.shouldBe(visible).sendKeys(password);
    }

    public void clickLoginButton(){
        waitForElementToBeVisible(LOGIN_BTN,2);
        element(LOGIN_BTN).click();
    }

    public String getLoginErrorMessage(){
        waitForElementToBeVisible(ERROR_DISPLAY,2);
        return element(ERROR_DISPLAY).getText();
    }

    public String getPasswordResetErrorMessage(){
        waitForElementToBeVisible(PASSWORD_RESET_ERROR_DISPLAY,2);
        return element(PASSWORD_RESET_ERROR_DISPLAY).getText();
    }

    public void clickNeedHelpLink(){
        waitForElementToBeVisible(NEED_HELP_LINK);
        element(NEED_HELP_LINK).click();
    }

    public String getHelpPageUrl() {
        waitForElementToBeVisible(PASSWORD_RESET_SUBMIT_BTN, 5);
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public void clickPasswordResetBtn(){
        waitForElementToBeVisible(PASSWORD_RESET_SUBMIT_BTN, 2);
        element(PASSWORD_RESET_SUBMIT_BTN).click();
    }
}
