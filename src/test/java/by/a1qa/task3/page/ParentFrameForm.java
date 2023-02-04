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
    private static Label childIframeLabel = new Label(By.xpath("//p[contains(text(), 'Child Iframe')]"), "Child Iframe");

    public ParentFrameForm() {
        super(parentFrameLabel, parentFrameLocator, "Parent Frame Page");
    }

    public String getParentFrameLabelText() {
        return parentFrameLabel.getText();
    }

    public String getChildIframeLabelText() {
        return childIframeLabel.getText();
    }

    public void switchToChildFrame() {
        childIframePage.switchToThisFrame();
    }

    public void leaveChildFrame() {
        childIframePage.leaveFrame();
    }
}
