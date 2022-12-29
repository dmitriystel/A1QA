package by.a1qa.task2_1.util;

import by.a1qa.task2_1.driver.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;

public class JSUtil {
    private static JavascriptExecutor js;
    public static void pageScrollDown(){
        js = (JavascriptExecutor) DriverSingleton.getInstance();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}