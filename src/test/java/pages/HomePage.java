package pages;

import com.codeborne.selenide.WebDriverRunner;
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
public class HomePage {

    //Web Element Locators
    private static final By HOME_NAV = By.cssSelector("[data-qa-id='webnav-globalnav-home']");
    private static final By LOGOUT_NAV = By.cssSelector("[data-qa-id='webnav-usermenu-logout']");
    private static final By LOGIN_BTN = By.cssSelector("[data-qa-id='login-select']");
    private static final By USER_MENU_NAV = By.xpath("//div[@class='hui-globaluseritem__display-name']");

    @Delegate
    private final Common common;

    // Page Methods/Actions
    public String getHomePageUrl() {
        waitForElementToBeVisible(HOME_NAV, 5);
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public String getBasePageUrl() {
        waitForElementToBeVisible(LOGIN_BTN, 5);
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public void clickUserMenuNav(){
        waitForElementToBeVisible(USER_MENU_NAV, 2);
        element(USER_MENU_NAV).click();
    }

    public void clickLogOut(){
        waitForElementToBeVisible(LOGOUT_NAV,2);
        element(LOGOUT_NAV).click();
    }
}
