package src.main.java.logic;

import java.util.ArrayList;
import java.util.LinkedList;

import src.main.java.model.Day;
import src.main.java.model.Preset;

public abstract class DayModelLogic {

     static public LinkedList<Day> generateDayModel(Preset preset,int CURRENT_YEAR, int START_WEEKDAY, int START_DAY_OF_YEAR,boolean IS_LEAP_YEAR) {
        int leftoverVacationDays;
        LinkedList<Day> haveToBookDays = new LinkedList<>();
        LinkedList<Day> days = new LinkedList<>();
        int currentMonth = 1;
        int currentDay = 0;
        int daysInTheYear = 365;

        if (IS_LEAP_YEAR)
            daysInTheYear = 366;

        ArrayList<Integer> MonthsWith31Days = new ArrayList<>();
        MonthsWith31Days.add(1);
        MonthsWith31Days.add(3);
        MonthsWith31Days.add(5);
        MonthsWith31Days.add(7);
        MonthsWith31Days.add(8);
        MonthsWith31Days.add(10);
        MonthsWith31Days.add(12);
        

        for (int i = (START_DAY_OF_YEAR - 1); i < (daysInTheYear-1); i++) {
            Day day = null; //create new day object
            if(currentDay == 31) {
                System.out.println("INFO -> month with 31 days"+MonthsWith31Days.contains(currentMonth));
            }
            if (currentDay == 31 && MonthsWith31Days.contains(currentMonth)) { //31 day month
                System.out.println("INFO -> new Month, current Mothn "+currentMonth+"current Day of the year "+i+"");
                currentMonth++;
                currentDay = 1;
            } else if (currentDay == 30 && !MonthsWith31Days.contains(currentMonth)) { //30 day month
                currentMonth++;
                currentDay = 1;
            } else if (!IS_LEAP_YEAR && currentDay == 28 && currentMonth == 2) { // february and not leap year
                currentMonth++;
                currentDay=1;
            } else if (IS_LEAP_YEAR && currentDay == 29 && currentMonth == 2 ) { // february and leap year 
                //TODO: add leap year input
                currentMonth++;
                currentDay=1;
            } else { // normal day
                currentDay++;
            }

            day = new Day(true, currentDay, currentMonth, CURRENT_YEAR, START_WEEKDAY);
            if (day.weekday == 7 || day.weekday==6) { // check for saturday or sunday
                day.setWorkday(false);
            }

            else if (preset.days.contains(day.dayOfYear)) {
                day.setWorkday(false);
            }

            days.add(day);
        }
        return days;
    }
}
