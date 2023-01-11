package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.openqa.selenium.By;

public class BrowserWindowsForm extends BaseForm {

    private static By browserWindowsFormLabelLocator = By.xpath("//div[contains(text(),'Browser')]/parent::div");
    private static Label browserWindowsFormLabel
            = new Label(browserWindowsFormLabelLocator, "Browser Windows Form label");

    private By newTabBtnLocator = By.id("tabButton");
    private Button newTabBtn = new Button(newTabBtnLocator, "New Tab button");

    private By elementsBtnLocator = By.xpath("//div[contains(text(), 'Elements')]");
    private Button elementsBtn = new Button(elementsBtnLocator, "elements head button");

    private By linksBtnLocator = By.xpath("//span[text()='Links']//parent::li");
    private Button linksBtn = new Button(linksBtnLocator, "Links button");

    public BrowserWindowsForm() {
        super(browserWindowsFormLabel, "Browser Windows");
    }

    public void newTabBtnClick(){
        CustomLogger.info(this.getFormName() + " : newTabBtnClick()");
        newTabBtn.click();
    }

    public BrowserWindowsForm elementsButtonClick(){
        CustomLogger.info(this.getFormName() + " : elementsButtonClick()");
        elementsBtn.click();
        return this;
    }

    public BrowserWindowsForm linksButtonClick(){
        CustomLogger.info(this.getFormName() + " : linksButtonClick()");
        linksBtn.click();
        return this;
    }
}
