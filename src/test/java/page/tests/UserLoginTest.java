package page.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import page.CustomExceptions.PageNotDisplayedException;

public class UserLoginTest {
    private static WebDriver driver;
    private static String baseUrl;

    public static void main(String[] args) throws InterruptedException {

        //Given user is on landing page
        baseUrl="https://www.amazon.in";
        ChromeDriver chromeDriver=new ChromeDriver();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        chromeDriver.get(baseUrl);
        chromeDriver.manage().window().maximize();
        System.out.println(chromeDriver.getTitle());

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
        System.out.println(chromeDriver.getTitle());

        chromeDriver.quit();
    }
}
