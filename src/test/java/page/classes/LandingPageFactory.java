package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LandingPageFactory {
    public static WebDriver driver=null;
    private final WebDriverWait webDriverWait;

    private String validSearchString = "intelligent investor";
    private String invalidSearchString = "naatboltu";

    @FindBy(xpath="//span[text()='Hello, sign in']")
    private WebElement signInAccountsAndLinks;

    @FindBy(xpath="//a/span[text()='Sign in']")
    private WebElement signInButton;

    @FindBy(css="#twotabsearchtextbox")
    private WebElement searchTextBox;

    @FindBy(xpath="//div//input[@type='submit']")
    private WebElement searchButton;

    @FindBy(css="span[class='nav-line-2']")
    private WebElement changeLanguageLink;

    @FindBy(css="#icp-language-settings>div[class='a-row a-spacing-mini']")
    private List<WebElement> languageOptions;

    @FindBy(css="input[class='a-button-input']")
    private WebElement saveLanguageOption;

    @FindBy(css = "div[data-cel-widget='search_result_1']")
    private WebElement textResultsLocator;

    @FindBy(xpath = "//div[@data-cel-widget='search_result_0']//span")
    private List<WebElement> noResutlsFoundTextLocator;

    @FindBy(css="#nav-search-submit-button")
    private WebElement startSearchButton;

    private List<String> first5SearchResultsLocatorForValidSearchString;

    private List<String> first5SearchResultsLocatorForMultipleKeywordSearchString;

    @FindBy(xpath = "//div[@class='left-pane-results-container']//div/span")
    private List<WebElement> autosuggestionsLocatorForValidSearchString;

    @FindBy(css="#nav-logo-sprites")
    private WebElement navigteToLandingPageByAmazonLogoNav;

    public LandingPageFactory(WebDriver driver) {
        this.driver=driver;
        this.webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        setSearchResultLocatorForValidSearchString();
    }

    public String getValidSearchString() {
        return validSearchString;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public WebElement getSignInAccountsAndLinks() {
        return signInAccountsAndLinks;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public List<WebElement> getLanguageOptions() {
        return this.webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#icp-language-settings>div[class='a-row a-spacing-mini']")));
    }

    public WebElement getSearchTextBox() {
        return this.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#twotabsearchtextbox")));
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getChangeLanguageLink() {
        return this.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='nav-line-2']")));
    }

    public WebElement getSaveLanguageOption() {
        return this.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[class='a-button-input']")));
    }

    public WebElement getNavigteToLandingPageByAmazonLogoNav() {
        return navigteToLandingPageByAmazonLogoNav;
    }

    public List<String> getSearchResultLocatorSearchString() {
        return this.first5SearchResultsLocatorForValidSearchString;
    }

    public void setSearchResultLocatorForValidSearchString() {
        this.first5SearchResultsLocatorForValidSearchString = new ArrayList<>();
        this.first5SearchResultsLocatorForValidSearchString.add("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']//div[@class='puisg-row']//div[contains(@class, 'puis-list-col-right')]//div/h2//span");
        this.first5SearchResultsLocatorForValidSearchString.add("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-4']//div[@class='puisg-row']//div[contains(@class, 'puis-list-col-right')]//div/h2//span");
        this.first5SearchResultsLocatorForValidSearchString.add("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-5']//div[@class='puisg-row']//div[contains(@class, 'puis-list-col-right')]//div/h2//span");
        this.first5SearchResultsLocatorForValidSearchString.add("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-6']//div[@class='puisg-row']//div[contains(@class, 'puis-list-col-right')]//div/h2//span");
        this.first5SearchResultsLocatorForValidSearchString.add("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-7']//div[@class='puisg-row']//div[contains(@class, 'puis-list-col-right')]//div/h2//span");
    }

    public List<String> getFirst5SearchResultsLocatorForMultipleKeywordSearchString() {
        return first5SearchResultsLocatorForMultipleKeywordSearchString;
    }

    public void setFirst5SearchResultsLocatorForMultipleKeywordSearchString() {
        this.first5SearchResultsLocatorForMultipleKeywordSearchString = new ArrayList<>();
        this.first5SearchResultsLocatorForMultipleKeywordSearchString.add("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']//div[@class='puisg-row']//div[contains(@class, 'puis-list-col-right')]//div/h2//span");
        this.first5SearchResultsLocatorForMultipleKeywordSearchString.add("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']//div[@class='puisg-row']//div[contains(@class, 'puis-list-col-right')]//div/h2//span");
        this.first5SearchResultsLocatorForMultipleKeywordSearchString.add("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-4']//div[@class='puisg-row']//div[contains(@class, 'puis-list-col-right')]//div/h2//span");
        this.first5SearchResultsLocatorForMultipleKeywordSearchString.add("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-6']//div[@class='puisg-row']//div[contains(@class, 'puis-list-col-right')]//div/h2//span");
        this.first5SearchResultsLocatorForMultipleKeywordSearchString.add("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-7']//div[@class='puisg-row']//div[contains(@class, 'puis-list-col-right')]//div/h2//span");
    }

    public List<WebElement> getAutosuggestionsLocatorForValidSearchString() {
        return this.webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='left-pane-results-container']//div/span")));
    }

    public WebElement getStartSearchButton() {
        return this.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#nav-search-submit-button")));
    }

    public String getInvalidSearchString() {
        return invalidSearchString;
    }

    public List<WebElement> getNoResutlsFoundTextLocator() {
        return noResutlsFoundTextLocator;
    }

    public void hoverSignInAccountsAndClickSignInButton() {
        Actions actions=new Actions(this.driver);
        actions.moveToElement(this.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Hello, sign in']")))).perform();
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

}
