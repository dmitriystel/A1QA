package by.a1qa.task3.test;

import by.a1qa.task3.page.*;
import by.a1qa.task3.util.CustomLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest {

    @Test
    public void testIframe(){
        CustomLogger.info("Alerts test starts.");
        MainPage mainPage = new MainPage();
        mainPage.navigateToMainPage();
        CustomLogger.info("Step 1. Assert if the main page is open.");

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't open.");

        mainPage.scrollDown();
        mainPage.clickAlertsFrameWindowsBtn();
        AlertsFrameWindowsForm alertsFrameWindowsForm = new AlertsFrameWindowsForm();
        alertsFrameWindowsForm.scrollDown();
        alertsFrameWindowsForm.nestedFramesButtonClick();
        NestedFramesForm nestedFramesForm = new NestedFramesForm();
        CustomLogger.info("Step 2. Assert if page with Nested Frames form is open.");

        Assert.assertTrue(nestedFramesForm.isPageOpened(), "Page with Nested Frames form isn't open.");

        CustomLogger.info("Step 2. Assert if messages 'Parent frame' and 'Child Iframe' are present on the page");
        ParentFrameForm parentFramePage = new ParentFrameForm();
        parentFramePage.switchToThisFrame();

        Assert.assertTrue(parentFramePage.getParentFrameLabelText().equals("Parent frame"),
                "There is no messages 'Parent frame' present on the page");

        parentFramePage.switchToChildFrame();

        Assert.assertTrue(parentFramePage.getChildIframeLabelText().equals("Child Iframe"),
                "There is no messages 'Child Iframe' present on the page");

        parentFramePage.leaveChildFrame();
        nestedFramesForm.scrollDown();
        nestedFramesForm.framesButtonClick();
        FramesForm framesForm = new FramesForm();
        CustomLogger.info("Step 3.1. Assert if frames form is open");

        Assert.assertTrue(framesForm.isPageOpened(), "Frames form is not open!");

        CustomLogger.info("Step 3.2. Assert if message from upper frame equals to the message from lower frame");
        UpperFrameForm upperFramePage = new UpperFrameForm();
        upperFramePage.switchToThisFrame();
        String upperFrameMessage = upperFramePage.getUpperFrameLabelText();
        upperFramePage.leaveFrame();
        LowerFrameForm lowerFramePage = new LowerFrameForm();
        lowerFramePage.switchToThisFrame();
        String lowerFrameMessage = lowerFramePage.getLowerFrameLabelText();
        lowerFramePage.leaveFrame();

        Assert.assertEquals(upperFrameMessage, lowerFrameMessage,
                "Message from upper frame is not equal to the message from lower frame!");

        CustomLogger.info("End of an Iframe test");
    }
}
