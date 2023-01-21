package by.a1qa.task3.base;

import org.json.simple.parser.ParseException;
import java.io.IOException;

public abstract class BaseForm {
    private BaseElement element;
    private String formName;

    public BaseForm() {
    }
    public BaseForm(BaseElement element, String formName){
        this.element = element;
        this.formName = formName;
    }
    public String getFormName() {
        return formName;
    }
    public boolean isPageOpened() throws IOException, ParseException {
        return element.isDisplayed();
    }
}
