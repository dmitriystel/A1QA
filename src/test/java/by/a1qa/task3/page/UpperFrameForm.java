package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseFrame;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import java.io.IOException;

public class UpperFrameForm extends BaseFrame {

    private static By upperFrameLocator = By.id("frame1");
    private static Label upperFrameLabel = new Label(By.id("sampleHeading"), "Upper frame label");

    public UpperFrameForm() {
        super(upperFrameLabel, upperFrameLocator, "Upper Frame Page");
    }

    public String getUpperFrameLabelText() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : getUpperFrameLabelText()");
        return upperFrameLabel.getText();
    }
}