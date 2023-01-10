package by.a1qa.task3.base;

import by.a1qa.task3.util.JSUtil;

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

    public boolean isPageOpened(){
        return element.isDisplayed();
    }

    public BaseForm scrollDown(){
        JSUtil.pageScrollDown();
        return this;
    }
}
