package src.main.java.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import src.main.java.utils.ConfigUtils;

public class Config {
    public static final String configPath = "src/main/java/config/config.properties";

    public int currentYear;
    public int startWeekday;
    public int startDayOfYear;
    public boolean isLeapYear;
    public int configSetOn;

    public Config() throws IOException, FileNotFoundException {
        Properties props = ConfigUtils.decodeFile();
        this.currentYear = Integer.parseInt(props.getProperty("currentYear"));
        this.startWeekday = Integer.parseInt(props.getProperty("startWeekday"));
        this.startDayOfYear = Integer.parseInt(props.getProperty("startDayOfYear"));
        this.isLeapYear = Boolean.parseBoolean(props.getProperty("isLeapYear"));
        this.configSetOn = Integer.parseInt(props.getProperty("configSetOn")); //year the config file was written
    }

}
