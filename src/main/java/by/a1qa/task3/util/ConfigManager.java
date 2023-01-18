package by.a1qa.task3.util;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class ConfigManager {

    private static final String CONFIG_FILE_PATH = "src/test/resources/testConfig/config.json";

    public static String getBrowserName() throws IOException, ParseException {
        return JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "browserName");
    }

    public static String getURL() throws IOException, ParseException {
        return JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "url");
    }

    public static int getWaitDurationInSeconds() throws IOException, ParseException {
        return Integer.parseInt(JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "waitDuration"));
    }

    public static List<String> getOptions() throws IOException, ParseException {
        return JSONCustomParser.parseArrayToListByName(CONFIG_FILE_PATH, "options");
    }
}
