package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import java.io.IOException;

public class MainPage extends BaseForm {
    private static Label seleniumCertificationTrainingLabel
            = new Label(By.xpath("//img[contains(@class, 'banner')]"), "seleniumCertificationTrainingLabel");
    private Button alertsFrameAndWindowsBtn
            = new Button(By.xpath("//h5[contains(text(), 'Alerts')]//parent::div"), "Alerts, Frame & Windows button");
    private Button elementsButton = new Button(By.xpath("//h5[contains(text(), 'Elements')]//parent::div"), "Elements button");

    public MainPage() {
        super(seleniumCertificationTrainingLabel, "mainPage");
    }
    public MainPage clickAlertsFrameWindowsBtn() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : clickAlertsFrameWindowsBtn()");
        alertsFrameAndWindowsBtn.click();
        return this;
    }
    public MainPage clickElementsBtn() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : clickElementsBtn()");
        elementsButton.click();
        return this;
    }
}
