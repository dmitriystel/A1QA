package by.a1qa.task3.base;

import by.a1qa.task3.driver.Driver;
import by.a1qa.task3.util.ConditionalWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseElement {
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
//        return Driver.getDriver().findElement(locator); // was
        return Driver.getInstance().findElement(locator);

    }

    public boolean isDisplayed() {
//        return !Driver.getDriver().findElements(locator).isEmpty(); // was
        return !Driver.getInstance().findElements(locator).isEmpty();
    }
    public void click(){
        ConditionalWait.waitToBeClickableByLocator(locator);    // todo check if it necessary
        findElement(locator).click();
    }

    public String getText(){
        return findElement(locator).getText();
    }
}
