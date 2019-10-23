package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Web;
import static org.junit.Assert.*;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = {"src/test/java/resources/InformacoesUsuarioTestData.csv"})
public class APICoursePageTests {

    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome("https://www.ministryoftesting.com/dojo/series/let-s-build-an-api-checking-framework-mark-winteringham");

    }

    @Test
    public void testLogin(@Param(name="user")String user, @Param(name="password")String password,@Param(name="alertType")String alertType, @Param(name="expectedMessage")String expectedMessage){

        navegador.findElement(By.linkText("Sign In")).click();
        navegador.findElement(By.id("user_login")).sendKeys(user);
        navegador.findElement(By.id("user_password")).sendKeys(password);
        navegador.findElement(By.name("commit")).click();
        WebElement successNotice = navegador.findElement(By.id(alertType));
        assertEquals(expectedMessage,successNotice.getText());

    }


    @Test
    public void test1SignOut(){

        navegador.findElement(By.linkText("Sign In")).click();
        navegador.findElement(By.id("user_login")).sendKeys("marcelopv");
        navegador.findElement(By.id("user_password")).sendKeys("Marcelo3641*");
        navegador.findElement(By.name("commit")).click();
        navegador.findElement(By.linkText("Account")).click();
        navegador.findElement(By.linkText("Sign Out")).click();

        WebElement successNotice = navegador.findElement(By.id("flash_notice"));
        String txt = "Signed out successfully.";
        assertEquals(txt,successNotice.getText());
    }


    @After
    public void tearDown() {
        // Fechar o navegador
        navegador.quit();
    }
}
