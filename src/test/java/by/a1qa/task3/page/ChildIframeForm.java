package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseFrame;
import by.a1qa.task3.element.Label;
import org.openqa.selenium.By;

public class ChildIframeForm extends BaseFrame {
    private static By childIframeLocator = By.xpath("//body/iframe");
    private static Label childIframeLabel = new Label(By.xpath("//p[contains(text(), 'Child Iframe')]"), "Child Iframe");

    public ChildIframeForm() {
        super(childIframeLabel, childIframeLocator, "Child Frame Page");
    }
}
