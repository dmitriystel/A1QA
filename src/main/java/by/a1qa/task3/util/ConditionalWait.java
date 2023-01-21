package by.a1qa.task3.util;

import by.a1qa.task3.base.BaseElement;
import by.a1qa.task3.driver.DriverSingleton;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import static by.a1qa.task3.util.ConfigManager.getWaitDurationInSeconds;

public class ConditionalWait {
    private static int seconds;

    static {
        try {
            seconds = getWaitDurationInSeconds();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private static Duration duration = Duration.ofSeconds(seconds);

    public static void waitToBeClickableByLocator(By locator) throws IOException, ParseException {
        new WebDriverWait(DriverSingleton.getDriver(), duration).until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void waitElementDisappears(BaseElement element) throws IOException, ParseException {
        new WebDriverWait(DriverSingleton.getDriver(), duration)
                .until(ExpectedConditions.invisibilityOfElementLocated(element.getLocator()));
    }
    public static Alert waitUntilAlertIsPresent() throws IOException, ParseException {
        return new WebDriverWait(DriverSingleton.getDriver(), duration).until((ExpectedConditions.alertIsPresent()));
    }
}
