package by.a1qa.task3.test;

import by.a1qa.task3.driver.DriverSingleton;
import by.a1qa.task3.util.BrowserUtil;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public abstract class BaseTest {

    @BeforeClass(alwaysRun = true)
    public void browserSetUp() throws IOException, ParseException {
        DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() throws IOException, ParseException {
        DriverSingleton.closeBrowser();
    }
}
