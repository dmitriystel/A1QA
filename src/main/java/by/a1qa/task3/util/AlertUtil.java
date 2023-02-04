package by.a1qa.task3.util;

import by.a1qa.task3.driver.DriverSingleton;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;

public class AlertUtil {

    public static boolean isDialogPresent() throws IOException, ParseException {
        CustomLogger.info("AlertUtil.isDialogPresent()");
        return (ExpectedConditions.alertIsPresent().apply(DriverSingleton.getDriver())) != null;
    }

    public static void acceptAlert() throws IOException, ParseException {
        CustomLogger.info("AlertUtil.acceptAlert()");
        Alert alert = ConditionalWait.waitUntilAlertIsPresent();
        alert.accept();
    }

    public static String getText() throws IOException, ParseException {
        CustomLogger.info("AlertUtil.getText()");
        Alert alert = ConditionalWait.waitUntilAlertIsPresent();
        return alert.getText();
    }

    public static void sendKeys(String keys) throws IOException, ParseException {
        CustomLogger.info("AlertUtil.sendKeys() : " + keys);
        Alert alert = ConditionalWait.waitUntilAlertIsPresent();
        alert.sendKeys(keys);
    }
}
