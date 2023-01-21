package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import java.io.IOException;

public class BrowserWindowsForm extends BaseForm {
    private static Label browserWindowsFormLabel
            = new Label(By.xpath("//div[contains(text(),'Browser')]/parent::div"), "Browser Windows Form label");
    private Button newTabBtn = new Button(By.id("tabButton"), "New Tab button");
    private Button elementsBtn = new Button(By.xpath("//div[contains(text(), 'Elements')]"), "elements head button");
    private Button linksBtn = new Button(By.xpath("//span[text()='Links']//parent::li"), "Links button");

    public BrowserWindowsForm() {
        super(browserWindowsFormLabel, "Browser Windows");
    }
    public void newTabBtnClick() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : newTabBtnClick()");
        newTabBtn.click();
    }
    public BrowserWindowsForm elementsButtonClick() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : elementsButtonClick()");
        elementsBtn.click();
        return this;
    }
    public BrowserWindowsForm linksButtonClick() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : linksButtonClick()");
        linksBtn.click();
        return this;
    }
}
