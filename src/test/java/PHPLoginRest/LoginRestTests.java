package PHPLoginRest;


import PHPLoginRest.PageObjects.LoginPage;
import PHPLoginRest.PageObjects.NewAccountPage;
import PHPLoginRest.PageObjects.RepositoriesPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LoginRestTests {

    private WebDriver driver;
    private String baseUrl;
    private LoginPage loginPage;
    private NewAccountPage newAccountPage;
    private RepositoriesPage repositoriesPage;

    private String testTimeText;
    @Before
    public void setUp(){
        Date testTime = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat ("yyMMddHHmm");
         driver = new FirefoxDriver();
        baseUrl = "http://localhost/PHPLoginRest";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        testTimeText = ft.format(testTime);
    }

    @Test
    public void fallarLogin(){
        try{
            repositoriesPage = loginPage.login("NoUser","NoPassword");
            repositoriesPage.logout();
            Assert.fail("Excepción no lanzada");
        }catch (Exception e){
            System.out.println(e);
            Assert.assertTrue(!e.toString().equals(""));
        }
    }

    @Test
    public void crearUsuario(){
        newAccountPage = loginPage.ClickCreateAccount();
        newAccountPage.createAccount(testTimeText,testTimeText);
    }

    @Test
    public void Login(){
        repositoriesPage = loginPage.login("admin","admin");
         loginPage =  repositoriesPage.logout();
         loginPage.writeUsername("Test Sucess");
    }

    @After
    public void tearDown() throws Exception{
        System.out.println("Todos las pruebas terminadas");
        Thread.sleep(2000);
        driver.quit();
    }
}
