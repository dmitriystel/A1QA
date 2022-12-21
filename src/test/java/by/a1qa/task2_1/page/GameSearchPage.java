package by.a1qa.task2_1.page;

import by.a1qa.task2_1.bean.GameInformation;
import by.a1qa.task2_1.bean.Platform;
import by.a1qa.task2_1.util.ConfigManager;
import by.a1qa.task2_1.util.ParserJavaToJson;
import by.a1qa.task2_1.util.ParserJsonToJava;
import by.a1qa.task2_1.wait.ConditionalWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameSearchPage extends BasePage {
    public GameSearchPage(WebDriver driver) {
        super(driver);
    }
    public static final String DOTA2_SEARCH_RESULT_LIST_DB_PATH = "src/test/resources/testData/Dota2SearchResultListDB.json";
    public static final String SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH = "src/test/resources/testData/SecondSearchGameResultListDB.json";

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='title']")
    private WebElement searchResultFirstGameName;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//span[@class='title']")
    private WebElement searchResultSecondGameName;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='platform_img win']")
    private WebElement WinPlatform;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='platform_img mac']")
    private WebElement MacPlatform;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='platform_img linux']")
    private WebElement LinuxPlatform;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//div[contains(@class,'released')]")
    private WebElement searchResultFirstGameReleaseDate;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//div[contains(@class,'released')]")
    private WebElement searchResultSecondGameReleaseDate;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[contains(@class,'summary')]")
    private WebElement searchResultFirstGameReviewSummaryResult;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//span[contains(@class,'summary')]")
    private WebElement searchResultSecondGameReviewSummaryResult;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//div[contains(@class,'price_')]")
    private WebElement searchFirstResultFirstGamePrice;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//div[contains(@class,'col search_price ')]")
    private WebElement searchSecondResultSecondGamePrice;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//div[contains(@class,'col search_price_')]")
    private WebElement searchFirstResultSecondGamePrice;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//div[contains(@class,'col search_price_')]")
    private WebElement searchSecondResultFirstGamePrice;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//span[@class='platform_img music']")
    private WebElement searchResultSecondGameRemixMusic;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='platform_img music']")
    private WebElement searchSecondResultFirstGameRemixMusic;

    @FindBy (name = "displayterm")
    private WebElement searchField2;

    @FindBy (xpath = "//*[@class='searchbar']//button/span")
    private WebElement searchInSearchField2;

    @FindBy (id = "search_results_filtered_warning_persistent")
    private WebElement searchResultsFiltered;

    public Boolean isPageOpen(){
        ConditionalWait.waitElementDisappears(searchResultsFiltered);
        return searchResultsFiltered.isDisplayed();
    }

    public Boolean isSearchBoxOnResultPageContainsSearchedName(){
        return (searchField2.getAttribute("value")).equals(ConfigManager.getGameTitle());
    }

    public Boolean isSearchBoxOnResultPageContainsSearchedName2(){
        return (searchField2.getAttribute("value")).equals(searchResultFirstGameName.getText());
    }

    public Boolean isTheFirstNameIsEqualsToSearchName(){
        return (searchResultFirstGameName.getText()).equals(ConfigManager.getGameTitle());
    }

    public GameSearchPage getGameInfoResult1() throws IOException {
        List<GameInformation> gameInfoResult1 = new ArrayList<>();

        GameInformation gameInfoResult1_Game1 =
                new GameInformation(searchResultFirstGameName.getText(),
                        new Platform(WinPlatform.getAttribute("class"),
                                MacPlatform.getAttribute("class"),
                                LinuxPlatform.getAttribute("class")),
                        searchResultFirstGameReleaseDate.getText(),
                        searchResultFirstGameReviewSummaryResult.getAttribute("data-tooltip-html"),
                        searchFirstResultFirstGamePrice.getText() );
        gameInfoResult1.add(gameInfoResult1_Game1);

        GameInformation gameInfoResult1_Game2 =
                new GameInformation(searchResultSecondGameName.getText(),
                        new Platform(searchResultSecondGameRemixMusic.getAttribute("class")),
                        searchResultSecondGameReleaseDate.getText(),
                        searchResultSecondGameReviewSummaryResult.getAttribute("data-tooltip-html"),
                        searchFirstResultSecondGamePrice.getText());
        gameInfoResult1.add(gameInfoResult1_Game2);

        ParserJavaToJson.writeJavaInJson(DOTA2_SEARCH_RESULT_LIST_DB_PATH, gameInfoResult1);

        return this;
    }

    public String getSearchResultSecondGameName(){
        return searchResultSecondGameName.getText();
    }
    public GameSearchPage getGameInfoResult2() throws IOException {
        List<GameInformation> gameInfoResult2 = new ArrayList<>();

        GameInformation gameInfoResult2_Game1 =
                new GameInformation(searchResultFirstGameName.getText(),
                        new Platform(searchSecondResultFirstGameRemixMusic.getAttribute("class")),
                        searchResultFirstGameReleaseDate.getText(),
                        searchResultFirstGameReviewSummaryResult.getAttribute("data-tooltip-html"),
                        searchSecondResultFirstGamePrice.getText());
        gameInfoResult2.add(gameInfoResult2_Game1);

        GameInformation gameInfoResult2_Game2 =
                new GameInformation(searchResultSecondGameName.getText(),
                        new Platform(searchResultSecondGameRemixMusic.getAttribute("class")),
                        searchResultSecondGameReleaseDate.getText(),
                        searchResultSecondGameReviewSummaryResult.getAttribute("data-tooltip-html"),
                        searchSecondResultSecondGamePrice.getText());
        gameInfoResult2.add(gameInfoResult2_Game2);

        ParserJavaToJson.writeJavaInJson(SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH, gameInfoResult2);
        return this;
    }

    public Boolean isStoredItemsAreMatched() throws IOException {
        List<GameInformation> gameInfoResult1FromDB = ParserJsonToJava.jsonParse(DOTA2_SEARCH_RESULT_LIST_DB_PATH);
        List<GameInformation> gameInfoResult2FromDB = ParserJsonToJava.jsonParse(SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH);
        return gameInfoResult1FromDB.containsAll(gameInfoResult2FromDB);
    }
}