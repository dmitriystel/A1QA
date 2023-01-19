package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.driver.DriverSingleton;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.element.TextBox;
import by.a1qa.task3.model.User;
import by.a1qa.task3.util.ConditionalWait;
import by.a1qa.task3.util.CustomLogger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import java.io.IOException;

public class WebTable extends BaseForm {

    private static Label webTablesLabel
            = new Label(By.xpath("//div[contains(@class, 'main-header') and contains(text(), 'Web Tables')]"), "webTablesLabel");
    private Button addNewRecordBtn = new Button(By.id("addNewRecordButton"), "add new record button");
    private Label registrationFormLabel = new Label(By.xpath("//div[contains(@class, 'modal-dialog')]"), "registration form label");
    private TextBox firstNameTextBox = new TextBox(By.id("firstName"), "First name input field");
    private TextBox lastNameTextBox = new TextBox(By.id("lastName"), "Last name input field");
    private TextBox userEmailTextBox = new TextBox(By.id("userEmail"), "User email input field");
    private TextBox ageTextBox = new TextBox(By.id("age"), "Age input field");
    private TextBox salaryTextBox = new TextBox(By.id("salary"), "Salary input field");
    private TextBox departmentTextBox = new TextBox(By.id("department"), "Department input field");
    private Button submitBtn = new Button(By.id("submit"), "Submit button");
    private String userDataDynamicLocator = "//div[contains(text(),'%s')]";
    private String userDeleteButtonDynamicLocator = userDataDynamicLocator
            + "//parent::div//span[contains(@id, 'delete-record')]";

    public WebTable() {
        super(webTablesLabel, "webTablesLabel");
    }

    public WebTable clickAddNewRecordBtn() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : clickAddNewRecordBtn()");
        addNewRecordBtn.click();
        return this;
    }

    public boolean isRegistrationFormLabelOpen() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : isRegistrationFormLabelOpen()");
        return  registrationFormLabel.isDisplayed();
    }

    public void inputFirstName(User user) throws IOException, ParseException {
        firstNameTextBox.sendText(user.getFirstName());
    }
    public void inputLastName(User user) throws IOException, ParseException {
        lastNameTextBox.sendText(user.getLastName());
    }
    public void inputUserEmail(User user) throws IOException, ParseException {
        userEmailTextBox.sendText(user.getEmail());
    }
    public void inputAge(User user) throws IOException, ParseException {
        ageTextBox.sendText(user.getAge());
    }
    public void inputSalary(User user) throws IOException, ParseException {
        salaryTextBox.sendText(user.getSalary());
    }

    public void inputDepartment(User user) throws IOException, ParseException {
        departmentTextBox.sendText(user.getDepartment());
    }

    public WebTable clickSubmitBtn() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : clickSubmitBtn()");
        submitBtn.click();
        ConditionalWait.waitElementDisappears(registrationFormLabel);
        return this;
    }

    public boolean isUserDataLabelOpen(String userData) throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : isUserDataLabelOpen(String userData)");
        return new Label(By.xpath(String.format(userDataDynamicLocator, userData)),
                "User data dynamic label : " + userData).isDisplayed();
    }

    public int getNumOfUserRecords() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : getNumOfUserRecords()");
        return DriverSingleton.getDriver().findElements(By.xpath(String.format(userDataDynamicLocator, "@"))).size();
    }

    public void clickUserDeleteBtn(String userData) throws IOException, ParseException {
        Button userDeleteBtn = new Button(By.xpath(String.format(userDeleteButtonDynamicLocator, userData)),
                "specific user delete button : " + userData);
        CustomLogger.info(this.getFormName() + " : clickUserDeleteBtn(String userData)");
        userDeleteBtn.click();
        ConditionalWait.waitElementDisappears(userDeleteBtn);
    }
}
