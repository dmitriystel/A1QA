package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.openqa.selenium.By;

public class AlertsFrameWindowsForm extends BaseForm {

    private static By alertsFrameAndWindowLabelLocator = By.xpath("//div[@class='main-header' and contains(text(), 'Alerts, Frame & Windows')]");
    private static Label alertsFrameAndWindowLabel = new Label(alertsFrameAndWindowLabelLocator, "alertsFrameAndWindowLabel");

    private By alertsBtnLocator = By.xpath("//span[contains(text(), 'Alerts')]//parent::li");
    private Button alertsBtn = new Button(alertsBtnLocator, "Alerts Button");

    private By nestedFramesButtonLocator = By.xpath("//span[contains(text(), 'Nested')]//parent::li");
    private Button nestedFramesButton = new Button(nestedFramesButtonLocator, "Nested Frames Button");


    public AlertsFrameWindowsForm() {
        super(alertsFrameAndWindowLabel, "alertsFrameAndWindowsPage");
    }

    public AlertsFrameWindowsForm openAlertsForm(){
        CustomLogger.info(this.getFormName() + " : openAlertsForm()");
//        ConditionalWait.waitToBeClickable(alertsBtn);
        alertsBtn.click();
        return this;
    }

    public AlertsFrameWindowsForm nestedFramesButtonClick() {
        nestedFramesButton.click();
        return this;
    }

}
