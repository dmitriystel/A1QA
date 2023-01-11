package by.a1qa.task3.element;

import by.a1qa.task3.base.BaseElement;
import by.a1qa.task3.util.CustomLogger;
import org.openqa.selenium.By;

public class TextBox extends BaseElement {

    public TextBox(By uniqueLocator, String elementName) {
        super(uniqueLocator, elementName);
    }

    public void sendText(String text){
        CustomLogger.info(this.getElementName() + ".sendText(): " + text);
        findElement(this.getLocator()).sendKeys(text);
    }
}
