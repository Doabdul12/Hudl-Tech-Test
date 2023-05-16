package helpers;

import com.codeborne.selenide.SelenideElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


@SuppressWarnings({"JavadocDeclaration", "unused"})
@Log4j2
@RequiredArgsConstructor
@Component
@Scope("cucumber-glue")
public class Common {

    public static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(60L);


    public SelenideElement waitForElementToBeVisible(By locator) {
        return waitForElementToBeVisible(locator, DEFAULT_TIMEOUT);
    }

    public SelenideElement waitForElementToBeVisible(By locator, Duration duration) {
        return $(locator).shouldBe(visible, duration);
    }

    public SelenideElement waitForElementToBeVisible(By locator, int seconds) {
        return waitForElementToBeVisible(locator, Duration.ofSeconds(seconds));
    }
}
