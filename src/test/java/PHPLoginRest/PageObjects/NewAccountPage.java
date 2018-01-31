package PHPLoginRest.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage {

    WebDriver driver;

    @FindBy(id = "username")
    @CacheLookup
    private WebElement username;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "pw_rpt")
    @CacheLookup
    private WebElement repeatPassword;


    @FindBy(xpath = "/html/body/main/center/div[3]/div/form/center/div/button")
    private WebElement registerButton;

    @FindBy(xpath = "/html/body/main/center/div[3]/div/form/center/div/a/button")
    private WebElement cancelButton;

    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public LoginPage createAccount(String username, String password){
        clearUsername();
        clearPassword();
        clearRepeatPassword();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.repeatPassword.sendKeys(password);
        this.repeatPassword.submit();
        return new LoginPage(driver);
    }

    public LoginPage createAccount(String username, String password, String repeatPassword){
        clearUsername();
        clearPassword();
        clearRepeatPassword();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.repeatPassword.sendKeys(repeatPassword);
        this.repeatPassword.submit();
        return new LoginPage(driver);
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

    public void writeRepeatPassword(String password){
        this.repeatPassword.sendKeys(password);
    }

    public void clearRepeatPassword(){
        this.repeatPassword.clear();
    }


    public LoginPage submit(){
        this.registerButton.click();
        return new LoginPage(driver);
    }

    public LoginPage cancel() {
        this.cancelButton.click();
        return new LoginPage(driver);
    }

}
