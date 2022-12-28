package by.a1qa.task2_1.page;

import by.a1qa.task2_1.bean.GameInformation;
import by.a1qa.task2_1.bean.Platform;
import by.a1qa.task2_1.driver.DriverSingleton;
import by.a1qa.task2_1.util.ConfigManager;
import by.a1qa.task2_1.util.ParserJavaToJson;
import by.a1qa.task2_1.util.ParserJsonToJava;
import by.a1qa.task2_1.wait.ConditionalWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
Code review 23.12.2022
3rd comment: @findby will look for an item in the locator right away, even if we don't need it yet,
so we shouldn't use it. Use findElement
fixed: findElement is used

6th comment: It is bad practice to tie locators to an index. It can change at any time
fixed: locators without indexes

7th comment: The variable names should be clear. which field number 2 is not quite clear
fixed: renamed

8th comment: the exception should be handled locally, not thrown in the upper levels
fixed

9th comment: code duplication. Similar code in the getGameInfoResult1() method
Make one universal method and call it wherever you need
fixed: made one universal method - getGameInfo

10th comment: All checks must be in the tests
fixed: moved to test method


*/
public class GameSearchPage extends BasePage {
    public GameSearchPage() {
        super();
    }

    By gameRowsLocator = By.xpath("//a[contains(@class,'search_result_row')]");
    By nameLocator = By.xpath(".//span[contains(@class, 'title')]");
    By platformLocator = By.xpath(".//span[contains(@class, 'platform')]");
    //    By platformInWebElementLocator = By.xpath("//span[contains(@class, 'platform')]");
    By releaseDateLocator = By.xpath(".//div[contains(@class, 'release')]");
    By reviewSummaryResultLocator = By.xpath(".//span[contains(@class, 'review')]");
    By priceLocator = By.xpath(".//div[contains(@class, 'price')]//div[contains(@class, 'price')]");
    By searchResultsFilteredLocator = By.id("search_results_filtered_warning_persistent");
    By searchField2Locator = By.name("displayterm");

    public Boolean isTheFirstNameIsEqualsToSearchName() {
        return ((DriverSingleton.getInstance()).findElement(nameLocator).getText()).equals(ConfigManager.getGameTitleDota2());
    }

    public List<GameInformation> getGamesInfoResults() {
        List<WebElement> gameRows = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            gameRows.add((DriverSingleton.getInstance()).findElements(gameRowsLocator).get(i));
        }
        List<GameInformation> gameInfoResults = new ArrayList<>();
        for (WebElement element : gameRows) {
            gameInfoResults.add(getGameInfo(element));
            ;
        }
        return gameInfoResults;
    }

    public GameInformation getGameInfo(WebElement element) {
        String title = element.findElement(nameLocator).getText();
        List<WebElement> platforms;
        platforms = element.findElements(platformLocator);
        int i = 0;
        String windowsOrRemixe = "not provided";
        String macOS = "not provided";
        String steamOS = "not provided";
        for (WebElement platform : platforms) {
            i++;
            if (i == 1) {
                if (platform.isDisplayed()) {
                    windowsOrRemixe = platform.getAttribute("class");
                }
            } else if (i == 2) {
                if (platform.isDisplayed()) {
                    macOS = platform.getAttribute("class");
                }
            } else if (i == 3) {
                if (platform.isDisplayed()) {
                    steamOS = platform.getAttribute("class");
                }
            }
        }

        String releaseDate = element.findElement(releaseDateLocator).getText();
        String reviewSummaryResult = element.findElement(reviewSummaryResultLocator).getAttribute("data-tooltip-html");
        String price = element.findElement(priceLocator).getText();
        GameInformation gameInfoResult = new GameInformation(title, new Platform(windowsOrRemixe, macOS, steamOS), releaseDate, reviewSummaryResult, price);
        return gameInfoResult;
    }


    By searchInSearchField2Locator = By.xpath("//*[@class='searchbar']//button/span");

    public Boolean isPageOpen() {
        ConditionalWait.waitElementDisappears(searchResultsFilteredLocator);
        return driver.findElement(searchResultsFilteredLocator).isDisplayed();
    }

    public Boolean isSearchBoxOnResultPageContainsSearchedName(String gameTitle) {
        return ((DriverSingleton.getInstance()).findElement(searchField2Locator).getAttribute("value"))
                .equals(gameTitle);
    }
}