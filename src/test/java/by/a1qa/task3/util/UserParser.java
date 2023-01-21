package by.a1qa.task3.util;

import by.a1qa.task3.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserParser {
    private static final String USER_LIST_PATH = "src/test/resources/testData/users.json";
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static List<User> parseUserFromFileToList() throws IOException {
        List<User> users = null;
            users = objectMapper.readValue(new File(USER_LIST_PATH), new TypeReference<List<User>>() {});
        return users;
    }
}
