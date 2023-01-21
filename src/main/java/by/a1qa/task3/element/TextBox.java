package by.a1qa.task3.element;

import by.a1qa.task3.base.BaseElement;
import by.a1qa.task3.util.CustomLogger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import java.io.IOException;

public class TextBox extends BaseElement {
    public TextBox(By uniqueLocator, String elementName) {
        super(uniqueLocator, elementName);
    }

    public void sendText(String text) throws IOException, ParseException {
        CustomLogger.info(this.getElementName() + ".sendText(): " + text);
        findElement(this.getLocator()).sendKeys(text);
    }
}
