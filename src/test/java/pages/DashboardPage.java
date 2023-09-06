package pages;

import com.codeborne.selenide.SelenideElement;
import helpers.Common;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
@Component
@Scope("cucumber-glue")
@RequiredArgsConstructor
public class DashboardPage {

    //Web Element Locators
    private static final By NEW_EVENT_BUTTON = By.xpath("//span[text()='New event']");

    @Delegate
    private final Common common;

    // Page Methods/Actions
    public void clickNewEventButton(){
        waitForElementToBeVisible(NEW_EVENT_BUTTON);
        element(NEW_EVENT_BUTTON).click();
    }

    public String getPageUrl(){
        waitForElementToBeVisible(NEW_EVENT_BUTTON);
        return webdriver().object().getCurrentUrl();
    }

}
