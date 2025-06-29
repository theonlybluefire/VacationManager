package src.main.java.model;
import java.time.LocalDate;
import java.util.ArrayList;

import src.main.java.logic.DayModelLogic;

public class Day extends DayModelLogic {
    private boolean workday;
    private boolean booked;
    private int month;
    private int day;
    private int year;
    final public int weekday;
    final public LocalDate date;
    final public int dayOfYear;
    final public String weekdayWritten;

    public void setWorkday(boolean workday) {
        this.workday = workday;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public Day(boolean isWorkday, int day, int month, int year, int START_WEEKDAY) {
        LocalDate date = LocalDate.of(year, month, day);
        this.workday = isWorkday;
        this.month = month;
        this.day = day;
        this.year = year;
        this.date = date;
        this.dayOfYear = date.getDayOfYear();
        this.weekday = (START_WEEKDAY + this.dayOfYear) % 7;
        this.weekdayWritten = getWeekdayWritten(weekday);
    }

    static public ArrayList<Integer> generateDayOfYearValues(ArrayList<Day> dayArray) {
        ArrayList<Integer> dayOfYearArray = new ArrayList<>();

        for (Day dayOfYear : dayArray) {
            dayOfYearArray.add(dayOfYear.dayOfYear);
        }

        return dayOfYearArray;
    }

   static private String getWeekdayWritten(int weekday) {
        switch (weekday) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 0:
                return "Sunday";
            default:
                return null;
        }
    }

}
