package by.a1qa.task3.util;

import by.a1qa.task3.driver.DriverSingleton;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class JSUtil {

    private static JavascriptExecutor js;

    public static void pageScrollDown(By locator) throws IOException, ParseException {
//        js = (JavascriptExecutor) DriverSingleton.getDriver();
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement element = DriverSingleton.getDriver().findElement(locator);
        ((JavascriptExecutor) DriverSingleton.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

    }
}
