package src.main.java.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

import src.main.java.model.Config;

public class ConfigUtils {

    /**
     * Will read current config file
     * @return Properties Object of Config.path
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static Properties decodeFile() throws IOException, FileNotFoundException {
        Properties props = new Properties();

        // read properties file
        try (FileInputStream in = new FileInputStream(Config.configPath)) {
            props.load(in);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Config file not found");
        } catch (IOException e) {
            throw new IOException(e);
        }

        return props;
    }

}
