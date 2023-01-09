package by.a1qa.task3.util;

import by.a1qa.task3.driver.DriverSingleton;
import org.openqa.selenium.By;

public class FrameUtil {

    public static void switchToFrame(By frameLocator){
        CustomLogger.info("FrameUtil.switchToFrame(): " + frameLocator);
        DriverSingleton.getDriver().switchTo().frame(DriverSingleton.getDriver().findElement(frameLocator));
    }
    public static void leaveFrame(){
        CustomLogger.info("FrameUtil.leaveFrame()");
        DriverSingleton.getDriver().switchTo().defaultContent();
    }
}
