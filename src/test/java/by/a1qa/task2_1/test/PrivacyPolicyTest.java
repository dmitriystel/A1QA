package by.a1qa.task2_1.test;

import by.a1qa.task2_1.page.MainPage;
import by.a1qa.task2_1.page.PrivacyPolicyPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Year;

public class PrivacyPolicyTest extends BaseTest {
    @Test
    public void testPrivacyPolicySignedInCurrentYear() throws IOException {
        MainPage mainPage = new MainPage();
        PrivacyPolicyPage privacyPolicyPage;

        privacyPolicyPage = mainPage
                .navigateToMainPage()
                .openPrivacyPolicy();

        Assert.assertTrue(privacyPolicyPage.isPageOpen(),
                "Privacy policy page isn't open in the new tab." +
                        "Switch language elements list didn't displayed.");


        Assert.assertTrue(privacyPolicyPage.isAllLanguagesDisplayed(), "Not all languages supported");



        String policyRevisionString = privacyPolicyPage
                .getPolicyRevisionString();

        Assert.assertTrue(policyRevisionString.contains(Integer.toString(Year.now().getValue())),
                "Policy revision didn't sign in the current year.");
    }
}
