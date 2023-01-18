package by.a1qa.task3.util;

import by.a1qa.task3.driver.DriverSingleton;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.IOException;

public class FrameUtil {

    public static void switchToFrame(By frameLocator) throws IOException, ParseException {
        CustomLogger.info("FrameUtil.switchToFrame(): " + frameLocator);
        DriverSingleton.getDriver().switchTo().frame(DriverSingleton.getDriver().findElement(frameLocator));
    }
    public static void leaveFrame() throws IOException, ParseException {
        CustomLogger.info("FrameUtil.leaveFrame()");
        DriverSingleton.getDriver().switchTo().defaultContent();
    }
}
