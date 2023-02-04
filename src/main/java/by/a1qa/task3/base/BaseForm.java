package by.a1qa.task3.base;

import by.a1qa.task3.util.CustomLogger;
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
        CustomLogger.info("getFormName()");
        return formName;
    }

    public boolean isPageOpened() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : isPageOpened()");
        return element.isDisplayed();
    }
}
