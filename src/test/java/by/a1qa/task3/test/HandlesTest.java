package by.a1qa.task3.test;

import by.a1qa.task3.page.*;
import by.a1qa.task3.util.BrowserUtil;
import by.a1qa.task3.util.ConfigManager;
import by.a1qa.task3.util.CustomLogger;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HandlesTest extends BaseTest{

    @Test
    public void testHandles() throws IOException, ParseException {
        CustomLogger.info("Handles test starts.");
        MainPage mainPage = new MainPage();
        BrowserUtil.goToURL(ConfigManager.getURL());
        CustomLogger.info("Step 1. Assert if the main page is open.");

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't open.");

        mainPage.clickAlertsFrameWindowsBtn();
        AlertsFrameWindowsForm alertsFrameWindowsForm = new AlertsFrameWindowsForm();
        alertsFrameWindowsForm.browserWindowsButtonClick();
        BrowserWindowsForm browserWindowsForm = new BrowserWindowsForm();
        CustomLogger.info("Step 2. Page with Browser Windows form is open.");

        Assert.assertTrue(browserWindowsForm.isPageOpened(),
                "Page with Browser Windows form is not open!");

        int tabCountBefore = BrowserUtil.getTabCount();
        String initialTab = BrowserUtil.getCurrentTabHandle();
        browserWindowsForm.newTabBtnClick();
        int tabCountAfter = BrowserUtil.getTabCount();
        BrowserUtil.switchToOtherTab(initialTab);
        SampleForm sampleForm = new SampleForm();
        CustomLogger.info("Step 3. New tab with sample page is open.");

        Assert.assertTrue(tabCountBefore == tabCountAfter - 1
                        && sampleForm.getPageLabelText().equals("This is a sample page"),
                "New tab with sample page is not open.");

        BrowserUtil.closeCurrentTab();
        BrowserUtil.switchToTab(initialTab);
        CustomLogger.info("Step 4. Page with Browser Windows form is open.");

        Assert.assertTrue(browserWindowsForm.isPageOpened(),
                "Page with Browser Windows form is not open!");

//        browserWindowsForm.scrollDown();
        browserWindowsForm
                .elementsButtonClick()
                .linksButtonClick();
        LinksForm linksForm = new LinksForm();
        CustomLogger.info("Step 5. Page with Links form is open.");

        Assert.assertTrue(linksForm.isPageOpened(), "Page with Links form is not open!");

        initialTab = BrowserUtil.getCurrentTabHandle();
        tabCountBefore = BrowserUtil.getTabCount();
        linksForm.clickHomeBtn();
        CustomLogger.info("Step 6. New tab with main page is open.");
        BrowserUtil.switchToOtherTab(initialTab);
        tabCountAfter = BrowserUtil.getTabCount();

        Assert.assertTrue( tabCountBefore == tabCountAfter -1 && mainPage.isPageOpened(),
                "New tab with main page is not open!");

        BrowserUtil.switchToTab(initialTab);
        CustomLogger.info("Step 7. Page with Links form is open.");

        Assert.assertTrue(linksForm.isPageOpened(), "Page with Links form is not open!");

        CustomLogger.info("End of a handles test");
    }
}
