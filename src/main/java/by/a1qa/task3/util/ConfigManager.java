package by.a1qa.task3.util;

import java.util.List;

public class ConfigManager {

    private static final String CONFIG_FILE_PATH = "src/test/resources/testConfig/config.json";

    public static String getBrowserName(){
        return JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "browserName");
    }

    public static String getURL(){
        return JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "url");
    }

    public static int getWaitDurationInSeconds(){
        return Integer.parseInt(JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "waitDuration"));
    }

    public static List<String> getOptions(){
        return JSONCustomParser.parseArrayToListByName(CONFIG_FILE_PATH, "options");
    }
}
