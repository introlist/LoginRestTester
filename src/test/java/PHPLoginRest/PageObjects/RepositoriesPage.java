package PHPLoginRest.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.rmi.runtime.Log;

import java.util.List;

public class RepositoriesPage {

    WebDriver driver;


    @FindBy(xpath = "//*[@id=\"acc\"]/div/input")
    private WebElement areasCombo;

    @FindBy(xpath = "//*[@id=\"ccc\"]/div/input")
    private WebElement camposCombo;

    @FindBy(xpath = "//*[@id=\"dcc\"]/div/input")
    private WebElement disciplinasCombo;

    @FindBy(xpath = "//*[@id=\"scc\"]/div/input")
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
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public void openAreas(){
        wait.until(ExpectedConditions.elementToBeClickable(this.areasCombo)) .click();
    }

    public void openCampos(){
        wait.until(ExpectedConditions.elementToBeClickable(this.camposCombo)) .click();
    }

    public void openDisciplinas(){
        wait.until(ExpectedConditions.elementToBeClickable(this.disciplinasCombo)) .click();
    }

    public void openSubdisciplinas(){
        wait.until(ExpectedConditions.elementToBeClickable(this.subdisciplinasCombo)) .click();
    }

    public void selectArea(String item) throws Exception{
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"acc\"]//li/span[contains(text(), '"+item+"')]"))).click();
/*        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"acc\"]//li/span"));
        dropdownSelect(elements,item);*/
        Thread.sleep(1000);
    }
    public void selectCampo(String item) throws Exception{
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ccc\"]//li/span[contains(text(), '"+item+"')]"))).click();
/*        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"ccc\"]//li/span"));
        dropdownSelect(elements,item);*/
        Thread.sleep(1000);
    }
    public void selectDisciplina(String item)throws Exception{
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dcc\"]//li/span[contains(text(), '"+item+"')]"))).click();
/*        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"dcc\"]//li/span"));
        dropdownSelect(elements,item);*/
        Thread.sleep(1000);
    }
    public void selectSubdisciplina(String item)throws Exception{
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"scc\"]//li/span[contains(text(), '"+item+"')]"))).click();
/*        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"scc\"]//li/span"));
        dropdownSelect(elements,item);*/
        Thread.sleep(1000);
    }


    private void dropdownSelect(List<WebElement> elements, String item){
        for(WebElement element : elements) {
            new Actions(driver).sendKeys(Keys.ARROW_DOWN).perform();
            if(element.getText().equals(item)){
                element.click();
                break;
            }
        }
    }
}
