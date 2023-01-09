package by.a1qa.task3.util;

import by.a1qa.task3.driver.DriverSingleton;

public class BrowserUtil {

    public static void goToURL(String url){
        CustomLogger.info("BrowserUtil.goToURL(): " + url);
        DriverSingleton.getDriver().navigate().to(url);
    }

    public static void closeBrowser(){
        CustomLogger.info("BrowserUtil.closeBrowser()");
        DriverSingleton.getDriver().quit();
    }

    public static void closeCurrentTab(){
        CustomLogger.info("BrowserUtil.closeCurrentTab()");
        DriverSingleton.getDriver().close();
    }

    public static String getCurrentTabHandle(){
        CustomLogger.info("BrowserUtil.getWindowHandle()");
        return DriverSingleton.getDriver().getWindowHandle();
    }

    public static int getTabCount(){
        return DriverSingleton.getDriver().getWindowHandles().size();
    }

    public static boolean switchToOtherTab(String currentTabHandle){
        if(DriverSingleton.getDriver().getWindowHandles().size() < 2){
            CustomLogger.error("BrowserUtil.switchToNewTab() : false");
            return false;
        }
        for (String windowHandle : DriverSingleton.getDriver().getWindowHandles()) {
            if(!currentTabHandle.contentEquals(windowHandle)) {
                CustomLogger.info("BrowserUtil.switchToNewTab() : true");
                DriverSingleton.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return true;
    }

    public static void switchToTab(String tabHandle){
        for (String windowHandle : DriverSingleton.getDriver().getWindowHandles()) {
            if(tabHandle.contentEquals(windowHandle)) {
                CustomLogger.info("BrowserUtil.switchToTab()");
                DriverSingleton.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
}
