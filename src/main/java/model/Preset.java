package src.main.java.model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import src.main.java.utils.PresetUtils;

public class Preset extends PresetUtils {
    public ArrayList<Integer> days;

    public Preset(String FileName, int currentYear, int START_WEEKDAY) {
        try {
            this.days = Day.generateDayOfYearValues(decodeFile(FileName, 0, 0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * Decodes .properties preset file inside the preset folder; creates a Day
     * ArrayList with all non-workdays
     * .properties files follow following format :
     * days='day/month','..,','...'
     * name='presetIdentificatoin'
     * 
     * @param fileName      presetFileName
     * @param currentYear
     * @param START_WEEKDAY
     * @return ArrayList of Days with all non-workdays
     */
    public ArrayList<Day> decodeFile(String fileName, int currentYear, int START_WEEKDAY)
            throws IOException, FileNotFoundException {
        
        ArrayList<Day> days = new ArrayList<>();
        Properties props = new Properties();
        String daysString;
        String[] daysStringArray;

        // read properties file
        try (FileInputStream in = new FileInputStream("./presets/" + fileName + ".properties")) {
            props.load(in);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Preset file " + fileName + " not found");
        } catch (IOException e) {
            throw new IOException(e);
        }

        daysString = props.getProperty("days");

        if (daysString == null || !validateDaysString(daysString)) {
            System.err.println("Preset file invalid :  " + fileName);
            return new ArrayList<>();
        }

        // decoding preset file
        daysStringArray = daysString.split(",");

        for (String dayString : daysStringArray) {
            String[] parts = dayString.trim().split("/");

            Day day = new Day(false, Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), currentYear,
                    START_WEEKDAY);
            days.add(day);
        }

        return days;
    }

    
}
