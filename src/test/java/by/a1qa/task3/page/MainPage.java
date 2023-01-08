package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.BrowserUtil;
import by.a1qa.task3.util.ConditionalWait;
import by.a1qa.task3.util.ConfigManager;
import by.a1qa.task3.util.CustomLogger;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {

    private static By seleniumCertificationTrainingLabelLocator = By.xpath("//img[contains(@class, 'banner')]");
    private static Label seleniumCertificationTrainingLabel = new Label(seleniumCertificationTrainingLabelLocator,
            "seleniumCertificationTrainingLabel");

    private By alertsFrameAndWindowsBtnLocator = By.xpath("//h5[contains(text(), 'Alerts')]//parent::div");
    private Button alertsFrameAndWindowsBtn = new Button(alertsFrameAndWindowsBtnLocator,
            "Alerts, Frame & Windows button");

    private By elementsButtonLocator = By.xpath("//h5[contains(text(), 'Elements')]//parent::div");
    private Button elementsButton = new Button(elementsButtonLocator, "Elements button");

    public MainPage() {
        super(seleniumCertificationTrainingLabel, "mainPage");
    }


    public MainPage navigateToMainPage() {
        CustomLogger.info(this.getFormName() + " : navigateToMainPage");
        BrowserUtil.goToURL(ConfigManager.getURL());
        return this;
    }

    public MainPage clickAlertsFrameWindowsBtn(){
        CustomLogger.info(this.getFormName() + " : clickAlertsFrameWindowsBtn()");
//        ConditionalWait.waitToBeClickable(alertsFrameAndWindowsBtn);
        alertsFrameAndWindowsBtn.click();
        return this;
    }

    public MainPage clickElementsBtn(){
        CustomLogger.info(this.getFormName() + " : clickElementsBtn()");
//        ConditionalWait.waitToBeClickable(elementsButton);
        elementsButton.click();
        return this;
    }

}
