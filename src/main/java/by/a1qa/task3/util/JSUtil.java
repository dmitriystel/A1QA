package by.a1qa.task3.util;

import by.a1qa.task3.driver.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;

public class JSUtil {

    private static JavascriptExecutor js;

    public static void pageScrollDown(){
        js = (JavascriptExecutor) DriverSingleton.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
