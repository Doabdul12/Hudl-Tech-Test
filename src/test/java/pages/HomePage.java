package pages;

import com.codeborne.selenide.WebDriverRunner;
import helpers.Common;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@Scope("cucumber-glue")
@RequiredArgsConstructor
public class HomePage {

    //Web Element Locators
    private static final By HOME_NAV = By.cssSelector("[data-qa-id='webnav-globalnav-home']");



    @Delegate
    private final Common common;

    // Page Methods/Actions
    public String getHomePageUrl() {
        waitForElementToBeVisible(HOME_NAV, 5);
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
