import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // variables
        int leftoverVacationDays;
        int currentYear = 2025;
        boolean isLeapYear = false;
        LinkedList<Day> haveToBookDays = new LinkedList<>();
        LinkedList<Day> days = new LinkedList<>();

        // holiday presets
        Day[] germanyBadenWürtemberg = new Day[12];
        germanyBadenWürtemberg[0] = new Day(false, 1, 1, currentYear);
        germanyBadenWürtemberg[1] = new Day(false, 6, 1, currentYear);
        germanyBadenWürtemberg[2] = new Day(false, 18, 4, currentYear);
        germanyBadenWürtemberg[3] = new Day(false, 21, 4, currentYear);
        germanyBadenWürtemberg[4] = new Day(false, 1, 5, currentYear);
        germanyBadenWürtemberg[5] = new Day(false, 29, 5, currentYear);
        germanyBadenWürtemberg[6] = new Day(false, 9, 6, currentYear);
        germanyBadenWürtemberg[7] = new Day(false, 19, 6, currentYear);
        germanyBadenWürtemberg[8] = new Day(false, 3, 11, currentYear);
        germanyBadenWürtemberg[9] = new Day(false, 1, 12, currentYear);
        germanyBadenWürtemberg[10] = new Day(false, 25, 12, currentYear);
        germanyBadenWürtemberg[11] = new Day(false, 26, 12, currentYear);
        int[] germanyBadenWürtembergDayOfYearValues = Day.generateDayOfYearValues(germanyBadenWürtemberg);
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
        int currentMonth = 1;
        int currentDay = 1;
        int startDayOfYear = 0;
        int daysInTheYear = 365;
        if (isLeapYear)
            daysInTheYear = 366;

        //time complexity for algorithm O=n^1
        for (int i = (startDayOfYear - 1); i < daysInTheYear; i++) {
            Day day = null;
            if (currentDay == 31 && (currentMonth == 1 || currentMonth == 3 || currentMonth == 5 || currentMonth == 7
                    || currentMonth == 10 || currentMonth == 12)) { //check for months with 31 days
                currentMonth++;
                currentDay = 1;
            } else if (currentDay == 30) { //check for months with 30 days
                currentMonth++;
                currentDay = 1;
            } else if (isLeapYear && currentDay == 28 && currentMonth==2) { //check for februare
                currentMonth++;
                currentDay=1;
            } else {
                currentDay++;
            }

            if (i % 7 == 5 || i % 7 == 6) { // check for saturday or sunday
                day = new Day(false, currentDay, currentMonth, currentYear);
            }
            else if (germanyBadenWürtembergDayOfYearValues) {
                
            }
            else {
                day = new Day(true, currentDay, currentMonth, currentYear);
            }

            days.add(day);
        }

        System.out.println("finished");
        // show ouput
    }
}
