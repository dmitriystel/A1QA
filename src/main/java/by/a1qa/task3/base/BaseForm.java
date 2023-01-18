package by.a1qa.task3.base;

import by.a1qa.task3.util.JSUtil;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public abstract class BaseForm {

    private BaseElement element;
    private String formName;

    public BaseForm(BaseElement element, String formName){
        this.element = element;
        this.formName = formName;
    }

    public BaseForm() {}

    public String getFormName() { return formName; }

      public BaseElement getElement(){
        return element;
    }

    public boolean isPageOpened() throws IOException, ParseException {
        return element.isDisplayed();
    }

    public BaseForm scrollDown() throws IOException, ParseException {
        JSUtil.pageScrollDown();
        return this;
    }
}
