package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Label;
import org.openqa.selenium.By;

public class FramesForm extends BaseForm {

    private static By framesLabelLocator = By.xpath("//div[text()='Frames']");
    private static Label framesLabel = new Label(framesLabelLocator, "framesLabel");

    // constructor to create an instance of the class
    public FramesForm() {
        super(framesLabel, "framesLabel");
    }
}

