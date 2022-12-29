package by.a1qa.task2_1.page;

import by.a1qa.task2_1.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected BasePage() {
        driver = DriverSingleton.getInstance();
    }
}
