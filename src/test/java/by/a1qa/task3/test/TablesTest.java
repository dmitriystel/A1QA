package by.a1qa.task3.test;

import by.a1qa.task3.model.User;
import by.a1qa.task3.page.ElementsForm;
import by.a1qa.task3.page.MainPage;
import by.a1qa.task3.page.WebTable;
import by.a1qa.task3.step.WebTableStep;
import by.a1qa.task3.util.BrowserUtil;
import by.a1qa.task3.util.ConfigManager;
import by.a1qa.task3.util.CustomLogger;
import by.a1qa.task3.util.UserParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class TablesTest extends BaseTest{
    @DataProvider(name = "userProvider")
    public Object[][] dataProviderMethod() throws IOException {
        List<User> users = UserParser.parseUserFromFileToList();
        Object [][] usersObj = new Object[users.size()][1];
        for (int i = 0; i < users.size(); i++) {
            usersObj[i][0] = users.get(i);
        }
        return usersObj;
    }
    @Test(dataProvider = "userProvider")
    public void testTables(Object usersObj) throws IOException, ParseException {
        CustomLogger.info("Tables test starts.");
        MainPage mainPage = new MainPage();
        BrowserUtil.goToURL(ConfigManager.getURL());
        CustomLogger.info("Step 1. Assert if the main page is open.");

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't open.");

        mainPage.clickElementsBtn();
        ElementsForm elementsForm = new ElementsForm();
        elementsForm.clickWebTablesBtn();
        WebTable webTable = new WebTable();
        CustomLogger.info("Step 2. Assert if the web tables form is open.");

        Assert.assertTrue(webTable.isPageOpened(), "The web tables form is not open!");

        webTable.clickAddNewRecordBtn();
        CustomLogger.info("Step 3. Assert if the registration form has appeared on the page.");

        Assert.assertTrue(webTable.isRegFormLabelOpen(),
                "The registration form has not appeared on the page!");

        WebTableStep webTableStep = new WebTableStep();
        webTableStep.fillInAllRegForm((User)usersObj);
        webTable.clickSubmitBtn();
        CustomLogger.info("Step 4. Assert if the registration form has closed.");

        Assert.assertFalse(webTable.isRegFormLabelOpen(),
                "The registration form has not closed!");

        CustomLogger.info("Step 5. Assert if data of user has appeared in a table.");

        Assert.assertTrue(webTable.isUserDataLabelOpen(((User) usersObj).getEmail()),
                "Data of user has not appeared in a table!");

        int numberOfRecordsBeforeDelete = webTable.getNumOfUserRecords();
        webTable.clickUserDeleteBtn(((User) usersObj).getEmail());
        CustomLogger.info("Step 6. Assert if number of records in table has changed.");
        int numberOfRecordsAfterDelete = webTable.getNumOfUserRecords();

        Assert.assertTrue(numberOfRecordsBeforeDelete != numberOfRecordsAfterDelete,
                "Number of records in table has not changed!");

        CustomLogger.info("Step 7. Assert if data of user has been deleted from the table.");

        Assert.assertFalse(webTable.isUserDataLabelOpen(((User) usersObj).getEmail()),
                "Data of user has not been deleted from the table!");

        CustomLogger.info("End of a tables test");
    }
}
