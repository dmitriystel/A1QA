package by.a1qa.task2_1.page;

import by.a1qa.task2_1.bean.PrivacyPolicyRevision;
import by.a1qa.task2_1.util.ParserJavaToJson;
import by.a1qa.task2_1.util.ParserJsonToJava;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class PrivacyPolicyPage extends BasePage{
    public static final String POLICY_REVISION_DB_PATH = "src/test/resources/testData/PrivacyPolicyRevisionDB.json";

    @FindBy(id = "languages")
    public WebElement languages;

    @FindBy(xpath = "//i[contains(text(),'2022')]")
    private WebElement policyRevision;

    @FindBy(xpath = "//img[contains(@src,'english')]")
    private WebElement englishFlag;

    @FindBy(xpath = "//img[contains(@src,'spanish')]")
    private WebElement spanishFlag;

    @FindBy(xpath = "//img[contains(@src,'french')]")
    private WebElement frenchFlag;

    @FindBy(xpath = "//img[contains(@src,'german')]")
    private WebElement germanFlag;

    @FindBy(xpath = "//img[contains(@src,'italian')]")
    private WebElement italianFlag;

    @FindBy(xpath = "//img[contains(@src,'russian')]")
    private WebElement russianFlag;

    @FindBy(xpath = "//img[contains(@src,'japanese')]")
    private WebElement japaneseFlag;

    @FindBy(xpath = "//img[contains(@src,'portuguese')]")
    private WebElement portugueseFlag;

    @FindBy(xpath = "//img[contains(@src,'brazilian')]")
    private WebElement brazilianFlag;

    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isPageOpen(){
        return languages.isDisplayed();
    }

    public Boolean isEnglishSupported(){
        return englishFlag.isDisplayed();
    }

    public Boolean isSpanishSupported(){
        return spanishFlag.isDisplayed();
    }

    public Boolean isFrenchSupported(){
        return frenchFlag.isDisplayed();
    }

    public Boolean isGermanSupported(){
        return germanFlag.isDisplayed();
    }

    public Boolean isItalianSupported(){
        return italianFlag.isDisplayed();
    }

    public Boolean isRussianSupported(){
        return russianFlag.isDisplayed();
    }

    public Boolean isJapaneseSupported(){
        return japaneseFlag.isDisplayed();
    }

    public Boolean isPortugueseSupported(){
        return portugueseFlag.isDisplayed();
    }

    public Boolean isBrazilianSupported(){
        return portugueseFlag.isDisplayed();
    }

    public String getPolicyRevisionString() throws IOException {
        PrivacyPolicyRevision privacyPolicyRevision = new PrivacyPolicyRevision(policyRevision.getText());
        ParserJavaToJson.writeJavaInJson(POLICY_REVISION_DB_PATH, privacyPolicyRevision);
        PrivacyPolicyRevision revision = ParserJsonToJava.jsonParseObject(POLICY_REVISION_DB_PATH);
        return revision.toString();
    }
}