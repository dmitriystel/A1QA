package by.a1qa.task3.util;

import by.a1qa.task3.driver.DriverSingleton;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;

public class JSUtil {

    private static JavascriptExecutor js;

    public static void pageScrollDown() throws IOException, ParseException {
        js = (JavascriptExecutor) DriverSingleton.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
