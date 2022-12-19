package by.a1qa.task2_1.page;

import by.a1qa.task2_1.util.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {
    private WebDriver driver;
    private final String GAME_TITLE = "Dota 2";

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href=\"https://store.steampowered.com/privacy_agreement/?snr=1_44_44_\"]")
    private WebElement privacyPolicy;

    public MainPage navigateToMainPage(){
        driver.get(ConfigManager.getURL());
        return this;
    }

    public PrivacyPolicyPage scrollAndOpenPrivacyPolicy(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
        new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getWaitDurationInSeconds()))
                .until(ExpectedConditions.elementToBeClickable(privacyPolicy));
        privacyPolicy.click();
        switchToNewWindow();
        return new PrivacyPolicyPage(driver);
    }

    public void switchToNewWindow(){
        String windowHandleBefore = driver.getWindowHandle(); // Store the current window handle
        for(String windowHandle : driver.getWindowHandles()){ // Switch to new window opened
            driver.switchTo().window(windowHandle);
        }
    }
}
