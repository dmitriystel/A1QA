package by.a1qa.task3.base;

import by.a1qa.task3.driver.DriverSingleton;
import by.a1qa.task3.util.ConditionalWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        return DriverSingleton.getDriver().findElement(locator);
    }

    public boolean isDisplayed() {
        return !DriverSingleton.getDriver().findElements(locator).isEmpty();
    }
    public void click(){
        ConditionalWait.waitToBeClickableByLocator(locator);
        findElement(locator).click();
    }

    public String getText(){
        return findElement(locator).getText();
    }
}
