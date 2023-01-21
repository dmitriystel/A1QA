package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import java.io.IOException;

public class AlertsFrameWindowsForm extends BaseForm {
    private static Label alertsFrameAndWindowLabel
            = new Label(By.xpath("//div[contains(@class, 'main-header') and contains(text(), 'Alerts, Frame & Windows')]"),
        "alertsFrameAndWindowLabel");
    private Button alertsBtn = new Button(By.xpath("//span[contains(text(), 'Alerts')]//parent::li"), "Alerts Button");
    private Button nestedFramesBtn = new Button(By.xpath("//span[contains(text(), 'Nested')]//parent::li"), "Nested Frames Button");
    private Button browserWindowsBtn = new Button(By.xpath("//span[contains(text(), 'Browser')]//parent::li"), "Browser Windows button");

    public AlertsFrameWindowsForm() {
        super(alertsFrameAndWindowLabel, "alertsFrameAndWindowsPage");
    }

    public AlertsFrameWindowsForm openAlertsForm() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : openAlertsForm()");
        alertsBtn.click();
        return this;
    }
    public AlertsFrameWindowsForm nestedFramesBtnClick() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : nestedFramesButtonClick()");
        nestedFramesBtn.click();
        return this;
    }
    public AlertsFrameWindowsForm browserWindowsBtnClick() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : browserWindowsButtonClick()");
        browserWindowsBtn.click();
        return this;
    }
}
