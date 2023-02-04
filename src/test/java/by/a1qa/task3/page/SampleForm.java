package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Label;
import org.openqa.selenium.By;

public class SampleForm extends BaseForm {

    private static Label samplePageLabel = new Label(By.id("sampleHeading"), "Sample page label");

    public SampleForm() {
        super(samplePageLabel, "Sample page");
    }
    public String getPageLabelText()  {
        return samplePageLabel.getText();
    }
}
