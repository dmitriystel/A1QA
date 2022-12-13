package parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import entity.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public static List<User> jsonParse(String path) throws IOException {
        File file = new File(path);
        ObjectMapper om = new ObjectMapper();
        List<User> users = Arrays.asList(om.readValue(Paths.get(String.valueOf(file)).toFile(), User[].class));
        return users;
    }

    public static List<User> yamlParse(String path) throws IOException {
        File file = new File(path);
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        List<User> users = om.readValue(file, new TypeReference<ArrayList<User>>(){});
        return users;
    }
}
