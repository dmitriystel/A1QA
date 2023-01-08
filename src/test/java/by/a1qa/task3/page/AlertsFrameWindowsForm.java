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
    private Button nestedFramesBtn = new Button(nestedFramesButtonLocator, "Nested Frames Button");

    private By browserWindowsButtonLocator = By.xpath("//span[contains(text(), 'Browser')]//parent::li");
    private Button browserWindowsBtn = new Button(browserWindowsButtonLocator, "Browser Windows button");


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
        nestedFramesBtn.click();
        return this;
    }

    public AlertsFrameWindowsForm browserWindowsButtonClick() {
        browserWindowsBtn.click();
        return this;
    }

}
