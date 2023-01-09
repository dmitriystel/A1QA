package by.a1qa.task3.test;

import by.a1qa.task3.driver.DriverSingleton;
import by.a1qa.task3.util.BrowserUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    @BeforeClass(alwaysRun = true)
    public void browserSetUp(){
        DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown(){
        BrowserUtil.closeBrowser();
    }
}
