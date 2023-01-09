package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseFrame;
import by.a1qa.task3.element.Label;
import org.openqa.selenium.By;

public class LowerFrameForm extends BaseFrame {

    private static By lowerFrameLabelLocator = By.id("sampleHeading");
    private static By lowerFrameLocator = By.id("frame2");
    private static Label lowerFrameLabel = new Label(lowerFrameLabelLocator, "Lower frame label");

    public LowerFrameForm() {
        super(lowerFrameLabel, lowerFrameLocator, "Lower Frame Page");
    }

    public String getLowerFrameLabelText(){
        return this.getElement().getText();
    }

}
