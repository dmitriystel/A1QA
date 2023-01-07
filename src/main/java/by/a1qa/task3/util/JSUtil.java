package by.a1qa.task3.util;

import by.a1qa.task3.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;

public class JSUtil {
    private static JavascriptExecutor js;

    public static void pageScrollDown(){
//        js = (JavascriptExecutor) Driver.getDriver();
        js = (JavascriptExecutor) Driver.getInstance();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
