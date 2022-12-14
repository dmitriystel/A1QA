package test;

import entity.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import parser.Parser;
import service.ArrayListService;

import java.io.IOException;
import java.util.List;

public class ValidateUserFilesTest {
    ArrayListService arrayListService;

    @BeforeClass
    public void setUp(){
        arrayListService = new ArrayListService();
    }

    @DataProvider(name = "jsonFile")
    public Object[][] createPathJson(){
        return new Object[][]{
                {"src/test/resources/admin_users.json"},
                {"src/test/resources/regular_users.json"}
        };
    }

    @Test(dataProvider = "jsonFile")
    public void validateJsonFileContainsListOfUsers(String jsonFile) throws IOException {
        List<User> userListJson =  Parser.jsonParse(jsonFile);
        int expectedResult = userListJson.size();
        int actualResult = arrayListService.validateUserHaveIdAndName(userListJson);

        Assert.assertEquals(expectedResult, actualResult, "Not every user contains an ID and a name in json file");
    }

    @DataProvider(name = "yamlFile")
    public Object[][] createPathYaml(){
        return new Object[][]{
                {"src/test/resources/admin_users.yaml"},
                {"src/test/resources/regular_users.yaml"}
        };
    }

    @Test(dataProvider = "yamlFile")
    public void validateYamlFileContainsListOfUsers(String yamlFile) throws IOException {
        List<User> userListYaml =  Parser.yamlParse(yamlFile);
        int expectedResult = userListYaml.size();
        int actualResult = arrayListService.validateUserHaveIdAndName(userListYaml);
        Assert.assertEquals(expectedResult, actualResult,
                "Not every user contains an ID and a name in yaml file");
    }

    @DataProvider(name = "files")
    public Object[][] createPathFile(){
        return new Object[][]{
                {"src/test/resources/admin_users.json", "src/test/resources/admin_users.yaml"},
                {"src/test/resources/regular_users.json", "src/test/resources/regular_users.yaml"}
        };
    }
    @Test(dataProvider = "files")
    public void validateAllUsersListedInJsonIncludedInListOfUsersFromYaml(String jsonFile, String yamlFile) throws IOException {
        List<User> userListJson =  Parser.jsonParse(jsonFile);
        List<User> userListYaml =  Parser.yamlParse(yamlFile);
        int expectedResult = userListJson.size();
        int actualResult = arrayListService.validateAllUsersInJsonIncludedUsersFromYaml(userListJson, userListYaml);

        Assert.assertEquals(expectedResult, actualResult,
                "Not all users that listed in json file are included in the list of users from yaml file");
    }

    @AfterClass
    public void tierDown(){
        arrayListService = null;
    }
}
