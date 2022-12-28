package by.a1qa.task2_1.test;

import by.a1qa.task2_1.bean.GameInformation;
import by.a1qa.task2_1.page.GameSearchPage;
import by.a1qa.task2_1.page.MainPage;
import by.a1qa.task2_1.util.ConfigManager;
import by.a1qa.task2_1.util.ParserJavaToJson;
import by.a1qa.task2_1.util.ParserJsonToJava;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class GameSearchTest extends BaseTest  {
    @Test
    public void testGameSearch() throws IOException {
        MainPage mainPage = new MainPage();
        MainPage mainPage2 = new MainPage();
        GameSearchPage searchResultPage;
        GameSearchPage searchResultPage2;

        searchResultPage = mainPage
                .navigateToMainPage()
                .searchGame(ConfigManager.getGameTitleDota2());

        Assert.assertTrue(searchResultPage.isPageOpen(), "Results page isn't open.");

        Assert.assertTrue(searchResultPage.isSearchBoxOnResultPageContainsSearchedName(ConfigManager.getGameTitleDota2()),
                "Search box on result page doesn't contain searched name");

        Assert.assertTrue(searchResultPage.isTheFirstNameIsEqualsToSearchName(),
                "The first name isn't equal to searched name.");


        List<GameInformation> gameInformationList1 = searchResultPage.getGamesInfoResults();
        ParserJavaToJson.writeJavaInJson(ConfigManager.getFirstSearchResultPath(), gameInformationList1);

        String secondGameTitle = gameInformationList1.get(1).getTitle();


        searchResultPage2 = mainPage2
                .navigateToMainPage()
                .searchGame(secondGameTitle);

        List<GameInformation> gameInformationList2 = searchResultPage.getGamesInfoResults();
        ParserJavaToJson.writeJavaInJson(ConfigManager.getSECOND_SEARCH_GAME_RESULTS_PATH(), gameInformationList2);

        Assert.assertTrue(searchResultPage.isSearchBoxOnResultPageContainsSearchedName(secondGameTitle),
                "Search box on result page doesn't contain searched name");


        List<GameInformation> gameInfoResult1FromDB = ParserJsonToJava.jsonParse(ConfigManager.getFirstSearchResultPath());
        List<GameInformation> gameInfoResult2FromDB = ParserJsonToJava.jsonParse(ConfigManager.getSECOND_SEARCH_GAME_RESULTS_PATH());
//        return gameInfoResult1FromDB.containsAll(gameInfoResult2FromDB);

        Assert.assertEqualsNoOrder(gameInfoResult1FromDB, gameInfoResult2FromDB,
                "The results of the first search don't match the results of the second search.");


    }







//        searchResultPage2 = mainPage2
//                .navigateToMainPage()
//                .secondSearchGame(GameInfoResult1_Game2_Name)
//                .getGameInfoResult2();

//        Assert.assertTrue(searchResultPage2.isSearchBoxOnResultPageContainsSearchedName2(),
//                "Search box on result page doesn't contain searched name" );
//        Assert.assertTrue(searchResultPage2.isStoredItemsAreMatched(),
//                "The results of the first search don't match the results of the second search.");
//    }
}