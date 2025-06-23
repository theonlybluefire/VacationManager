package src.main.java;
import java.time.Month;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.Scanner;

import src.main.java.model.Day;
import src.main.java.model.Preset;
import src.main.java.utils.StartupUtils;

public class main {
    public static void main(String[] args) {
        // variables
        int leftoverVacationDays;
        int currentYear = 2025;
        boolean IS_LEAP_YEAR = false;
        LinkedList<Day> haveToBookDays = new LinkedList<>();
        LinkedList<Day> days = new LinkedList<>();int currentMonth = 1;
        int currentDay = 0;
        int startDayOfYear = 0;
        int daysInTheYear = 365;
        final int START_WEEKDAY = 2;
        if (IS_LEAP_YEAR)
            daysInTheYear = 366;

            StartupUtils.startup();
        try {
            Preset.createNewPreset("test", "12/12,");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        

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

        //test preset 
        String name = "test";
        Preset myPreset = new Preset(name, currentYear, START_WEEKDAY);
        System.out.println(myPreset.days);

        //create a list of all days in the year
        
        System.out.println("finished");
        // show ouput
    }
}
