package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.IOException;

public class SampleForm  extends BaseForm {

    private static Label samplePageLabel = new Label(By.id("sampleHeading"), "Sample page label");

    public SampleForm() {
        super(samplePageLabel, "Sample page");
    }

    public String getPageLabelText() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : getPageLabelText()");
//        return this.getElement().getText();
        return samplePageLabel.getText();
    }
}
