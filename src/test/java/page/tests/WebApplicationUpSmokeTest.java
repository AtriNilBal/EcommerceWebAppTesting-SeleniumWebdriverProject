package page.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.classes.CommonMethods;
import page.constants.ExpectedValues;

public class WebApplicationUpSmokeTest {

    private WebDriver webDriver;
    private static final Logger LOGGER = LogManager.getLogger(WebApplicationUpSmokeTest.class.getName());

    @Test(priority=0)
    public void testOnChrome() {
        webDriver = new ChromeDriver(CommonMethods.disableAutomatedTestsFlagInChromeHeadless());
        String pageTitle = commonWebdriverAction(webDriver, ExpectedValues.BASE_URL);
        Assert.assertEquals(pageTitle, ExpectedValues.LANDING_PAGE_EXPECTED_TITLE);
    }

    @Test(priority=1)
    public void testOnFirefox() {
        webDriver = new FirefoxDriver(CommonMethods.firefoxHeadless());
        String pageTitle = commonWebdriverAction(webDriver, ExpectedValues.BASE_URL);
        Assert.assertEquals(pageTitle, ExpectedValues.LANDING_PAGE_EXPECTED_TITLE);
    }

    @Test(priority=2)
    public void testOnEdge() {
        webDriver = new EdgeDriver(CommonMethods.edgeHeadless());
        String pageTitle = commonWebdriverAction(webDriver, ExpectedValues.BASE_URL);
        Assert.assertEquals(pageTitle, ExpectedValues.LANDING_PAGE_EXPECTED_TITLE);
    }

    private String commonWebdriverAction(WebDriver wedDriver, String url) {
        webDriver.get(url);
        webDriver.manage().window().maximize();
        LOGGER.info(webDriver.getTitle());
        return webDriver.getTitle();
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
