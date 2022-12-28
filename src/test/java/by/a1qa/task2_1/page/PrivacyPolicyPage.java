package by.a1qa.task2_1.page;

import by.a1qa.task2_1.bean.PrivacyPolicyRevision;
import by.a1qa.task2_1.driver.DriverSingleton;
import by.a1qa.task2_1.util.ParserJavaToJson;
import by.a1qa.task2_1.util.ParserJsonToJava;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

/*
Code review 23.12.2022
15th comment:
What if I need 100 elements to check?
Use findElements and working with a list of elements
fixed: Used findElements and working with a list of elements

*/
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

    public Boolean isAllLanguagesDisplayed(){
        Boolean result = false;
        WebElement languageList = (DriverSingleton.getInstance()).findElement(languageListLocator);
        List<WebElement> languagesWebElements = languageList.findElements(flagLocator);
        for (WebElement language : languagesWebElements){
            if (language.getAttribute("src").contains("english") ||
                    language.getAttribute("src").contains("spanish") ||
                    language.getAttribute("src").contains("french") ||
                    language.getAttribute("src").contains("german") ||
                    language.getAttribute("src").contains("italian") ||
                    language.getAttribute("src").contains("russian") ||
                    language.getAttribute("src").contains("japanese") ||
                    language.getAttribute("src").contains("portuguese") ||
                    language.getAttribute("src").contains("brazilian")
            ){
                result = true;
            } else
                result = false;
            break;
        }
        return result;
    }

    public String getPolicyRevisionString() throws IOException {
        PrivacyPolicyRevision privacyPolicyRevision
                = new PrivacyPolicyRevision((DriverSingleton.getInstance()).findElement(policyRevisionLocator).getText());
        ParserJavaToJson.writeJavaInJson(POLICY_REVISION_DB_PATH, privacyPolicyRevision);
        PrivacyPolicyRevision revision = ParserJsonToJava.jsonParseObject(POLICY_REVISION_DB_PATH);
        return revision.toString();
    }
}