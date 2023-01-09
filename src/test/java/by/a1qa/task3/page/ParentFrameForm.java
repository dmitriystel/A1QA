package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseFrame;
import by.a1qa.task3.element.Label;
import org.openqa.selenium.By;

public class ParentFrameForm extends BaseFrame {

    private ChildIframeForm childIframePage = new ChildIframeForm();

    private static By parentFrameLabelLocator = By.xpath("//body[contains(text(), 'Parent frame')]");
    private static By parentFrameLocator = By.id("frame1");
    private static Label parentFrameLabel = new Label(parentFrameLabelLocator, "parentFrameLabel");

    public ParentFrameForm() {
        super(parentFrameLabel, parentFrameLocator, "Parent Frame Page");
    }

    public String getParentFrameLabelText(){
        return this.getElement().getText();
    }

    public String getChildIframeLabelText(){
        return childIframePage.getElement().getText();
    }

    public void switchToChildFrame(){
        childIframePage.switchToThisFrame();
    }

    public void leaveChildFrame() {
        childIframePage.leaveFrame();
    }
}
