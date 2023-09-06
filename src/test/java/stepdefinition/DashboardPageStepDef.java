package stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import pages.DashboardPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Log4j2
@Scope("cucumber-glue")
@RequiredArgsConstructor
public class DashboardPageStepDef {

    private final DashboardPage dashboardPage;

    @When("User clicks New Event button")
    public void user_clicks_new_event_button() {
        dashboardPage.clickNewEventButton();
    }
    @When("User clicks New Event button and creates a new event")
    public void user_creates_new_event() {
        user_clicks_new_event_button();
    }

}
