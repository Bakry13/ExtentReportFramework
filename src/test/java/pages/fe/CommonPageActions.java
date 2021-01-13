package pages.fe;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import utilities.ConfigUtil;
import utilities.actions.BrowserActions;
import utilities.actions.ElementActions;
import utilities.readers.JsonTestDataReader;

public class CommonPageActions
{
    //=======================Set json file path for page data==============================
    JSONObject pageData;
    JSONObject pageLocators;
    JSONObject pageText;
    //String path = "pages/loginPage.json";
    public void setPageDataPath(String path)
    {
        pageData = JsonTestDataReader.parseJson(path);
        pageLocators = (JSONObject) pageData.get("Locators");
        pageText = (JSONObject) pageData.get("Text");
    }
    //--------------------------get locator from json file-----------------------------
    public By getLocator(String elementString) {
        By locator= null;
        String locatorString= pageLocators.get(elementString).toString();
        if (locatorString.equals(""))
            System.out.println("No Such Element");
        else
            locator=By.id(locatorString);
        return locator;
    }
    //================================Common Website Actions====================================
    public  void login()
    {
        BrowserActions.navigateToPage(ConfigUtil.WebSTURL);
    }

    public String getChangeLanguageButtonText()
    {
        String language= ElementActions.getTextOfElement(getLocator("ChangeLanguageButton"));
        return language;
    }

    public String getLanguage()
    {   String language ="";
        if (getChangeLanguageButtonText().equals("English"))
            language="Deutsch";
        else if (getChangeLanguageButtonText().equals("Deutsch"))
            language="English";
        else
            System.out.println("error in getting the language ");
        return language;
    }

    public void setLanguage(String language)
    {
        if (getChangeLanguageButtonText().equals(language))
            ElementActions.forceClickOnElementByLocator(getLocator("ChangeLanguageButton"));
        System.out.println(language+" is selected");
        while (getChangeLanguageButtonText().equals(language)|| getChangeLanguageButtonText().equals(""));
    }

    public boolean getElementVisibility(String elementString)
    {
        By elementLocator=getLocator(elementString);
        return ElementActions.checkElementExists(elementLocator);
    }
    public String getElementText(String elementString)
    {
        By elementLocator=getLocator(elementString);
        return ElementActions.getTextOfElement(elementLocator);
    }

    public String getDisplayText(String ElementName, String language)
    {
        JSONObject elementTextJson= (JSONObject)pageText.get(ElementName);
        String elementText = elementTextJson.get(language).toString();
        return elementText;
    }

    public void click(String elementString) {
        ElementActions.clickOnElementByLocator(getLocator(elementString));
    }
    public String getText(String elementString) {
        String elementText ="";
        By elementLocator = getLocator(elementString);
        elementText =   ElementActions.getTextOfElement(elementLocator);
        return elementText;
    }
    public void setText(String elementString, String input ) {
        By elementLocator= getLocator(elementString);
        ElementActions.typeInTextField(elementLocator,input+"\t");
    }
    public void clearText(String elementString ) {
        By elementLocator= getLocator(elementString);
        ElementActions.forceClearTestBox(elementLocator);
    }
}