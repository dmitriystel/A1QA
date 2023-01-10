package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.openqa.selenium.By;

public class LinksForm extends BaseForm {

    private static By linksFormLabelLocator = By.xpath("//div[contains(text(),'Links')]/parent::div");
    private static Label linksFormLabel = new Label(linksFormLabelLocator, "Links Form label");

    private By homeBtnLocator = By.id("simpleLink");
    private Button homeBtn = new Button(homeBtnLocator, "home button");

    public LinksForm(){super(linksFormLabel, "Links");}

    public LinksForm clickHomeBtn(){
        CustomLogger.info(this.getFormName() + " : clickHomeBtn()");
        homeBtn.click();
        return this;
    }
}