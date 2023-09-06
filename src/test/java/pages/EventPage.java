package pages;

import dataStore.DateSetter;
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
public class EventPage {

    @Delegate
    private final Common common;
    DateSetter dateSetter = new DateSetter();

    public void fillEventPage(String field, String value){

        if (field.equalsIgnoreCase("Type"))
            selectSelectorValue(field, value).click();
        if (field.equalsIgnoreCase("Title"))
            fillInputBox(field).sendKeys(value);
        if (field.equalsIgnoreCase("Genre"))
            clickSearchedItem(field, value);
        if (field.equalsIgnoreCase("Venue"))
            clickSearchedItem(field, value);
        if (field.equalsIgnoreCase("Timezone"))
            selectSelectorValue(field, value).click();
        if (field.equalsIgnoreCase("Announcement"))
            inputDate(value).sendKeys(dateSetter.getAnnouncementDate());
    }
}
