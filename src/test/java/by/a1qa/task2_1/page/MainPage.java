package by.a1qa.task2_1.page;

import by.a1qa.task2_1.driver.DriverSingleton;
import by.a1qa.task2_1.util.ConfigManager;
import by.a1qa.task2_1.wait.ConditionalWait;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    By policyRevisionLocator = By.xpath("//a[contains(@href,'/privacy_agreement/?snr=1_44_44_')]");
    By searchFieldLocator = By.id("store_nav_search_term");
    By searchButtonSubmitLocator = By.xpath("//a[@id='store_search_link']//img[contains(@src,'blank.gif')]");

    public MainPage() {
        super();
    }

    public MainPage navigateToMainPage() {
        (DriverSingleton.getInstance()).get(ConfigManager.getURL());
        return this;
    }

    public PrivacyPolicyPage openPrivacyPolicy() {
        ConditionalWait.waitToBeClickable(policyRevisionLocator);
        (DriverSingleton.getInstance()).findElement(policyRevisionLocator).click();
        switchToNewWindow();
        return new PrivacyPolicyPage();
    }

    public void switchToNewWindow() {
        for (String windowHandle : (DriverSingleton.getInstance()).getWindowHandles()) {
            (DriverSingleton.getInstance()).switchTo().window(windowHandle);
        }
    }

    public GameSearchPage searchGame(String gameTitle) {
        ConditionalWait.waitToBeClickable(searchFieldLocator);
        (DriverSingleton.getInstance()).findElement(searchFieldLocator).sendKeys(gameTitle);
        (DriverSingleton.getInstance()).findElement(searchButtonSubmitLocator).click();
        return new GameSearchPage();
    }
}