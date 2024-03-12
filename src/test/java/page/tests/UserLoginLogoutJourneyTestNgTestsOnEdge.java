package page.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.CustomExceptions.PageNotDisplayedException;
import page.classes.CommonMethods;
import page.classes.LandingPageFactory;
import page.classes.LoginPageFactory;
import page.classes.UserLandingPageFactoryClass;
import page.constants.ExpectedValues;

import java.time.Duration;

public class UserLoginLogoutJourneyTestNgTestsOnEdge {
    private WebDriver webDriver;
    private LandingPageFactory landingPageFactory;
    private LoginPageFactory loginPageFactory;
    private UserLandingPageFactoryClass userLandingPageFactoryClass;

    private static final Logger LOGGER = LogManager.getLogger(UserLoginLogoutJourneyTestNgTestsOnEdge.class.getName());

    @BeforeClass
    private void setUp() {
        webDriver=new EdgeDriver(CommonMethods.disableAutomatedTestsFlagInEdge());
        webDriver.manage().window().maximize();
        landingPageFactory=new LandingPageFactory(webDriver);
        loginPageFactory=new LoginPageFactory(webDriver);
        userLandingPageFactoryClass=new UserLandingPageFactoryClass(webDriver);
    }

    @Test
    private void test() {
        webDriver.get(ExpectedValues.BASE_URL);
        LOGGER.info("========================USER JOURNEY:IN LANDING PAGE========================");
        if(webDriver.getTitle().contentEquals(ExpectedValues.LANDING_PAGE_EXPECTED_TITLE)) {
            LOGGER.info("------------------------User is in Landing page");
        } else {
            if(!(userInterventionWithWait(10, ExpectedValues.LANDING_PAGE_EXPECTED_TITLE))) {
                throwException();
            }
        }

        LOGGER.info("========================USER JOURNEY:TO SIGNIN PAGE========================");
        landingPageFactory.hoverSignInAccountsAndClickSignInButton();
        if (webDriver.getTitle().contentEquals(ExpectedValues.SIGN_IN_PAGE_EXPECTED_TITLE)) {
            LOGGER.info("------------------------User is in sign in page");
        } else {
            if(!(userInterventionWithWait(10, ExpectedValues.SIGN_IN_PAGE_EXPECTED_TITLE))) {
                throwException();
            }
        }

        LOGGER.info("========================USER JOURNEY:ENTER USERNAME PAGE========================");
        loginPageFactory.userInputToUsernameTextBox(ExpectedValues.USER_LOGIN_USERNAME);
        loginPageFactory.clickUserNameSubmitButton();
        LOGGER.info("========================USER JOURNEY:ENTER PASSWORD PAGE========================");
        loginPageFactory.userInputToPasswordTextBox(ExpectedValues.USER_LOGIN_PASSWORD);
        loginPageFactory.clickSignInButton();

        LOGGER.info("========================USER JOURNEY:USER HAS LOGGED IN AND IS AT LANDING PAGE========================");
        if (webDriver.getTitle().contentEquals(ExpectedValues.LANDING_PAGE_EXPECTED_TITLE)) {
            LOGGER.info("------------------------User has logged into own account");
        } else {
            if(!(userInterventionWithWait(10, ExpectedValues.LANDING_PAGE_EXPECTED_TITLE))) {
                throwException();
            }
        }

        LOGGER.info("========================USER JOURNEY:USER LOGOUT========================");
        userLandingPageFactoryClass.hoverOnUserSignInAccountsAndLinksAndClickSignOut();
    }

    @AfterClass
    private void tearDown() {
        webDriver.quit();
    }

    public void throwException() {
        try{
            LOGGER.info(webDriver.getTitle());
            throw new PageNotDisplayedException(ExpectedValues.PAGE_NOT_DISPLAYED_BOT_DETECTED_EXCEPTION_MESSAGE);
        } catch(PageNotDisplayedException e) {
            LOGGER.error(e.getMessage()+"\t");
            LOGGER.info("Exiting tests...!");
        }
    }

    public boolean userInterventionWithWait(int waitTime, String expectedPageTitle) {
        LOGGER.info("------------------------User landed in different page !!! Title - {}", webDriver.getTitle());
        LOGGER.debug("------------------------Waiting for manual intervention");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(expectedPageTitle));
        return true;
    }
}
