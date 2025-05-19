import java.time.Month;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // variables
        int leftoverVacationDays;
        int currentYear = 2025;
        final boolean IS_LEAP_YEAR = false;
        LinkedList<Day> haveToBookDays = new LinkedList<>();
        LinkedList<Day> days = new LinkedList<>();int currentMonth = 1;
        int currentDay = 0;
        int startDayOfYear = 0;
        int daysInTheYear = 365;
        final int START_WEEKDAY = 2;
        if (IS_LEAP_YEAR)
            daysInTheYear = 366;
        // holiday presets
        ArrayList<Day> germanyBadenWuerttemberg = new ArrayList<>();
        germanyBadenWuerttemberg.add(new Day(false, 6, 1, currentYear, START_WEEKDAY));
        germanyBadenWuerttemberg.add(new Day(false, 18, 4, currentYear, START_WEEKDAY));
        germanyBadenWuerttemberg.add(new Day(false, 21, 4, currentYear));
        germanyBadenWuerttemberg.add(new Day(false, 1, 5, currentYear));
        germanyBadenWuerttemberg.add(new Day(false, 29, 5, currentYear));
        germanyBadenWuerttemberg.add(new Day(false, 9, 6, currentYear));
        germanyBadenWuerttemberg.add(new Day(false, 19, 6, currentYear));
        germanyBadenWuerttemberg.add(new Day(false, 3, 11, currentYear));
        germanyBadenWuerttemberg.add(new Day(false, 1, 12, currentYear));
        germanyBadenWuerttemberg.add(new Day(false, 25, 12, currentYear));
        germanyBadenWuerttemberg.add(new Day(false, 26, 12, currentYear));

        germanyBadenWuerttemberg.add(new Day(false, 26, 12, currentYear));
        ArrayList<Integer> germanyBadenWürtembergDayOfYearValues = Day.generateDayOfYearValues(germanyBadenWuerttemberg);

        ArrayList<Integer> MonthsWith31Days = new ArrayList<>();
        MonthsWith31Days.add(1);
        MonthsWith31Days.add(3);
        MonthsWith31Days.add(5);
        MonthsWith31Days.add(7);
        MonthsWith31Days.add(8);
        MonthsWith31Days.add(10);
        MonthsWith31Days.add(12);


        // user input
        /*
         * Scanner scanner = new Scanner(System.in);
         * /System.out.println("leftover Vacation days");
         * leftoverVacationDays = scanner.nextInt();
         * System.out.
         * println("When do you have to book vacation (Format : 01/12 - 2/1 , 02/12 - 3/1  )"
         * );
         * //readout ouput
         */

        // create linkedList for every day in the year

        
        

        //create a list of all days in the year
        for (int i = (startDayOfYear - 1); i < (daysInTheYear-1); i++) {
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
                currentMonth++;
                currentDay=1;
            } else { // normal day
                currentDay++;
            }

            day = new Day(false, currentDay, currentMonth, currentYear, START_WEEKDAY);
            if (day.weekday == 7 || day.weekday==6) { // check for saturday or sunday
                day.setWorkday(false);
            }
            else if (germanyBadenWürtembergDayOfYearValues.contains(i)) {
                day.setWorkday(false);
            }

            days.add(day);
        }

        System.out.println("finished");
        // show ouput
    }
}
