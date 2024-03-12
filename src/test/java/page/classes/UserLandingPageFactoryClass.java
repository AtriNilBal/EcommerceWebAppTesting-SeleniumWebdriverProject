package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserLandingPageFactoryClass {

    private WebDriver driver=null;

    @FindBy(xpath="//a/span[text()='Account & Lists']")
    public WebElement userSignInAccountsAndLinks;

    @FindBy(xpath="//a/span[text()='Sign Out']")
    public WebElement signOutLink;

    public UserLandingPageFactoryClass(WebDriver driver) {
        this.driver=driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(this.driver, this);
    }

    public void hoverOnUserSignInAccountsAndLinksAndClickSignOut() {
        Actions actions=new Actions(this.driver);
        actions.moveToElement(userSignInAccountsAndLinks).perform();
        WebDriverWait webDriverWait=new WebDriverWait(this.driver, Duration.ofSeconds(5000));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(signOutLink));
        signOutLink.click();
    }
}
