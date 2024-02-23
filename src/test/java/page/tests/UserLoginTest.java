package page.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UserLoginTest {
    private static WebDriver driver;
    private static String baseUrl;

    public static void main(String[] args) throws InterruptedException {
        baseUrl="https://www.amazon.in";
        ChromeDriver chromeDriver=new ChromeDriver();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        chromeDriver.get(baseUrl);
        chromeDriver.manage().window().maximize();
        System.out.println(chromeDriver.getTitle());
        Thread.sleep(2000);
        chromeDriver.quit();

    }
}
