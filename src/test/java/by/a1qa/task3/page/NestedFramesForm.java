package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import org.openqa.selenium.By;

public class NestedFramesForm  extends BaseForm {
    private static By nestedFramesLabelLocator = By.xpath("//div[contains(text(), 'Nested Frame')]");
    private static Label nestedFramesLabel = new Label(nestedFramesLabelLocator, "nestedFramesLabel");

    private By framesButtonLocator =  By.xpath("//span[text()='Frames']//parent::li");
    private Button framesButton = new Button(framesButtonLocator, "Frames Button");


    public NestedFramesForm() {
        super(nestedFramesLabel, "nestedFramesLabel");
    }

    public NestedFramesForm framesButtonClick() {
        framesButton.click();
        return this;
    }


}
