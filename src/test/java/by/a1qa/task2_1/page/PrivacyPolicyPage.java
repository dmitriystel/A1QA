package by.a1qa.task2_1.page;

import by.a1qa.task2_1.bean.PrivacyPolicyRevision;
import by.a1qa.task2_1.driver.DriverSingleton;
import by.a1qa.task2_1.util.ParserJavaToJson;
import by.a1qa.task2_1.util.ParserJsonToJava;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrivacyPolicyPage extends BasePage{
    public static final String POLICY_REVISION_DB_PATH = "src/test/resources/testData/PrivacyPolicyRevisionDB.json";
    By languageListLocator = By.id("languages");
    By flagLocator = By.xpath(".//img[contains(@src, 'language')]");
    By policyRevisionLocator = By.xpath("//i[contains(text(),'2022')]");

    public PrivacyPolicyPage() {
        super();
    }

    public Boolean isPageOpen(){
        return (DriverSingleton.getInstance()).findElement(languageListLocator).isDisplayed();
    }

    public List<String> getLanguageList(){
        List<String> languages = new ArrayList<>();
        WebElement languageList = (DriverSingleton.getInstance()).findElement(languageListLocator);
        List<WebElement> languagesWebElements = languageList.findElements(flagLocator);
        for (WebElement language : languagesWebElements){
            languages.add(language.getAttribute("src"));
        }
        return languages;
    }

    public String getPolicyRevisionString()  {
        PrivacyPolicyRevision privacyPolicyRevision
                = new PrivacyPolicyRevision((DriverSingleton.getInstance()).findElement(policyRevisionLocator).getText());
        try {
            ParserJavaToJson.writeJavaInJson(POLICY_REVISION_DB_PATH, privacyPolicyRevision);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrivacyPolicyRevision revision = null;
        try {
            revision = ParserJsonToJava.jsonParseObject(POLICY_REVISION_DB_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return revision.toString();
    }
}