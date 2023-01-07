package by.a1qa.task3.util;

import by.a1qa.task3.base.BaseElement;
import by.a1qa.task3.driver.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConditionalWait {

    private static int seconds = ConfigManager.getWaitDurationInSeconds();
    private static Duration duration = Duration.ofSeconds(seconds);

    public static void waitToBeClickable(BaseElement element){
//        new WebDriverWait(Driver.getDriver(), duration)
//                .until(ExpectedConditions.elementToBeClickable(element.getLocator()));

        new WebDriverWait(Driver.getInstance(), duration)
                .until(ExpectedConditions.elementToBeClickable(element.getLocator()));

    }

    public static void waitElementDisappears(BaseElement element){
//        new WebDriverWait(Driver.getDriver(), duration).until(ExpectedConditions
//                .invisibilityOfElementLocated(element.getLocator()));

        new WebDriverWait(Driver.getInstance(), duration).until(ExpectedConditions
                .invisibilityOfElementLocated(element.getLocator()));


    }

    public static Alert waitUntilAlertIsPresent(){
//        return new WebDriverWait(Driver.getDriver(), duration)
//                .until((ExpectedConditions.alertIsPresent()));

        return new WebDriverWait(Driver.getInstance(), duration)
                .until((ExpectedConditions.alertIsPresent()));

    }

// experemented
    public static void waitToBeClickableByLocator(By locator){


        new WebDriverWait(Driver.getInstance(), duration).until(ExpectedConditions.elementToBeClickable(locator));

    }


}
