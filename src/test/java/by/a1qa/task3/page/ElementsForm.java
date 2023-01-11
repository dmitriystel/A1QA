package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.openqa.selenium.By;

public class ElementsForm extends BaseForm {

    private static By elementsLabelLocator = By.xpath("//div[@class = 'main-header' and contains(text(), 'Elements')]");
    private static Label elementsLabel = new Label(elementsLabelLocator, "elementsLabel");

    private By webTablesBtnLocator = By.xpath("//span[contains(text(), 'Web')]//parent::li");
    private Button webTablesBtn = new Button(webTablesBtnLocator, "Web Tables button");

    public ElementsForm() {
        super(elementsLabel, "Elements page");
    }

    public ElementsForm clickWebTablesBtn(){
        CustomLogger.info(this.getFormName() + " : clickWebTablesBtn()");
        webTablesBtn.click();
        return this;
    }
}
