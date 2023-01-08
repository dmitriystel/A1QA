package by.a1qa.task3.util;

import by.a1qa.task3.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserParser {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static List<User> parseUserFromFileToList(String path) {
        List<User> users = null;
        try {
            users = objectMapper.readValue(new File(path), new TypeReference<List<User>>() {});
        } catch (IOException e) {
            CustomLogger.error("UserParser.parseUserFromFileToList() : " + path);
            e.printStackTrace();
        };
        return users;
    }
}
