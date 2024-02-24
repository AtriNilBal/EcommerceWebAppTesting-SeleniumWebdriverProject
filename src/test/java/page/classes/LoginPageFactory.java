package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    public WebDriver driver=null;

    @FindBy(xpath = "//div/input[@name='email']")
    private WebElement usernameTextBox;

    @FindBy(xpath="//span/input[@type='submit']")
    private WebElement userNameSubmitButton;

    @FindBy(xpath="//div/input[@name='password']")
    private WebElement passwordTextBox;

    @FindBy(xpath="//span/input[@id='signInSubmit']")
    private WebElement signInButton;

    public void userInputToUsernameTextBox(String userName) {
        usernameTextBox.sendKeys(userName);
    }

    public void clickUserNameSubmitButton() {
        userNameSubmitButton.click();
    }

    public void userInputToPasswordTextBox(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public LoginPageFactory(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
