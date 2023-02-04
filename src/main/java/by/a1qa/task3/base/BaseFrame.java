package by.a1qa.task3.base;

import by.a1qa.task3.util.CustomLogger;
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

    public void switchToThisFrame()  {
        CustomLogger.info(this.getFormName() + " : switchToThisFrame()");
        try {
            FrameUtil.switchToFrame(frameLocator);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void leaveFrame()  {
        CustomLogger.info(this.getFormName() + " : leaveFrame()");
        try {
            FrameUtil.leaveFrame();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}