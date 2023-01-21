package by.a1qa.task3.base;

import by.a1qa.task3.util.FrameUtil;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import java.io.IOException;

public abstract class BaseFrame extends BaseForm{
    private By frameLocator;

    public BaseFrame(BaseElement element, By frameLocator, String formName) {
        super(element, formName);
        this.frameLocator = frameLocator;
    }
    public void switchToThisFrame() throws IOException, ParseException {
        FrameUtil.switchToFrame(frameLocator);
    }
    public void leaveFrame() throws IOException, ParseException {
        FrameUtil.leaveFrame();
    }
}