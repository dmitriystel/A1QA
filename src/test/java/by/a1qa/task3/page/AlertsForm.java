package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import java.io.IOException;

public class AlertsForm extends BaseForm {
    private static Label alertsLabel
        = new Label(By.xpath("//div[contains(@class, 'main-header') and contains(text(), 'Alerts')]"), "alertsFrameAndWindowLabel");
    private Button toSeeAlertBtn = new Button(By.id("alertButton"), "to see alert button");
    private Button confirmBoxBtn = new Button(By.id("confirmButton"), "confirm box will appear button");
    private Label confirmBoxResultLabel = new Label(By.id("confirmResult"), "Confirm box result after alert");
    private Button promptBoxBtn = new Button(By.id("promtButton"), "prompt box will appear button");
    private Label promptBoxResultLabel = new Label(By.id("promptResult"), "Prompt box result after alert");

    public AlertsForm() {
        super(alertsLabel, "alertsForm");
    }

    public void openAlertYouClickedBtn() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : openAlertYouClickedBtn()");
        toSeeAlertBtn.click();
    }


    public AlertsForm openAlertDoYouConfirmActionBtn() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : openAlertDoYouConfirmActionBtn()");
        confirmBoxBtn.click();
        return this;
    }

    public String getConfirmBoxResultLabelText() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : getConfirmBoxResultLabelText()");
        return confirmBoxResultLabel.getText();
    }

    public void openAlertPleaseEnterYourNameBtn() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : openAlertPleaseEnterYourNameBtn()" );
        promptBoxBtn.click();
    }

    public String getPromptBoxResultLabelText() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : getPromptBoxResultLabelText()" );
        return promptBoxResultLabel.getText();
    }
}
