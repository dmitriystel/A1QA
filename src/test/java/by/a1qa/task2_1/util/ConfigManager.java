package by.a1qa.task2_1.util;

public class ConfigManager {
    private static final String CONFIG_FILE_PATH = "src/test/resources/configData/config.json";
    private static final String TEST_FILE_PATH = "src/test/resources/testData/test.json";
    private static final String FIRST_SEARCH_RESULT_FILE_PATH = "src/test/resources/testData/FirstSearchResultListDB.json";


    public static String getURL(){
        return JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "url");
    }

    public static int getWaitDurationInSeconds(){
        return Integer.parseInt(JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "waitDuration"));
    }

    public static String getBrowserMode(){
        return JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "browserMode");
    }

    public static String getGameTitleDota2(){
        return JSONCustomParser.parseElementByName(TEST_FILE_PATH, "gameTitleDota2");
    }


    public static String getFirstSearchResultPath(){
        return JSONCustomParser.parseElementByName(TEST_FILE_PATH, "FIRST_SEARCH_RESULT_LIST_DB_PATH");
    }

    public static String getSECOND_SEARCH_GAME_RESULTS_PATH(){
        return JSONCustomParser.parseElementByName(TEST_FILE_PATH, "SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH");
    }


    public static String getLanguageSupport(){
        return JSONCustomParser.parseElementByName(TEST_FILE_PATH, "LANGUAGE_SUPPORT");
    }





//    public static String getFirstGameFirstSearch(){
//        return JSONCustomParser.parseElementByName(DOTA2_SEARCH_RESULT_FILE_PATH, "SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH");
//    }




}