package by.a1qa.task3.base;

import by.a1qa.task3.driver.DriverSingleton;
import by.a1qa.task3.util.ConditionalWait;
import by.a1qa.task3.util.CustomLogger;
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

    protected WebElement findElement(By locator){
        CustomLogger.info(this.getElementName() + " : findElement(By locator)");
        return DriverSingleton.getDriver().findElement(locator);
    }

    public boolean isDisplayed()  {
        CustomLogger.info(this.getElementName() + " : isDisplayed()");
        return !DriverSingleton.getDriver().findElements(locator).isEmpty();
    }

    public void click() {
        JSUtil.pageScrollDown(locator);
        ConditionalWait.waitToBeClickableByLocator(locator);
        CustomLogger.info(this.getElementName() + " click()");
        findElement(locator).click();
    }

    public String getText(){
        CustomLogger.info(this.getElementName() + " getText()");
        return findElement(locator).getText();
    }
}
