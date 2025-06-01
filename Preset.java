import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class Preset {
    String name;
    String days;

    public Preset(String FileName) {

    }

    public LinkedList<Day> decodeFile(String fileName, int currentYear, int START_WEEKDAY) {
        LinkedList<Day> days = new LinkedList<>();
        String daysString;
        String name;

        // read properties file
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream("/presets/" + fileName)) {
            props.load(in);
        } catch (FileNotFoundException e) {
            System.err.println("Preset file not found: " + fileName);
            return new LinkedList<>();
        } catch (IOException e) {
            System.err.println("I/O Exception ocurred while loading properties " + e.getMessage());
            return new LinkedList<>();
        }

        daysString = props.getProperty("days");
        name = props.getProperty("name");
        if (daysString == null || name == null) {
            System.err.println("Preset file invalid :  " + fileName);
            return new LinkedList<>();
        }

        // decoding preset file
        String[] daysStringArray = daysString.split(",");
        for (String dayString : daysStringArray) {
            String[] parts = dayString.trim().split("/");
            Day day = new Day(false, Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]),
                    START_WEEKDAY);
            days.add(day);
        }

        return days;
    }
}
