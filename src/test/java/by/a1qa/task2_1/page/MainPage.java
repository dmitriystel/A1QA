package by.a1qa.task2_1.page;

import by.a1qa.task2_1.util.ConfigManager;
import by.a1qa.task2_1.wait.ConditionalWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'/privacy_agreement/?snr=1_44_44_')]")
    private WebElement privacyPolicy;

    @FindBy(id = "store_nav_search_term")
    private WebElement searchField;

    @FindBy(xpath = "//a[@id='store_search_link']//img[contains(@src,'blank.gif')]")
    private WebElement searchButtonSubmit;

    public MainPage navigateToMainPage() {
        driver.get(ConfigManager.getURL());
        return this;
    }

    public PrivacyPolicyPage scrollAndOpenPrivacyPolicy() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
        ConditionalWait.waitToBeClickable(privacyPolicy);
        privacyPolicy.click();
        switchToNewWindow();
        return new PrivacyPolicyPage(driver);
    }

    public void switchToNewWindow() {
        String windowHandleBefore = driver.getWindowHandle(); // Store the current window handle
        for (String windowHandle : driver.getWindowHandles()) { // Switch to new window opened
            driver.switchTo().window(windowHandle);
        }
    }

    public GameSearchPage searchDota2() {
        ConditionalWait.waitToBeClickable(searchField);
        searchField.sendKeys(ConfigManager.getGameTitle());
        searchButtonSubmit.click();
        return new GameSearchPage(driver);
    }

    public GameSearchPage secondSearchGame(String someGame){
        ConditionalWait.waitToBeClickable(searchField);
        searchField.sendKeys(someGame);
        searchButtonSubmit.click();
        return new GameSearchPage(driver);
    }
}