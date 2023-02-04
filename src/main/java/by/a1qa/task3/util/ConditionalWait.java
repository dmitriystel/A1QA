package by.a1qa.task3.util;

import by.a1qa.task3.base.BaseElement;
import by.a1qa.task3.driver.DriverSingleton;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static by.a1qa.task3.util.ConfigManager.getWaitDurationInSeconds;

public class ConditionalWait {

    private static int seconds;

    static {
        seconds = getWaitDurationInSeconds();
    }

    private static Duration duration = Duration.ofSeconds(seconds);

    public static void waitToBeClickableByLocator(By locator) {
        CustomLogger.info("ConditionalWait.waitToBeClickableByLocator(By locator)");
        new WebDriverWait(DriverSingleton.getDriver(), duration).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitElementDisappears(BaseElement element){
        CustomLogger.info("ConditionalWait.waitElementDisappears(BaseElement element)");
        new WebDriverWait(DriverSingleton.getDriver(), duration)
                .until(ExpectedConditions.invisibilityOfElementLocated(element.getLocator()));
    }

    public static Alert waitUntilAlertIsPresent(){
        CustomLogger.info("waitUntilAlertIsPresent()");
        return new WebDriverWait(DriverSingleton.getDriver(), duration).until((ExpectedConditions.alertIsPresent()));
    }
}
