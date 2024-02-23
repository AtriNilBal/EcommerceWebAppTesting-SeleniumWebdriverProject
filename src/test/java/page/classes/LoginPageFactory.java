package page.classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory {
    public static WebElement element=null;

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
}
