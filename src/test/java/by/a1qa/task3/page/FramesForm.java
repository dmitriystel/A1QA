package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Label;
import org.openqa.selenium.By;

public class FramesForm extends BaseForm {

    private static Label framesLabel = new Label(By.xpath("//div[text()='Frames']"), "framesLabel");

    public FramesForm() {
        super(framesLabel, "framesLabel");
    }
}

