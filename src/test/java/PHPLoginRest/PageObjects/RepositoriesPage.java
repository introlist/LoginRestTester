package PHPLoginRest.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.rmi.runtime.Log;

public class RepositoriesPage {

    WebDriver driver;


    @FindBy(xpath = "//*[@id=\"acc\"]/div/input")
    private WebElement areasCombo;

    @FindBy(xpath = "//*[@id=\"ccc\"]/div/input")
    private WebElement camposCombo;

    @FindBy(xpath = "//*[@id=\"dcc\"]/div/input")
    private WebElement disciplinasCombo;

    @FindBy(xpath = "//*[@id=\"acc\"]/div/input")
    private WebElement subdisciplinasCombo;

    @FindBy(xpath = "//*[@id=\"nav-mobile\"]/li[4]/a")
    private WebElement logout;
    public LoginPage logout(){
        this.logout.click();
        return new LoginPage(driver);
    }

    private WebDriverWait wait;

    public RepositoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,30);
    }


    public void openAreas(){
        this.areasCombo.click();
    }

    public void openCampos(){
        this.camposCombo.click();
    }

    public void openDisciplinas(){
        this.disciplinasCombo.click();
    }

    public void openSubdisciplinas(){
        this.subdisciplinasCombo.click();
    }

    public void selectArea(String item){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"acc\"]//li/span[contains(text(), '"+item+"')]"))).click();
    }
    public void selectCampo(String item){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ccc\"]//li/span[contains(text(), '"+item+"')]"))).click();
    }
    public void selectDisciplina(String item){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dcc\"]//li/span[contains(text(), '"+item+"')]"))).click();
    }
    public void selectSubdisciplina(String item){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"scc\"]//li/span[contains(text(), '"+item+"')]"))).click();
    }
}
