package page.tests;

import org.openqa.selenium.WebDriver;
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

public class UserLoginLogoutJourneyTestNgTestsOnChrome {
    private WebDriver webDriver;
    private LandingPageFactory landingPageFactory;
    private LoginPageFactory loginPageFactory;
    private UserLandingPageFactoryClass userLandingPageFactoryClass;

    @BeforeClass
    public void setup() {
        webDriver=new ChromeDriver(CommonMethods.disableAutomatedTestsFlagInChrome());
        webDriver.get(ExpectedValues.BASE_URL);
        webDriver.manage().window().maximize();
        landingPageFactory=new LandingPageFactory(webDriver);
        loginPageFactory=new LoginPageFactory(webDriver);
        userLandingPageFactoryClass=new UserLandingPageFactoryClass(webDriver);
    }

    @Test
    public void test() {
        //validation for page title
        //throw exception and exit code-block if error
        if(webDriver.getTitle().contentEquals(ExpectedValues.LANDING_PAGE_EXPECTED_TITLE)) {
            System.out.println("User is in Landing page");
        } else {
            throwException();
        }

        landingPageFactory.hoverSignInAccountsAndClickSignInButton();

        if (webDriver.getTitle().contentEquals(ExpectedValues.SIGN_IN_PAGE_EXPECTED_TITLE)) {
            System.out.println("User is in sign in page");
        } else {
            throwException();
        }

        loginPageFactory.userInputToUsernameTextBox(ExpectedValues.USER_LOGIN_USERNAME);
        loginPageFactory.clickUserNameSubmitButton();
        loginPageFactory.userInputToPasswordTextBox(ExpectedValues.USER_LOGIN_PASSWORD);
        loginPageFactory.clickSignInButton();
        if (webDriver.getTitle().contentEquals(ExpectedValues.SIGN_IN_PAGE_EXPECTED_TITLE)) {
            System.out.println("User has logged into own account");
        } else {
            throwException();
        }
        System.out.println(webDriver.getTitle());
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
            System.out.print(e.getMessage());
            System.out.println("Exiting tests...!");
        }
    }
}
