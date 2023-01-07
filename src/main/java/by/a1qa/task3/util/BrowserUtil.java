package by.a1qa.task3.util;

import by.a1qa.task3.driver.Driver;

public class BrowserUtil {

    public static void goToURL(String url){
        CustomLogger.info("BrowserUtil.goToURL(): " + url);
//        Driver.getDriver().navigate().to(url);
        Driver.getInstance().navigate().to(url);
    }

    public static void closeBrowser(){
        CustomLogger.info("BrowserUtil.closeBrowser()");
//        Driver.getDriver().quit();
        Driver.getInstance().quit();
    }

    public static void closeCurrentTab(){
        CustomLogger.info("BrowserUtil.closeCurrentTab()");
//        Driver.getDriver().close();
        Driver.getInstance().close();
    }

    public static String getCurrentTabHandle(){
        CustomLogger.info("BrowserUtil.getWindowHandle()");
//        return Driver.getDriver().getWindowHandle();
        return Driver.getInstance().getWindowHandle();

    }

    public static int getTabCount(){
//        return Driver.getDriver().getWindowHandles().size();
        return Driver.getInstance().getWindowHandles().size();
    }

    public static boolean switchToOtherTab(String currentTabHandle){
        if(Driver.getInstance().getWindowHandles().size() < 2){
            CustomLogger.error("BrowserUtil.switchToNewTab() : false");
            return false;
        }
        for (String windowHandle : Driver.getInstance().getWindowHandles()) {
            if(!currentTabHandle.contentEquals(windowHandle)) {
                CustomLogger.info("BrowserUtil.switchToNewTab() : true");
                Driver.getInstance().switchTo().window(windowHandle);
                break;
            }
        }
        return true;
    }

    public static void switchToTab(String tabHandle){
        for (String windowHandle : Driver.getInstance().getWindowHandles()) {
            if(tabHandle.contentEquals(windowHandle)) {
                CustomLogger.info("BrowserUtil.switchToTab()");
                Driver.getInstance().switchTo().window(windowHandle);
                break;
            }
        }
    }
}
