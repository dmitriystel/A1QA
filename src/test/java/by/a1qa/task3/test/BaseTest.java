package by.a1qa.task3.test;

import by.a1qa.task3.driver.Driver;
import by.a1qa.task3.util.BrowserUtil;
import by.a1qa.task3.util.ConfigManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

//    private final String HOMEPAGE_URL = ConfigManager.getBrowserName();

    @BeforeClass(alwaysRun = true)
    public void browserSetUp(){
        Driver.getInstance();
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown(){
        BrowserUtil.closeBrowser();
    }

}
