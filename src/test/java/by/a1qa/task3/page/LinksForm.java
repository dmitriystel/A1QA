package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import java.io.IOException;

public class LinksForm extends BaseForm {

    private static Label linksFormLabel = new Label(By.xpath("//div[contains(text(),'Links')]/parent::div"), "Links Form label");
    private Button homeBtn = new Button(By.id("simpleLink"), "home button");

    public LinksForm(){super(linksFormLabel, "Links");}

    public LinksForm clickHomeBtn() throws IOException, ParseException {
        CustomLogger.info(this.getFormName() + " : clickHomeBtn()");
        homeBtn.click();
        return this;
    }
}