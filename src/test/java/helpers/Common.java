package helpers;

import com.codeborne.selenide.SelenideElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


@SuppressWarnings({"JavadocDeclaration", "unused"}) //
@Log4j2 //
@RequiredArgsConstructor //
@Component //
@Scope("cucumber-glue") //
public class Common {

    public static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(60L);

    public SelenideElement waitForElementToBeVisible(By locator) {
        return waitForElementToBeVisible(locator, DEFAULT_TIMEOUT);
    }

    public SelenideElement waitForElementToBeVisible(By locator, Duration duration) {
        return $(locator).shouldBe(visible, duration);
    }

    public void clickableElement(By locator) {
        $(locator).shouldBe(and("can be clicked", visible, enabled), DEFAULT_TIMEOUT);
    }

    public SelenideElement waitForElementToBeVisible(By locator, int seconds) {
        return waitForElementToBeVisible(locator, Duration.ofSeconds(seconds));
    }

    public void waitForElementClickable(By locator) {
        clickableElement(locator);
    }

    public boolean isElementNotDisplayed(By element, int seconds) {
        try {
            $(element).shouldBe(not(visible), Duration.ofSeconds(seconds));
            return true;
        } catch (AssertionError e) {
            return false;
        }
    }

    public int getNumOfElements(By by) {
        int i = 0;
        List<WebElement> elements = getWebDriver().findElements(by);
        i = elements.size();
        return i;
    }

    public SelenideElement fillInputBox(String value) {
        String xpath = String.format("//div[text()='%s']/../../..//input", value);
        return $x(xpath);
    }

    //This method selects value in dropdown
    public SelenideElement selectSelectorValue(String field, String value) {
        clickSelector(field).click();
        String xpath = String.format("//div[text()='%s']", value);
        return $x(xpath);
    }

    //This Method opens the dropdown box
    private SelenideElement clickSelector(String value) {
        String xpath = String.format("(//label[text()='%s']/..//input/..)[1]", value);
        return $x(xpath);
    }

    public SelenideElement inputDate(String value){
        String xpath = String.format("//label[text()='%s']/..//input", value);
        return $(xpath);
    }

    public void switchToDefaultFrame() {
        switchTo().defaultContent();
    }

    public void clickSearchedItem(String value, String item) {
        String searchbarInputXpath = String.format("//label[text()='%s']/..//input[@type='text']", value);
        $x(searchbarInputXpath).sendKeys(item);
        $x(searchbarInputXpath).pressEnter();
    }
}
