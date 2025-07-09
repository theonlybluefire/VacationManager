package src.main.java.model;
import java.util.ArrayList;

import src.main.java.utils.PresetUtils;

public class Preset extends PresetUtils {
    public static final String path = "./src/main/java/presets/";

    public ArrayList<Integer> days;

    public Preset(String FileName, int currentYear, int START_WEEKDAY) {
        try {
            this.days = Day.generateDayOfYearValues(PresetUtils.decodeFile(FileName, 0, 0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    

    
}
