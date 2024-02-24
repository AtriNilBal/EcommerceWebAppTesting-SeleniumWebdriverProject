package page.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import page.CustomExceptions.PageNotDisplayedException;
import page.constants.ExpectedValues;

public class UserLoginTest {
    private static WebDriver chromeDriver;
    private static String baseUrl;

    public static void main(String[] args) throws InterruptedException {

        ExpectedValues expectedValues=new ExpectedValues();

        //Given user is on landing page
        baseUrl="https://www.amazon.in";
        //ChromeDriver chromeDriver=new ChromeDriver();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("useAutomationExtension", "False");
        chromeDriver=new ChromeDriver(options);
        chromeDriver.get(baseUrl);
        chromeDriver.manage().window().maximize();

        String landingPageActualTitle=chromeDriver.getTitle();
        System.out.println(landingPageActualTitle);
        if(landingPageActualTitle.contentEquals(ExpectedValues.LANDING_PAGE_TITLE_NEGATIVE_VALIDATION)) {
            try {
                throw new PageNotDisplayedException(ExpectedValues.PAGE_NOT_DISPLAYED_BOT_DETECTED_EXCEPTION_MESSAGE);
            } catch (PageNotDisplayedException e) {
                System.out.println(e.getMessage()+". Exiting program...!");
                chromeDriver.quit();
                System.exit(1);
            }
        }
        Thread.sleep(2000);

        //And user hovers over Accounts & links
        WebElement signInAccountsAndLink=chromeDriver.findElement(By.xpath("//span[text()='Hello, sign in']"));
        Actions actions=new Actions(chromeDriver);
        actions.moveToElement(signInAccountsAndLink).perform();
        Thread.sleep(2000);

        //Then Sign-In pane should be displayed for the user to navigate to Sign in page
        WebElement signInLink=chromeDriver.findElement(By.xpath("//a/span[text()='Sign in']"));
        //When user clicks on Sign-link
        signInLink.click();
        //Then Sign In page should be displayed
        String signInPageActualTitle=chromeDriver.getTitle();
        System.out.println(signInPageActualTitle);
        Thread.sleep(2000);

        WebElement emailTextBox=chromeDriver.findElement(By.xpath("//div/input[@name='email']"));
        emailTextBox.sendKeys("...enter username here...");
        WebElement submitButton=chromeDriver.findElement(By.xpath("//span/input[@type='submit']"));
        submitButton.click();
        WebElement passwordTextBox=chromeDriver.findElement(By.xpath("//div/input[@name='password']"));
        passwordTextBox.sendKeys("...enter password here...");
        WebElement signInButton=chromeDriver.findElement(By.xpath("//span/input[@id='signInSubmit']"));
        signInButton.click();
        String homePageActualTitle=chromeDriver.getTitle();
        System.out.println(homePageActualTitle);
        if(homePageActualTitle.contentEquals(ExpectedValues.USER_LANDING_PAGE_TITLE_NEGATIVE_VALIDATION)) {
            try {
                throw new PageNotDisplayedException(ExpectedValues.PAGE_NOT_DISPLAYED_BOT_DETECTED_EXCEPTION_MESSAGE);
            } catch(PageNotDisplayedException e) {
                System.out.println(e.getMessage()+". Exiting program...!");
                chromeDriver.quit(); System.exit(1);
            }
        }

        Thread.sleep(2000);

        chromeDriver.quit();
    }
}
