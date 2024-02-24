package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LandingPageFactory {
    public static WebDriver driver=null;

    @FindBy(xpath="//span[text()='Hello, sign in']")
    private WebElement signInAccountsAndLinks;

    @FindBy(xpath="//a/span[text()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath="//div/input[@placeholder='Search Amazon.in']")
    private WebElement searchTextBox;

    @FindBy(xpath="//div//input[@type='submit']")
    private WebElement searchButton;

    public LandingPageFactory(WebDriver driver) {
        this.driver=driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public void hoverSignInAccountsAndClickSignInButton() {
        Actions actions=new Actions(this.driver);
        actions.moveToElement(signInAccountsAndLinks).perform();
        signInButton.click();
    }

}
