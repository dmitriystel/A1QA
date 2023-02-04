package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
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

    public void openAlertYouClickedBtn(){
        toSeeAlertBtn.click();
    }

    public AlertsForm openAlertDoYouConfirmActionBtn(){
        confirmBoxBtn.click();
        return this;
    }

    public String getConfirmBoxResultLabelText() {
        return confirmBoxResultLabel.getText();
    }

    public void openAlertPleaseEnterYourNameBtn(){
        promptBoxBtn.click();
    }

    public String getPromptBoxResultLabelText() {
        return promptBoxResultLabel.getText();
    }
}
