package pages;

import helpers.Common;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.element;

@Log4j2
@Component
@Scope("cucumber-glue")
@RequiredArgsConstructor
public class MioSignInPage {

    //Web Element Locators
    private static final By MIO_USER_EMAIL_ADDRESS = By.cssSelector("[name='email']");
    private static final By MIO_USER_PASSWORD = By.cssSelector("[name='password']");
    private static final By SIGN_IN_BUTTON = By.xpath("//span[text()='Sign in']");

    @Delegate //
    private final Common common;

    // Page Methods/Actions
    public void inputEmailAddress(String emailAddress){
        waitForElementToBeVisible(MIO_USER_EMAIL_ADDRESS);
        element(MIO_USER_EMAIL_ADDRESS).sendKeys(emailAddress);
    }
    public void inputPassword(String password){
        waitForElementToBeVisible(MIO_USER_PASSWORD);
        element(MIO_USER_PASSWORD).sendKeys(password);
    }
    public void clickSignIn(){
        waitForElementToBeVisible(SIGN_IN_BUTTON);
        element(SIGN_IN_BUTTON).click();
    }
}
