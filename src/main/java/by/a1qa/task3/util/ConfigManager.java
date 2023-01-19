package by.a1qa.task3.util;

import by.a1qa.task3.model.Config;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class ConfigManager {
    private static final String CONFIG_FILE_PATH = "src/test/resources/testConfig/config.json";
    private static Config config;

    public static Config getConfig() throws IOException, ParseException {
        if (config == null){
            config = ConfigParser.parseConfigDataFromFileToConfigObject(new Config(), CONFIG_FILE_PATH);
        }
        return config;
    }

    public static String getBrowserName() throws IOException, ParseException {
        return getConfig().getBrowserName();
    }

    public static String getURL() throws IOException, ParseException {
        return getConfig().getUrl();
    }

    public static int getWaitDurationInSeconds() throws IOException, ParseException {
        return Integer.parseInt(getConfig().getWaitDuration());
    }

    public static String getOptions() throws IOException, ParseException {
        return getConfig().getOptions();
    }
}
