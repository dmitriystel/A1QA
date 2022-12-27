package by.a1qa.task2_1.page;

import by.a1qa.task2_1.driver.DriverSingleton;
import by.a1qa.task2_1.util.ConfigManager;
import by.a1qa.task2_1.util.JSUtil;
import by.a1qa.task2_1.wait.ConditionalWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private WebDriver driver;

    public MainPage() {
        super();
    }

    By policyRevisionLocator = By.xpath("//a[contains(@href,'/privacy_agreement/?snr=1_44_44_')]");
    By searchFieldLocator = By.id("store_nav_search_term");
    By searchButtonSubmitLocator = By.xpath("//a[@id='store_search_link']//img[contains(@src,'blank.gif')]");

    public MainPage navigateToMainPage() {
        (DriverSingleton.getInstance()).get(ConfigManager.getURL());
        return this;
    }




    public PrivacyPolicyPage openPrivacyPolicy() {
        JSUtil.pageScrollDown(policyRevisionLocator);
//        ((JavascriptExecutor) (DriverSingleton.getInstance())).executeScript("arguments[0].scrollIntoView(true);",
//                (DriverSingleton.getInstance()).findElement(policyRevisionLocator));
        ConditionalWait.waitToBeClickable(policyRevisionLocator);
        (DriverSingleton.getInstance()).findElement(policyRevisionLocator).click();
        switchToNewWindow();
        return new PrivacyPolicyPage();
    }

    public void switchToNewWindow() {
        String windowHandleBefore = (DriverSingleton.getInstance()).getWindowHandle(); // Store the current window handle
        for (String windowHandle : (DriverSingleton.getInstance()).getWindowHandles()) { // Switch to new window opened
            (DriverSingleton.getInstance()).switchTo().window(windowHandle);
        }
    }

    public GameSearchPage searchGame(String gameTitle) {
        ConditionalWait.waitToBeClickable(searchFieldLocator);
        (DriverSingleton.getInstance()).findElement(searchFieldLocator).sendKeys(gameTitle);
        (DriverSingleton.getInstance()).findElement(searchButtonSubmitLocator).click();
        return new GameSearchPage();
    }

//    public GameSearchPage secondSearchGame(String someGame){
//        ConditionalWait.waitToBeClickable(searchFieldLocator);
//        (DriverSingleton.getInstance()).findElement(searchFieldLocator).sendKeys(someGame);
////        searchField.sendKeys(someGame);
//        (DriverSingleton.getInstance()).findElement(searchButtonSubmitLocator).click();
//
////        searchButtonSubmit.click();
//        return new GameSearchPage();
//    }
}