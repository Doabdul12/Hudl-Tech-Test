package dataStore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateSetter {


    private String currentDay() {
        // Create a Calendar instance
        Calendar calendar = Calendar.getInstance();

        // Get the current day of the week (Sunday = 1, Monday = 2, ..., Saturday = 7)
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Convert the day of the week to a string representation
        String[] daysOfWeek = {"", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String currentDay = daysOfWeek[dayOfWeek];

        System.out.println("Current day: " + currentDay);
        return currentDay;
    }

    public String getAnnouncementDate(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy, HH:mm,");
        return dateFormat.format( currentDay() + "," + currentDate);
    }
}
