package by.a1qa.task2_1.test;

import by.a1qa.task2_1.page.MainPage;
import by.a1qa.task2_1.page.PrivacyPolicyPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Year;

public class StoreSteamTest extends BaseTest {

    @Test
    public void testPrivacyPolicySignedInCurrentYear() throws IOException {
        MainPage mainPagePF = new MainPage(driver);
        PrivacyPolicyPage privacyPolicyPage;

        privacyPolicyPage = mainPagePF
                .navigateToMainPage()
                .scrollAndOpenPrivacyPolicy();

        Assert.assertTrue(privacyPolicyPage.isSwitchLanguageElementsListDisplayed(),
                "Privacy policy page is not open in the new tab.");

        String policyRevisionString = privacyPolicyPage
                .getPolicyRevisionString();

        Assert.assertTrue(policyRevisionString.contains(Integer.toString(Year.now().getValue())),
                "Policy revision signed not in the current year.");
    }
}
