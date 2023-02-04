package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseFrame;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import java.io.IOException;

public class LowerFrameForm extends BaseFrame {

    private static By lowerFrameLocator = By.id("frame2");
    private static Label lowerFrameLabel = new Label(By.id("sampleHeading"), "Lower frame label");

    public LowerFrameForm() {
        super(lowerFrameLabel, lowerFrameLocator, "Lower Frame Page");
    }

    public String getLowerFrameLabelText() {
        return lowerFrameLabel.getText();
    }
}
