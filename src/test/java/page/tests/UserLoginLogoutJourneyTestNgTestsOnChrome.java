package page.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.CustomExceptions.PageNotDisplayedException;
import page.classes.CommonMethods;
import page.classes.LandingPageFactory;
import page.classes.LoginPageFactory;
import page.classes.UserLandingPageFactoryClass;
import page.constants.ExpectedValues;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;

public class UserLoginLogoutJourneyTestNgTestsOnChrome {
    private WebDriver webDriver;
    private LandingPageFactory landingPageFactory;
    private LoginPageFactory loginPageFactory;
    private UserLandingPageFactoryClass userLandingPageFactoryClass;
    private final Logger LOGGER = LogManager.getLogger(UserLoginLogoutJourneyTestNgTestsOnChrome.class.getName());

    @BeforeClass
    public void setup() {
        webDriver=new ChromeDriver(CommonMethods.disableAutomatedTestsFlagInChrome());
        webDriver.get(ExpectedValues.BASE_URL);
        webDriver.manage().window().maximize();
        landingPageFactory=new LandingPageFactory(webDriver);
        loginPageFactory=new LoginPageFactory(webDriver);
        userLandingPageFactoryClass=new UserLandingPageFactoryClass(webDriver);
    }

    @Test(priority=1)
    public void navigateBackToLandingPage() {
        var navigateToLandingPage = landingPageFactory.getNavigteToLandingPageByAmazonLogoNav();
        navigateToLandingPage.click();
    }

    @Test(priority=0)
    public void changeLanguage() {
        var changeLanguageLink = landingPageFactory.getChangeLanguageLink();
        changeLanguageLink.click();
        List<WebElement> languageOptionsList = new ArrayList<>();
        languageOptionsList = landingPageFactory.getLanguageOptions();

        for(int i=0; i<languageOptionsList.size(); i++) {
            var currentLanguageOption = languageOptionsList.get(i);
            currentLanguageOption.click();
            LOGGER.info("clicked on %d language option ", i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            var saveSelectionLanguage = landingPageFactory.getSaveLanguageOption();
            try {
                saveSelectionLanguage.click();
                LOGGER.info("saved language option %d", i);
            } catch(NoSuchElementException e) {
                LOGGER.warn("could not save language option %d", i);
                landingPageFactory.getChangeLanguageLink().click();
                languageOptionsList = landingPageFactory.getLanguageOptions();
                LOGGER.info("Decrementing counter %d to re-run current iteration and reattempt saving current language option", i);
                continue;
            }

        }
    }

    @Test
    public void test1() {
        //validation for page title
        //throw exception and exit code-block if error
        if(webDriver.getTitle().contentEquals(ExpectedValues.LANDING_PAGE_EXPECTED_TITLE)) {
            LOGGER.info("User is in Landing page");
        } else {
            throwException();
        }

        landingPageFactory.hoverSignInAccountsAndClickSignInButton();

        if (webDriver.getTitle().contentEquals(ExpectedValues.SIGN_IN_PAGE_EXPECTED_TITLE)) {
            LOGGER.info("User is in sign in page");
        } else {
            throwException();
        }

        loginPageFactory.userInputToUsernameTextBox(ExpectedValues.USER_LOGIN_USERNAME);
        loginPageFactory.clickUserNameSubmitButton();
        loginPageFactory.userInputToPasswordTextBox(ExpectedValues.USER_LOGIN_PASSWORD);
        loginPageFactory.clickSignInButton();
        if (webDriver.getTitle().contentEquals(ExpectedValues.SIGN_IN_PAGE_EXPECTED_TITLE)) {
            LOGGER.info("User has logged into own account");
        } else {
            throwException();
        }
        LOGGER.info(webDriver.getTitle());
        userLandingPageFactoryClass.hoverOnUserSignInAccountsAndLinksAndClickSignOut();
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }

    public void throwException() {
        try{
            throw new PageNotDisplayedException(ExpectedValues.PAGE_NOT_DISPLAYED_BOT_DETECTED_EXCEPTION_MESSAGE);
        } catch(PageNotDisplayedException e) {
            LOGGER.info(e.getMessage());
            LOGGER.info("Exiting tests...!");
        }
    }
}
