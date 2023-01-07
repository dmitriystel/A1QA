package by.a1qa.task3.util;

import by.a1qa.task3.driver.Driver;
import org.openqa.selenium.By;

public class FrameUtil {

    public static void switchToFrame(By frameLocator){
        CustomLogger.info("FrameUtil.switchToFrame(): " + frameLocator);
        Driver.getInstance().switchTo().frame(Driver.getInstance().findElement(frameLocator));
    }

    public static void leaveFrame(){
        CustomLogger.info("FrameUtil.leaveFrame()");
        Driver.getInstance().switchTo().defaultContent();
    }
}
