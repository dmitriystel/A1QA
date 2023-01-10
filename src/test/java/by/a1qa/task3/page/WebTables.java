package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.driver.DriverSingleton;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.element.TextBox;
import by.a1qa.task3.model.User;
import by.a1qa.task3.util.ConditionalWait;
import by.a1qa.task3.util.CustomLogger;
import org.openqa.selenium.By;

public class WebTables extends BaseForm {

    private static By webTablesLabelLocator = By.xpath("//div[@class='main-header' and contains(text(), 'Web Tables')]");
    private static Label webTablesLabel = new Label(webTablesLabelLocator, "webTablesLabel");

    private By addNewRecordButtonLocator = By.id("addNewRecordButton");
    private Button addNewRecordBtn = new Button(addNewRecordButtonLocator, "add new record button");

    private By registrationFormLabelLocator = By.xpath("//div[contains(@class, 'modal-dialog')]");
    private Label registrationFormLabel = new Label(registrationFormLabelLocator, "registration form label");

    private By firstNameInputLocator = By.id("firstName");
    private TextBox firstNameTextBox = new TextBox(firstNameInputLocator, "First name input field");

    private By lastNameInputLocator = By.id("lastName");
    private TextBox lastNameTextBox = new TextBox(lastNameInputLocator, "Last name input field");

    private By userEmailInputLocator = By.id("userEmail");
    private TextBox userEmailTextBox = new TextBox(userEmailInputLocator, "User email input field");

    private By ageInputLocator = By.id("age");
    private TextBox ageTextBox = new TextBox(ageInputLocator, "Age input field");

    private By salaryInputLocator = By.id("salary");
    private TextBox salaryTextBox = new TextBox(salaryInputLocator, "Salary input field");

    private By departmentInputLocator = By.id("department");
    private TextBox departmentTextBox = new TextBox(departmentInputLocator, "Department input field");

    private By submitButtonLocator = By.id("submit");
    private Button submitBtn = new Button(submitButtonLocator, "Submit button");

    private String userDataDynamicLocator = "//div[contains(text(),'%s')]";
    private String userDeleteButtonDynamicLocator = userDataDynamicLocator
            + "//parent::div//span[contains(@id, 'delete-record')]";

    public WebTables() {
        super(webTablesLabel, "webTablesLabel");
    }

    public WebTables clickAddNewRecordBtn(){
        CustomLogger.info(this.getFormName() + " : clickAddNewRecordBtn()");
        addNewRecordBtn.click();
        return this;
    }

    public boolean isRegistrationFormLabelOpen(){
        CustomLogger.info(this.getFormName() + " : isRegistrationFormLabelOpen()");
        return  registrationFormLabel.isDisplayed();
    }

    public WebTables fillInRegistrationForm(User user){
        CustomLogger.info(this.getFormName() + " : fillInRegistrationForm(User user)");
        firstNameTextBox.sendText(user.getFirstName());
        lastNameTextBox.sendText(user.getLastName());
        userEmailTextBox.sendText(user.getEmail());
        ageTextBox.sendText(user.getAge());
        salaryTextBox.sendText(user.getSalary());
        departmentTextBox.sendText(user.getDepartment());
        return this;
    }

    public WebTables clickSubmitBtn(){
        CustomLogger.info(this.getFormName() + " : clickSubmitBtn()");
        submitBtn.click();
        ConditionalWait.waitElementDisappears(registrationFormLabel);
        return this;
    }

    public boolean isUserDataLabelOpen(String userData) {
        CustomLogger.info(this.getFormName() + " : isUserDataLabelOpen(String userData)");
        return new Label(By.xpath(String.format(userDataDynamicLocator, userData)),
                "User data dynamic label : " + userData).isDisplayed();
    }

    public int getNumOfUserRecords(){
        CustomLogger.info(this.getFormName() + " : getNumOfUserRecords()");
        return DriverSingleton.getDriver().findElements(By.xpath(String.format(userDataDynamicLocator, "@"))).size();
    }

    public void clickUserDeleteBtn(String userData){
        Button userDeleteBtn = new Button(By.xpath(String.format(userDeleteButtonDynamicLocator, userData)),
                "specific user delete button : " + userData);
        CustomLogger.info(this.getFormName() + " : clickUserDeleteBtn(String userData)");
        userDeleteBtn.click();
        ConditionalWait.waitElementDisappears(userDeleteBtn);
    }
}
