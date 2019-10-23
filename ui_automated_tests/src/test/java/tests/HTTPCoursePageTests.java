package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Web;
import static org.junit.Assert.*;

public class HTTPCoursePageTests {

    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome("https://www.ministryoftesting.com/dojo/series/introduction-to-http");
    }

    @Test
    public void testValidSign(){

        navegador.findElement(By.linkText("Sign In")).click();
        navegador.findElement(By.id("user_login")).sendKeys("marcelopv");
        navegador.findElement(By.id("user_password")).sendKeys("Marcelo3641*");
        navegador.findElement(By.name("commit")).click();
        WebElement successNotice = navegador.findElement(By.id("flash_notice"));
        String txt = "Signed in successfully.";
        assertEquals(txt,successNotice.getText());
    }

    @Test
    public void testInvalidSign(){

        navegador.findElement(By.linkText("Sign In")).click();
        navegador.findElement(By.id("user_login")).sendKeys("xxxx");
        navegador.findElement(By.id("user_password")).sendKeys("xxxx");
        navegador.findElement(By.name("commit")).click();
        WebElement successNotice = navegador.findElement(By.id("flash_alert"));
        String txt = "Invalid Login or password.";
        assertEquals(txt,successNotice.getText());
    }

    @Test
    public void testBlankFields(){

        navegador.findElement(By.linkText("Sign In")).click();
        navegador.findElement(By.id("user_login")).sendKeys("");
        navegador.findElement(By.id("user_password")).sendKeys("");
        navegador.findElement(By.name("commit")).click();
        WebElement successNotice = navegador.findElement(By.id("flash_alert"));
        String txt = "Invalid Login or password.";
        assertEquals(txt,successNotice.getText());
    }

    @Test
    public void testInvalidUser(){

        navegador.findElement(By.linkText("Sign In")).click();
        navegador.findElement(By.id("user_login")).sendKeys("xxxxx");
        navegador.findElement(By.id("user_password")).sendKeys("Marcelo3641*");
        navegador.findElement(By.name("commit")).click();
        WebElement successNotice = navegador.findElement(By.id("flash_alert"));
        String txt = "Invalid Login or password.";
        assertEquals(txt,successNotice.getText());
    }

    @Test
    public void testInvalidPassword(){

        navegador.findElement(By.linkText("Sign In")).click();
        navegador.findElement(By.id("user_login")).sendKeys("marcelopv");
        navegador.findElement(By.id("user_password")).sendKeys("xxxxxx");
        navegador.findElement(By.name("commit")).click();
        WebElement successNotice = navegador.findElement(By.id("flash_alert"));
        String txt = "Invalid Login or password.";
        assertEquals(txt,successNotice.getText());
    }

    @Test
    public void testSpecialCharacters(){

        navegador.findElement(By.linkText("Sign In")).click();
        navegador.findElement(By.id("user_login")).sendKeys("_______");
        navegador.findElement(By.id("user_password")).sendKeys("/***//");
        navegador.findElement(By.name("commit")).click();
        WebElement successNotice = navegador.findElement(By.id("flash_alert"));
        String txt = "Invalid Login or password.";
        assertEquals(txt,successNotice.getText());
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
