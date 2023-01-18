package by.a1qa.task3.util;

import by.a1qa.task3.model.Config;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONCustomParser {

    private static JSONParser parser = new JSONParser();
    public static List<String> parseArrayToListByName(String path, String elementName) throws IOException, ParseException {
        List<String> values = new ArrayList<>();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
            JSONArray elements = (JSONArray)jsonObject.get(elementName);
            for(Object obj : elements){
                values.add(obj.toString());
            }
        return values;
    }

//    public static List<Config> parseArrayToList(String path, String elementName) throws IOException, ParseException {
//        List<String> values = new ArrayList<>();
//        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
//        JSONArray elements = (JSONArray)jsonObject.get(elementName);
//        for(Object obj : elements){
//            values.add(obj.toString());
//        }
//        return values;
//    }






    public static String parseElementByName(String path, String elementName) throws IOException, ParseException {
        String value = null;
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
            value = (String) jsonObject.get(elementName);
        return value;
    }
}
