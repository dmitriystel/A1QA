package by.a1qa.task2_1.test;

import by.a1qa.task2_1.page.MainPage;
import by.a1qa.task2_1.page.PrivacyPolicyPage;
import by.a1qa.task2_1.util.JSUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Year;
import java.util.List;

public class PrivacyPolicyTest extends BaseTest {
    @Test
    public void testPrivacyPolicySignedInCurrentYear(){
        MainPage mainPage = new MainPage();
        PrivacyPolicyPage privacyPolicyPage;

         mainPage.navigateToMainPage();
        JSUtil.pageScrollDown();
        privacyPolicyPage = mainPage.openPrivacyPolicy();

        Assert.assertTrue(privacyPolicyPage.isPageOpen(),
                "Privacy policy page isn't open in the new tab." +
                        "Switch language elements list didn't displayed.");

        List<String> langList = privacyPolicyPage.getLanguageList();
        for(String lang : langList){

            Assert.assertTrue(lang.contains("english") || lang.contains("spanish") || lang.contains("french")
                    || lang.contains("german") || lang.contains("italian") || lang.contains("russian")
                            || lang.contains("japanese") || lang.contains("portuguese") || lang.contains("brazilian"),
                    lang + "isn't supported");
        }

        String policyRevisionString = privacyPolicyPage.getPolicyRevisionString();

        Assert.assertTrue(policyRevisionString.contains(Integer.toString(Year.now().getValue())),
                "Policy revision didn't sign in the current year.");
    }
}
