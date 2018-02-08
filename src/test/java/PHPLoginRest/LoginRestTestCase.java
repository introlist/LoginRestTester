package PHPLoginRest;


import PHPLoginRest.PageObjects.LoginPage;
import PHPLoginRest.PageObjects.NewAccountPage;
import PHPLoginRest.PageObjects.RepositoriesPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LoginRestTestCase {

    private WebDriver driver;
    private String baseUrl;
    private LoginPage loginPage;
    private NewAccountPage newAccountPage;
    private RepositoriesPage repositoriesPage;

    private String testTimeText;
    @Before
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("no-sandbox");
        driver = new ChromeDriver(chromeOptions);
        baseUrl = "http://localhost:8081/PHPLoginRest";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        Date testTime = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat ("yyMMddHHmm");

        testTimeText = ft.format(testTime);
    }

   @Test
    public void fallarLogin(){
        try{
            repositoriesPage = loginPage.login("NoUser","NoPassword");
            loginPage = repositoriesPage.logout();
            Assert.fail("Excepción no lanzada");
        }catch (Exception e){
            System.out.println(e);
            System.out.println("-----\nSe esperaba esta excepcion\n-----");
            Assert.assertTrue(!e.toString().equals(""));
        }
    }


   @Test
    public void repetirUsuarioCreado(){
            newAccountPage = loginPage.ClickCreateAccount();
            loginPage = newAccountPage.createAccount("roberto", "r27101995", "r27101995");
            if (driver.getCurrentUrl().contains("index.php")){
                Assert.fail("Operación invalida.");
            }
    }

    @Test
    public void crearUsuario(){
        newAccountPage = loginPage.ClickCreateAccount();
        newAccountPage.createAccount(testTimeText,testTimeText);
    }

  @Test
    public void Login() throws Exception{
        repositoriesPage = loginPage.login("admin","admin");
         loginPage =  repositoriesPage.logout();
         loginPage.writeUsername("Test Sucess");
    }

    @Test
    public void FiltraAutomatizacion() throws Exception{
        repositoriesPage = loginPage.login("admin","admin");
        repositoriesPage.openAreas();
        repositoriesPage.selectArea("INGENIERÍA Y TECNOLOGÍA");
        repositoriesPage.openCampos();
        repositoriesPage.selectCampo("CIENCIAS TECNOLÓGICAS");
        repositoriesPage.openDisciplinas();
        repositoriesPage.selectDisciplina("TECNOLOGÍA DE LOS ORDENADORES");
        repositoriesPage.openSubdisciplinas();
        repositoriesPage.selectSubdisciplina("SISTEMAS AUTOMATIZADOS DE CONTROL DE CALIDAD");
    }

    @Test
    public void buscarUnArea() throws Exception{
        repositoriesPage = loginPage.login("admin","admin");
        repositoriesPage.openAreas();
        repositoriesPage.selectArea("INGENIERÍA Y TECNOLOGÍA");
    }

    @Test
    public void buscarAreaCienciasSociales() throws Exception{
        repositoriesPage = loginPage.login("admin","admin");
        repositoriesPage.openAreas();
        repositoriesPage.selectArea("CIENCIAS SOCIALES");
    }

    @Test
    public void FiltradoCompleto() throws Exception{
        repositoriesPage = loginPage.login("admin","admin");
        repositoriesPage.openAreas();
        repositoriesPage.selectArea("CIENCIAS FÍSICO MATEMÁTICAS Y CIENCIAS DE LA TIERRA");
        repositoriesPage.openCampos();
        repositoriesPage.selectCampo("CIENCIAS DE LA TIERRA Y DEL ESPACIO");
        repositoriesPage.openDisciplinas();
        repositoriesPage.selectDisciplina("OTRAS ESPECIALIDADES DE LA TIERRA, ESPACIO O ENTORNO");
        repositoriesPage.openSubdisciplinas();
        repositoriesPage.selectSubdisciplina("OTRAS");
    }


    @After
    public void tearDown() throws Exception{
        System.out.println("Prueba terminada");
        driver.quit();
    }
}
