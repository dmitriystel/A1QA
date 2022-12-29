package by.a1qa.task2_1.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class JSONCustomParser {
    private static JSONParser parser = new JSONParser();

    public static String parseElementByName(String path, String elementName){
        String value = null;
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
            value = (String) jsonObject.get(elementName);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return value;
    }
}
