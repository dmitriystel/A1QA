package by.a1qa.task2_1.test;

import by.a1qa.task2_1.driver.WebDriverSingleton;
import by.a1qa.task2_1.page.HomePagePF;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class StoreSteamTest {
    private WebDriver driver;

    @BeforeMethod
    public void browserSetUp() {
        driver = WebDriverSingleton.getInstance();
        driver.manage().window().maximize();
    }

    @Test
    public void testPrivacyPolicySignedInCurrentYear() throws IOException {
        String policyRevisionString = new HomePagePF(driver)
                .openHomePage()
                .scrollHomePage()
                .openPrivacyPolicyPage()
                .getPolicyRevisionString();
        Assert.assertTrue(policyRevisionString.contains(Integer.toString(Year.now().getValue())),
                "Policy revision signed not in the current year.");
    }



    @AfterMethod(alwaysRun = true)
    public void closeWebDiver() {
        driver.quit();
        driver = null;
    }
}
