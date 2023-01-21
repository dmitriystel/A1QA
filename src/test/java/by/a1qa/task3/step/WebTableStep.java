package by.a1qa.task3.step;

import by.a1qa.task3.model.User;
import by.a1qa.task3.page.WebTable;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class WebTableStep extends WebTable {
    public void fillInRegForm_FN(User user) throws IOException, ParseException {
        inputFirstName(user);
    }
    public void fillInRegForm_FNLN(User user) throws IOException, ParseException {
        inputFirstName(user);
        inputLastName(user);
    }
    public void fillInRegForm_FNLN_Email(User user) throws IOException, ParseException {
        inputFirstName(user);
        inputLastName(user);
        inputUserEmail(user);
    }
    public void fillInRegForm_FNLN_Email_Age(User user) throws IOException, ParseException {
        inputFirstName(user);
        inputLastName(user);
        inputUserEmail(user);
        inputAge(user);
    }
    public void fillIngRegForm_FNLN_Email_Age_Salary(User user) throws IOException, ParseException {
        inputFirstName(user);
        inputLastName(user);
        inputUserEmail(user);
        inputAge(user);
        inputSalary(user);
    }
    public void fillInAllRegForm(User user) throws IOException, ParseException {
        inputFirstName(user);
        inputLastName(user);
        inputUserEmail(user);
        inputAge(user);
        inputSalary(user);
        inputDepartment(user);
    }
}
