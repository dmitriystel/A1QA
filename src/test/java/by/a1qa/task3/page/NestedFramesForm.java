package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.openqa.selenium.By;

public class NestedFramesForm extends BaseForm {

    private static By nestedFramesLabelLocator = By.xpath("//div[contains(text(), 'Nested Frame')]");
    private static Label nestedFramesLabel = new Label(nestedFramesLabelLocator, "nestedFramesLabel");

    private By framesBtnLocator =  By.xpath("//span[text()='Frames']//parent::li");
    private Button framesBtn = new Button(framesBtnLocator, "Frames Button");

    public NestedFramesForm() {
        super(nestedFramesLabel, "nestedFramesLabel");
    }

    public NestedFramesForm clickFramesBtn() {
        CustomLogger.info(this.getFormName() + " : clickFramesBtn()");
        framesBtn.click();
        return this;
    }
}
