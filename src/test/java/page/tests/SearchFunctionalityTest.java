package page.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.classes.CommonMethods;
import page.classes.LandingPageFactory;
import page.constants.ExpectedValues;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchFunctionalityTest {

    private static WebDriver webDriver;
    private LandingPageFactory landingPageFactory;
    private final Logger LOGGER = LogManager.getLogger(SearchFunctionalityTest.class.getName());

    @BeforeClass
    public void setup() {
        webDriver=new ChromeDriver(CommonMethods.disableAutomatedTestsFlagInChrome());
        webDriver.manage().window().maximize();
        landingPageFactory=new LandingPageFactory(webDriver);
    }

    @AfterClass
    public void testCleanup() {
        webDriver.quit();
    }

    @Test(priority = 1)
    public void searchWithValidSearchString() {
        this.webDriver.navigate().to(ExpectedValues.BASE_URL);
        landingPageFactory.getSearchTextBox().sendKeys(landingPageFactory.getValidSearchString());
        landingPageFactory.getStartSearchButton().click();
        List<String> searchResultsLocatorString = new ArrayList<>();
        searchResultsLocatorString = landingPageFactory.getSearchResultLocatorSearchString();
        for(String searchResultLocator : searchResultsLocatorString) {
            System.out.println(this.webDriver.findElement(By.xpath(searchResultLocator)).getText());
            //put the results in a list and assert by string contains the search string given in the search-results text
        }
    }

    @Test(priority = 1)
    public void searchWithInvalidSearchString() {
        this.webDriver.navigate().to(ExpectedValues.BASE_URL);
        landingPageFactory.getSearchTextBox().sendKeys(landingPageFactory.getInvalidSearchString());
        landingPageFactory.getStartSearchButton().click();
        List<WebElement> noResultsFoundLocator = new ArrayList<>();
        noResultsFoundLocator = landingPageFactory.getNoResutlsFoundTextLocator();
        for(WebElement element:noResultsFoundLocator) {
            System.out.println(element.getText());
        }
    }

    @Test(priority = 1)
    public void searchWithSpecialCharacters() {
        String specialCharacterSearchString = "**&&^^%%";
        this.webDriver.navigate().to(ExpectedValues.BASE_URL);
        landingPageFactory.getSearchTextBox().sendKeys(specialCharacterSearchString);
        landingPageFactory.getStartSearchButton().click();
    }

    //unstable tests fails with NoSuchElementException, no such element: Unable to locate element: {"method":"xpath","selector":"//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']//... at line marked ***
    @Test(priority = 0)
    public void searchWithMultipleKeywords() {
        String multipleKeyWordSearchString = "book mobile jacket";
        this.webDriver.navigate().to(ExpectedValues.BASE_URL);
        landingPageFactory.getSearchTextBox().sendKeys(multipleKeyWordSearchString);
        landingPageFactory.getStartSearchButton().click();
        landingPageFactory.setFirst5SearchResultsLocatorForMultipleKeywordSearchString();
        List<String> searchResultsLocatorString = new ArrayList<>();
        searchResultsLocatorString = landingPageFactory.getFirst5SearchResultsLocatorForMultipleKeywordSearchString();
        WebDriverWait webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(5000));
        for(String searchResultLocator : searchResultsLocatorString) {
            try {
                var currentSearchResult = this.webDriver.findElement(By.xpath(searchResultLocator));//***//
                //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchResultLocator)));
                System.out.println(currentSearchResult.getText());
                //put the results in a list and assert by string contains the search string given in the search-results text
            }catch(NoSuchElementException e) {
                System.out.printf("No search result found with locator %s \n", searchResultLocator);
                continue;
            }
        }
    }

    //unstable test, fails with stale element reference exception (stale element not found in the current frame) at line marked ***
    @Test(priority = 3)
    public void testAutoSuggestions() {
        String searchString = "intel";
        this.webDriver.navigate().to(ExpectedValues.BASE_URL);
        landingPageFactory.getSearchTextBox().sendKeys(searchString);
        //landingPageFactory.getStartSearchButton().click();
        //landingPageFactory.setFirst5SearchResultsLocatorForMultipleKeywordSearchString();
        List<WebElement> autoSuggestions = new ArrayList<>();
        autoSuggestions = landingPageFactory.getAutosuggestionsLocatorForValidSearchString();
        for(WebElement currentSuggestion : autoSuggestions) {
            System.out.println(currentSuggestion.getText());//***//
        }
    }
}
