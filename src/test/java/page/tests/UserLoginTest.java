package page.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserLoginTest {
    private static WebDriver driver;
    private static String baseUrl;

    public static void main(String[] args) throws InterruptedException {
        driver=new ChromeDriver();
        baseUrl="https://www.amazon.in";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.quit();

    }
}
