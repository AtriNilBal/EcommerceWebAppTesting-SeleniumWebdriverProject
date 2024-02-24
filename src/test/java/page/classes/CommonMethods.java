package page.classes;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class CommonMethods {

    public static ChromeOptions disableAutomatedTestsFlagInChrome() {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("useAutomationExtension", "False");
        options.addArguments("dom.webdriver.enabled", "False");
        return options;
    }

    public static FirefoxOptions disableAutomatedTestsFlagInFirefox() {
        FirefoxOptions options=new FirefoxOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("useAutomationExtension", "False");
        //options.addArguments("dom.webdriver.enabled", "False");
        return options;
    }

    public static EdgeOptions disableAutomatedTestsFlagInEdge() {
        EdgeOptions options=new EdgeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("useAutomationExtension", "False");
        options.addArguments("dom.webdriver.enabled", "False");
        return options;
    }

    /*public static SafariOptions disableAutomatedTestsFlagInSafari() {
        SafariOptions options=new SafariOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("useAutomationExtension", "False");
        return options;
    }*/
}
