package by.a1qa.task3.base;

import by.a1qa.task3.util.FrameUtil;
import org.openqa.selenium.By;

public abstract class BaseFrame extends BaseForm{

    private By frameLocator;

    public BaseFrame(BaseElement element, By frameLocator, String formName) {
        super(element, formName);
        this.frameLocator = frameLocator;
    }

    public void switchToThisFrame(){
        FrameUtil.switchToFrame(frameLocator);
    }

    public void leaveFrame(){
        FrameUtil.leaveFrame();
    }
}