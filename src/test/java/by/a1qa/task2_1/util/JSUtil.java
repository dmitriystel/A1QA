package by.a1qa.task2_1.util;

import by.a1qa.task2_1.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class JSUtil {

    private static JavascriptExecutor js;

    public static void pageScrollDown(By locator){

        ((JavascriptExecutor) (DriverSingleton.getInstance())).executeScript("arguments[0].scrollIntoView(true);",
                (DriverSingleton.getInstance()).findElement(locator));

    }

}