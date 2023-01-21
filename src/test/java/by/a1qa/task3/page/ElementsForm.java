package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import java.io.IOException;

public class ElementsForm extends BaseForm {
    private static Label elementsLabel
        = new Label(By.xpath("//div[contains(@class, 'main-header') and contains(text(), 'Elements')]"), "elementsLabel");
    private Button webTablesBtn = new Button(By.xpath("//span[contains(text(), 'Web')]//parent::li"), "Web Tables button");

    public ElementsForm() {
        super(elementsLabel, "Elements page");
    }
    public ElementsForm clickWebTablesBtn() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : clickWebTablesBtn()");
        webTablesBtn.click();
        return this;
    }
}
