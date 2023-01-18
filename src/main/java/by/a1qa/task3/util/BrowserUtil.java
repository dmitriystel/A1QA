package by.a1qa.task3.util;

import by.a1qa.task3.driver.DriverSingleton;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class BrowserUtil {

    public static void goToURL(String url) throws IOException, ParseException {
        CustomLogger.info("BrowserUtil.goToURL(): " + url);
        DriverSingleton.getDriver().navigate().to(url);
    }

//    public static void closeBrowser() throws IOException, ParseException {
//        CustomLogger.info("BrowserUtil.closeBrowser()");
//        DriverSingleton.getDriver().quit();
//    }

    public static void closeCurrentTab() throws IOException, ParseException {
        CustomLogger.info("BrowserUtil.closeCurrentTab()");
        DriverSingleton.getDriver().close();
    }

    public static String getCurrentTabHandle() throws IOException, ParseException {
        CustomLogger.info("BrowserUtil.getWindowHandle()");
        return DriverSingleton.getDriver().getWindowHandle();
    }

    public static int getTabCount() throws IOException, ParseException {
        return DriverSingleton.getDriver().getWindowHandles().size();
    }



//    public static boolean switchToOtherTab(String currentTabHandle){
//        if(DriverSingleton.getDriver().getWindowHandles().size() < 2){
//            CustomLogger.error("BrowserUtil.switchToNewTab() : false");
//            return false;
//        }
//        for (String windowHandle : DriverSingleton.getDriver().getWindowHandles()) {
//            if(!currentTabHandle.contentEquals(windowHandle)) {
//                CustomLogger.info("BrowserUtil.switchToNewTab() : true");
//                DriverSingleton.getDriver().switchTo().window(windowHandle);
//                break;
//            }
//        }
//        return true;
//    }



    public static void switchToOtherTab(String currentTabHandle) throws IOException, ParseException {
//        if(DriverSingleton.getDriver().getWindowHandles().size() < 2){
//            CustomLogger.error("BrowserUtil.switchToNewTab() : false");
//            return false;
//        }
        for (String windowHandle : DriverSingleton.getDriver().getWindowHandles()) {
            if(!currentTabHandle.contentEquals(windowHandle)) {
                CustomLogger.info("BrowserUtil.switchToNewTab() : true");
                DriverSingleton.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }








    public static void switchToTab(String tabHandle) throws IOException, ParseException {
        for (String windowHandle : DriverSingleton.getDriver().getWindowHandles()) {
            if(tabHandle.contentEquals(windowHandle)) {
                CustomLogger.info("BrowserUtil.switchToTab()");
                DriverSingleton.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
}
