package src.main.java.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public abstract class PresetUtils {
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

    public static boolean validateDaysString(String daysString) {
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
            String[] elements = parts[0].split("/");
            if (Integer.parseInt(elements[0]) <= 31 && Integer.parseInt(elements[1]) <= 12) {
                return true;
            } else {
                return false;
                
            }
        }

        return false;
    }
}
