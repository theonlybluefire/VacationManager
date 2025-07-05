package src.main.java.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

import src.main.java.model.Day;

public abstract class PresetUtils {
    /**
     * @return String[] of all preset files inside the preset folder
     */
    public static String[] getAvailablePresets() {
        File folder = new File("../presets");

        String[] files = folder.list();
        return files;
    }

    /**
     * @param presetName Name of the preset (without path)
     * @param daysString String to be written in the "days" section of the preset
     * @throws IOException
     */
    public static void createNewPreset(String presetName, String daysString) throws IOException {
        String path = "./src/main/java/presets/" + presetName + ".properties";

        Properties properties = new Properties();

        if (!validateDaysString(daysString)) {
            throw new IOException("Invalid configuration found while creating preset ! String " + daysString
                    + " isn't properly formatted");
        }
        properties.setProperty("days", daysString);

        OutputStream output = new FileOutputStream(path);
        properties.store(output, "");
        output.close();
    }

    /**
     * Will validate a "daysString" (String in the "days" section of a preset)
     * @param daysString String to validated
     * @return will return false if not valid and true if valid
     */
    public static boolean validateDaysString(String daysString) {
        String[] parts = daysString.split(",");

        if (parts.length > 1) {
            for (String part : parts) {
                String[] elements = part.split("/");
                if (Integer.parseInt(elements[0]) <= 31 && Integer.parseInt(elements[1]) <= 12) {
                    return true;
                } else {
                    System.out.println(1);
                    return false;
                }
            }
        } else {
            String[] elements = parts[0].split("/");
            if (Integer.parseInt(elements[0]) <= 31 && Integer.parseInt(elements[1]) <= 12) {
                return true;
            } else {
                return false;

            }
        }

        return false;
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
    public static ArrayList<Day> decodeFile(String fileName, int currentYear, int START_WEEKDAY)
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
