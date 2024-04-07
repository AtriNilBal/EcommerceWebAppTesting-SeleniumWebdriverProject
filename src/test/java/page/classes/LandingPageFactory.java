package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    @FindBy(css="span[class='nav-line-2']")
    private WebElement changeLanguageLink;

    @FindBy(css="#icp-language-settings>div[class='a-row a-spacing-mini']")
    private List<WebElement> languageOptions;

    @FindBy(css="input[class='a-button-input']")
    private WebElement saveLanguageOption;

    @FindBy(css="#nav-logo-sprites")
    private WebElement navigteToLandingPageByAmazonLogoNav;

    public LandingPageFactory(WebDriver driver) {
        this.driver=driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public WebElement getSignInAccountsAndLinks() {
        return signInAccountsAndLinks;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public List<WebElement> getLanguageOptions() {
        return languageOptions;
    }

    public WebElement getSearchTextBox() {
        return searchTextBox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getChangeLanguageLink() {
        return changeLanguageLink;
    }

    public WebElement getSaveLanguageOption() {
        return saveLanguageOption;
    }

    public WebElement getNavigteToLandingPageByAmazonLogoNav() {
        return navigteToLandingPageByAmazonLogoNav;
    }

    public void hoverSignInAccountsAndClickSignInButton() {
        Actions actions=new Actions(this.driver);
        actions.moveToElement(signInAccountsAndLinks).perform();
        WebDriverWait webDriverWait=new WebDriverWait(this.driver, Duration.ofSeconds(5000));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

}
