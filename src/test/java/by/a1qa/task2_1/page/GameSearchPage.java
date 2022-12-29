package by.a1qa.task2_1.page;

import by.a1qa.task2_1.bean.GameInformation;
import by.a1qa.task2_1.bean.Platform;
import by.a1qa.task2_1.driver.DriverSingleton;
import by.a1qa.task2_1.util.ConfigManager;
import by.a1qa.task2_1.wait.ConditionalWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class GameSearchPage extends BasePage {
    By gameRowsLocator = By.xpath("//a[contains(@class,'search_result_row')]");
    By nameLocator = By.xpath(".//span[contains(@class, 'title')]");
    By platformLocator = By.xpath(".//span[contains(@class, 'platform')]");
    By releaseDateLocator = By.xpath(".//div[contains(@class, 'release')]");
    By reviewSummaryResultLocator = By.xpath(".//span[contains(@class, 'review')]");
    By priceLocator = By.xpath(".//div[contains(@class, 'price')]//div[contains(@class, 'price')]");
    By searchResultsFilteredLocator = By.id("search_results_filtered_warning_persistent");
    By searchFieldLocator = By.name("displayterm");
    public GameSearchPage() {
        super();
    }

    public Boolean isTheFirstNameIsEqualsToSearchName() {
        return ((DriverSingleton.getInstance()).findElement(nameLocator).getText())
                .equals(ConfigManager.getGameTitleDota2());
    }
    public List<GameInformation> getGamesInfoResults() {
        List<WebElement> gameRows = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            gameRows.add((DriverSingleton.getInstance()).findElements(gameRowsLocator).get(i));
        }
        List<GameInformation> gameInfoResults = new ArrayList<>();
        for (WebElement element : gameRows) {
            gameInfoResults.add(getGameInfo(element));
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
        String reviewSummaryResult = element.findElement(reviewSummaryResultLocator)
                .getAttribute("data-tooltip-html");
        String price = element.findElement(priceLocator).getText();
        GameInformation gameInfoResult = new GameInformation(title, new Platform(windowsOrRemixe, macOS, steamOS),
                releaseDate, reviewSummaryResult, price);
        return gameInfoResult;
    }

    public Boolean isPageOpen() {
        ConditionalWait.waitElementDisappears(searchResultsFilteredLocator);
        return driver.findElement(searchResultsFilteredLocator).isDisplayed();
    }

    public Boolean isSearchBoxOnResultPageContainsSearchedName(String gameTitle) {
        return ((DriverSingleton.getInstance()).findElement(searchFieldLocator).getAttribute("value"))
                .equals(gameTitle);
    }
}