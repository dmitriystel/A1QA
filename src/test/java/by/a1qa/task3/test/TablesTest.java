package by.a1qa.task3.test;

import by.a1qa.task3.model.User;
import by.a1qa.task3.page.ElementsForm;
import by.a1qa.task3.page.MainPage;
import by.a1qa.task3.page.WebTables;
import by.a1qa.task3.util.CustomLogger;
import by.a1qa.task3.util.UserParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TablesTest extends BaseTest{

    @DataProvider(name = "userProvider")
    public Object[][] dataProviderMethod() {
        final String userListPath = "src/test/resources/testData/users.json";
        List<User> users = UserParser.parseUserFromFileToList(userListPath);
        User firstUser = users.get(0);
        User secondUser = users.get(1);
        return new Object[][]{{firstUser}, {secondUser}};
    }

    @Test(dataProvider = "userProvider")
    public void testTables(User user){
        CustomLogger.info("Tables test starts.");
        MainPage mainPage = new MainPage();
        mainPage.navigateToMainPage();
        CustomLogger.info("Step 1. Assert if the main page is open.");

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't open.");

        mainPage.scrollDown();
        mainPage.clickElementsBtn();
        ElementsForm elementsForm = new ElementsForm();
        elementsForm.clickWebTablesBtn();
        WebTables webTables = new WebTables();
        CustomLogger.info("Step 2. Assert if the web tables form is open.");

        Assert.assertTrue(webTables.isPageOpened(), "The web tables form is not open!");

        webTables.clickAddNewRecordBtn();
        CustomLogger.info("Step 3. Assert if the registration form has appeared on the page.");

        Assert.assertTrue(webTables.isRegistrationFormLabelOpen(),
                "The registration form has not appeared on the page!");

        webTables
                .fillInRegistrationForm(user)
                .clickSubmitBtn();
        CustomLogger.info("Step 4. Assert if the registration form has closed.");

        Assert.assertFalse(webTables.isRegistrationFormLabelOpen(),
                "The registration form has not closed!");

        CustomLogger.info("Step 5. Assert if data of user has appeared in a table.");

        Assert.assertTrue(webTables.isUserDataLabelOpen(user.getEmail()),
                "Data of user has not appeared in a table!");

        int numberOfRecordsBeforeDelete = webTables.getNumOfUserRecords();
        webTables.clickUserDeleteBtn(user.getEmail());
        CustomLogger.info("Step 6. Assert if number of records in table has changed.");
        int numberOfRecordsAfterDelete = webTables.getNumOfUserRecords();

        Assert.assertTrue(numberOfRecordsBeforeDelete != numberOfRecordsAfterDelete,
                "Number of records in table has not changed!");

        CustomLogger.info("Step 7. Assert if data of user has been deleted from the table.");

        Assert.assertFalse(webTables.isUserDataLabelOpen(user.getEmail()),
                "Data of user has not been deleted from the table!");

        CustomLogger.info("End of a tables test");
    }
}
