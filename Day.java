import java.lang.reflect.Array;
import java.time.LocalDate;
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

    static public int[] generateDayOfYearValues(Day[] dayArray) {
        int[] dayOfYearArray = new int[dayArray.length];
        for(int i = 0;i>dayArray.length;i++) {
            dayOfYearArray[i] = dayArray[i].dayOfYear;
        }
        return dayOfYearArray;
    }

    
}
