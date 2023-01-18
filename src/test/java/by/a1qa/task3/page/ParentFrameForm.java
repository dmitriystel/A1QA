package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseFrame;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.IOException;

public class ParentFrameForm extends BaseFrame {

    private ChildIframeForm childIframePage = new ChildIframeForm();

    private static By parentFrameLocator = By.id("frame1");
    private static Label parentFrameLabel = new Label(By.xpath("//body[contains(text(), 'Parent frame')]"), "parentFrameLabel");

    public ParentFrameForm() {
        super(parentFrameLabel, parentFrameLocator, "Parent Frame Page");
    }

    public String getParentFrameLabelText() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : getParentFrameLabelText()");
        return this.getElement().getText();
    }

    public String getChildIframeLabelText() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : getChildIframeLabelText()");
        return childIframePage.getElement().getText();
    }

    public void switchToChildFrame() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : switchToChildFrame()");
        childIframePage.switchToThisFrame();
    }

    public void leaveChildFrame() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : leaveChildFrame()");
        childIframePage.leaveFrame();
    }
}
