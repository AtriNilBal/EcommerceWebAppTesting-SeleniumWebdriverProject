package page.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.classes.CommonMethods;
import page.classes.LandingPageFactory;
import page.classes.LoginPageFactory;
import page.classes.UserLandingPageFactoryClass;
import page.constants.ExpectedValues;

public class UserLoginTestNgTestsOnEdge {
    private WebDriver webDriver;
    private LandingPageFactory landingPageFactory;
    private LoginPageFactory loginPageFactory;
    private UserLandingPageFactoryClass userLandingPageFactoryClass;

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
        landingPageFactory.hoverSignInAccountsAndClickSignInButton();
        loginPageFactory.userInputToUsernameTextBox(ExpectedValues.USER_LOGIN_USERNAME);
        loginPageFactory.clickUserNameSubmitButton();
        loginPageFactory.userInputToPasswordTextBox(ExpectedValues.USER_LOGIN_PASSWORD);
        loginPageFactory.clickSignInButton();
        userLandingPageFactoryClass.hoverOnUserSignInAccountsAndLinksAndClickSignOut();
    }

    @AfterClass
    private void tearDown() {
        webDriver.quit();
    }
}
