package page.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.classes.CommonMethods;
import page.classes.LandingPageFactory;
import page.classes.LoginPageFactory;
import page.classes.UserLandingPageFactoryClass;
import page.constants.ExpectedValues;

public class UserLoginTestNgTestsOnFirefox {

    private WebDriver webdriver;
    private LandingPageFactory landingPageFactory;
    private LoginPageFactory loginPageFactory;
    private UserLandingPageFactoryClass userLandingPageFactoryClass;

    @BeforeClass
    public void setup() {
        //webdriver=new FirefoxDriver(CommonMethods.disableAutomatedTestsFlagInFirefox());
        webdriver=new FirefoxDriver();
        webdriver.get(ExpectedValues.BASE_URL);
        webdriver.manage().window().maximize();
        landingPageFactory=new LandingPageFactory(webdriver);
        loginPageFactory=new LoginPageFactory(webdriver);
        userLandingPageFactoryClass=new UserLandingPageFactoryClass(webdriver);
    }

    @Test
    public void test() {
        landingPageFactory.hoverSignInAccountsAndClickSignInButton();
        loginPageFactory.userInputToUsernameTextBox(ExpectedValues.USER_LOGIN_USERNAME);
        loginPageFactory.clickUserNameSubmitButton();
        loginPageFactory.userInputToPasswordTextBox(ExpectedValues.USER_LOGIN_PASSWORD);
        loginPageFactory.clickSignInButton();
        userLandingPageFactoryClass.hoverOnUserSignInAccountsAndLinksAndClickSignOut();
    }

    @AfterClass
    public void tearDown() {
        webdriver.quit();
    }
}
