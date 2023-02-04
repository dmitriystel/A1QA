package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import java.io.IOException;

public class NestedFramesForm extends BaseForm {

    private static Label nestedFramesLabel = new Label(By.xpath("//div[contains(text(), 'Nested Frame')]"), "nestedFramesLabel");
    private Button framesBtn = new Button(By.xpath("//span[text()='Frames']//parent::li"), "Frames Button");

    public NestedFramesForm() {

        super(nestedFramesLabel, "nestedFramesLabel");
    }

    public NestedFramesForm clickFramesBtn(){
        framesBtn.click();
        return this;
    }
}
