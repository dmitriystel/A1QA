package by.a1qa.task3.test;

import by.a1qa.task3.page.AlertsForm;
import by.a1qa.task3.page.AlertsFrameWindowsForm;
import by.a1qa.task3.page.MainPage;
import by.a1qa.task3.util.CustomLogger;
import by.a1qa.task3.util.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest{

    @Test
    public void testAlerts(){
        CustomLogger.info("Alerts test starts.");
        MainPage mainPage = new MainPage();
        mainPage.navigateToMainPage();
        CustomLogger.info("Step 1. Assert if the main page is open.");

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't open.");

        mainPage.scrollDown();
        mainPage.clickAlertsFrameWindowsBtn();
        AlertsFrameWindowsForm alertsFrameWindowsForm = new AlertsFrameWindowsForm();
        alertsFrameWindowsForm.scrollDown();
        alertsFrameWindowsForm.openAlertsForm();
        CustomLogger.info("Step 2. Assert if the alerts form has appeared.");
        AlertsForm alertsForm = new AlertsForm();

        Assert.assertTrue(alertsForm.isPageOpened(), "Alerts form hasn't appeared on page.");

        alertsForm.openAlertYouClickedBtn();
        CustomLogger.info("Step 3. Assert if alert with text 'You clicked a button' is open.");

        Assert.assertEquals(alertsForm.getAlertText(), "You clicked a button",
                "Alert with text 'You clicked a button' isn't open.");

        alertsForm.closeAlert();
        CustomLogger.info("Step 4. Assert if alert is closed.");

        Assert.assertFalse(alertsForm.isAlertPresent(), "Alert isn't closed");

        alertsForm.openAlertDoYouConfirmActionBtn();
        CustomLogger.info("Step 5. Assert if alert with text 'Do you confirm actions?' is open.");

        Assert.assertEquals(alertsForm.getAlertText(), "Do you confirm action?",
                "Alert with text 'Do you confirm action?' isn't open.");

        alertsForm.closeAlert();
        CustomLogger.info("Step 6.1 Assert if alert is closed.");

        Assert.assertFalse(alertsForm.isAlertPresent(), "Alert isn't closed");

        CustomLogger.info("Step 6.2 Assert if 'You selected Ok' appeared on the page.");

        Assert.assertEquals(alertsForm.getConfirmBoxResultLabelText(), "You selected Ok",
                "Alert with text 'You selected Ok' did not appear.");

        alertsForm.openAlertPleaseEnterYourNameBtn();
        CustomLogger.info("Step 7. Assert if alert with 'Please enter your name' has appeared on the page.");

        Assert.assertEquals(alertsForm.getAlertText(), "Please enter your name",
                "Alert with text 'Please enter your name' did not appear.");
        String randomString = RandomStringGenerator.getRandomString();
        alertsForm
                .alertSendText(randomString)
                .closeAlert();
        CustomLogger.info("Step 8. Assert if alert is closed.");

        Assert.assertFalse(alertsForm.isAlertPresent(), "Alert is not closed");

        CustomLogger.info("Step 9. Assert if the appeared text equals to the one you entered before.");

        Assert.assertTrue(alertsForm.getPromptBoxResultLabelText().contains(randomString),
                "Appeared text not equal to the one you entered before!");

        CustomLogger.info("Alerts test is finished.");
    }
}
