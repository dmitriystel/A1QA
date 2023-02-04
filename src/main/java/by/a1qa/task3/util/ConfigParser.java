package by.a1qa.task3.util;

import by.a1qa.task3.model.Config;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigParser {
    public static Config parseConfigDataFromFileToConfigObject(Config config, String path) {
        CustomLogger.info("ConfigParser.parseConfigDataFromFileToConfigObject(Config config, String path)");
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        config.setBrowserName((String)jsonObject.get("browserName"));
        config.setUrl((String)jsonObject.get("url"));
        config.setWaitDuration((String)jsonObject.get("waitDuration"));
        config.setOptions((String)jsonObject.get("options"));
        return config;
    }
}



