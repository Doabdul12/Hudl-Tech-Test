package stepdefinition;

import dataStore.NewEventData;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import pages.EventPage;

import java.util.List;
import java.util.Map;

@Log4j2
@Scope("cucumber-glue")
@RequiredArgsConstructor
public class EventPageStepDef {
    private final EventPage eventPage;

    @Given("The Event is created successfully with following details")
    public void event_is_created_successfully_with_following_details(List<Map<String, String>> dataTable) {
        // Access and use the dataTable to populate web fields
        for (Map<String, String> row : dataTable) {
            String fieldName = row.get("Field");
            String value = row.get("Value");
            eventPage.fillEventPage(fieldName, value);
        }


    }


}
