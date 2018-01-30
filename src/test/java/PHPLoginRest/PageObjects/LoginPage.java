package PHPLoginRest.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "username")
    @CacheLookup
    private WebElement username;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement password;

    @FindBy(name = "btn_login")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/main/center/a")
    private WebElement createAccountLink;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RepositoriesPage login(String username, String password){
        clearUsername();
        clearPassword();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.password.submit();
        return new RepositoriesPage(driver);
    }

    public void writeUsername(String username){
        this.username.sendKeys(username);
    }

    public void clearUsername(){
        this.username.clear();
    }

    public void writePassword(String password){
        this.password.sendKeys(password);
    }

    public void clearPassword(){
        this.password.clear();
    }

    public void submit(){
        this.loginButton.click();
    }

    public NewAccountPage ClickCreateAccount(){
        createAccountLink.click();
        return new NewAccountPage(driver);
    }

}
