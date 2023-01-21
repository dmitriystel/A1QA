package by.a1qa.task3.base;

import by.a1qa.task3.driver.DriverSingleton;
import by.a1qa.task3.util.ConditionalWait;
import by.a1qa.task3.util.JSUtil;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public abstract class BaseElement {
    private By locator;
    private String elementName;

    public BaseElement(By locator, String elementName){
        this.locator = locator;
        this.elementName = elementName;
    }
    public By getLocator() {
        return locator;
    }
    public String getElementName() {
        return elementName;
    }
    protected WebElement findElement(By locator) throws IOException, ParseException {
        return DriverSingleton.getDriver().findElement(locator);
    }
    public boolean isDisplayed() throws IOException, ParseException {
        return !DriverSingleton.getDriver().findElements(locator).isEmpty();
    }
    public void click() throws IOException, ParseException {
        JSUtil.pageScrollDown(locator);
        ConditionalWait.waitToBeClickableByLocator(locator);
        findElement(locator).click();
    }
    public String getText() throws IOException, ParseException {
        return findElement(locator).getText();
    }
}
