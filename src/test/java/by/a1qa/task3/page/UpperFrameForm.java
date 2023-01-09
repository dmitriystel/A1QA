package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseFrame;
import by.a1qa.task3.element.Label;
import org.openqa.selenium.By;

public class UpperFrameForm extends BaseFrame {

    private static By upperFrameLabelLocator = By.id("sampleHeading");
    private static By upperFrameLocator = By.id("frame1");
    private static Label upperFrameLabel = new Label(upperFrameLabelLocator, "Upper frame label");

    public UpperFrameForm() {
        super(upperFrameLabel, upperFrameLocator, "Upper Frame Page");
    }

    public String getUpperFrameLabelText(){
        return this.getElement().getText();
    }
}