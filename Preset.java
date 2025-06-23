import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Preset {
    String name;
    ArrayList<Integer> days;

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
        String name;
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
        name = props.getProperty("name");

        if (daysString == null || name == null || validateDaysString(daysString)) {
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

    public static String[] getAvailableTemplates() {
        File folder = new File("./presets");

        String[] files = folder.list();
        return files;
    }

    public static void createNewPreset(String presetName, String daysString) throws IOException {
        Properties properties = new Properties();

        if (!validateDaysString(daysString)) {
            throw new IOException("Invalid configuration found while creating preset ! String "+daysString+" isn't properly formatted");
        }

        properties.setProperty("days", daysString);

        OutputStream output = new FileOutputStream("./presets/" + presetName + ".properties");
        properties.store(output, "");
    }

    private static boolean validateDaysString(String daysString) {
        String[] parts = daysString.split(",");

        System.out.println("Validating Sting : "+daysString+ parts.length);

        if(parts.length>1) {
            for(String part : parts) {
                String[] elements = part.split("/");
                if(Integer.parseInt(elements[0]) <= 31 && Integer.parseInt(elements[1]) <= 12) {
                    return true;
                }
                else {
                    System.out.println(1);
                    return false;
                }
            }
        }
        else {
            System.out.println("test");
            String[] elements = parts[0].split("/");
            if (Integer.parseInt(elements[0]) <= 31 && Integer.parseInt(elements[1]) <= 12) {
                return true;
            } else {
                System.out.println(2);
                return false;
                
            }
        }

        return false;
    }
}
