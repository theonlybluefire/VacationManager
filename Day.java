import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Day {
    private boolean workday;
    private boolean booked;
    private int month;
    private int day;
    private int year;
    final public LocalDate date;
    final public int dayOfYear;

    public Day(boolean isWorkday,int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        this.workday = isWorkday;
        this.month = month;
        this.day = day;
        this.year = year;
        this.date = date;
        this.dayOfYear = date.getDayOfYear();
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    static public ArrayList<Integer> generateDayOfYearValues(ArrayList<Day> dayArray) {
        ArrayList<Integer> dayOfYearArray = new ArrayList<>();

        for(Day dayOfYear : dayArray) {
            dayOfYearArray.add(dayOfYear.dayOfYear);
        }

        return dayOfYearArray;
    }

    
}
