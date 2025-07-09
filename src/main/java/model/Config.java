package src.main.java.model;

import java.time.LocalDate;

public class Config {

    public int currentYear;
    public int startWeekday;
    public int startDayOfYear;
    public boolean isLeapYear;

    public Config() {
        this.currentYear = LocalDate.now().getYear();
        this.isLeapYear = (this.currentYear % 2 == 0)
                && (this.currentYear % 4 == 0 && (this.currentYear % 100 != 0 || this.currentYear % 400 == 0));
        this.startDayOfYear = LocalDate.of(this.currentYear, 1, 1).getDayOfWeek().getValue();
        this.startWeekday = this.startDayOfYear;
    }

}
