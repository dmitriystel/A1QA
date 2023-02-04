package by.a1qa.task3.util;

import by.a1qa.task3.driver.DriverSingleton;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class JSUtil {

    public static void pageScrollDown(By locator) {
        CustomLogger.info("JSUtil.pageScrollDown");
        WebElement element = null;
        try {
            element = DriverSingleton.getDriver().findElement(locator);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            ((JavascriptExecutor) DriverSingleton.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
