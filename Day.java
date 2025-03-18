import java.util.Date;

public class Day {
    private boolean workday;
    private boolean booked;
    private int month;
    private int day;
    private int year;
    private String date;

    public Day(boolean isWorkday,int day, int month, int year) {
        this.workday = isWorkday;
        this.month = month;
        this.day = day;
        this.year = year;
        this.date = this.day + "/" + this.month + "/" + this.year;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
