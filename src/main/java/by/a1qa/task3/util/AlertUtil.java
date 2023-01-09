package by.a1qa.task3.util;

import by.a1qa.task3.driver.DriverSingleton;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertUtil {

    public static boolean isDialogPresent() {
        CustomLogger.info("AlertUtil.isDialogPresent()");
        return (ExpectedConditions.alertIsPresent().apply(DriverSingleton.getDriver())) != null;
    }

    public static void acceptAlert(){
        CustomLogger.info("AlertUtil.acceptAlert()");
        Alert alert = ConditionalWait.waitUntilAlertIsPresent();
        alert.accept();
    }

    public static String getText() {
        CustomLogger.info("AlertUtil.getText()");
        Alert alert = ConditionalWait.waitUntilAlertIsPresent();
        return alert.getText();
    }

    public static void sendKeys(String keys) {
        CustomLogger.info("AlertUtil.sendKeys() : " + keys);
        Alert alert = ConditionalWait.waitUntilAlertIsPresent();
        alert.sendKeys(keys);
    }
}
