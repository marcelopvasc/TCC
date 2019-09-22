package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Web;

import java.util.concurrent.TimeUnit;

public class MainPageTests {

    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome();

    }

    @Test
    public void testOPenAPIDocs(){

        String urlexpected = "http://localhost:3001/apidoc/index.html";
        navegador.findElement(By.linkText("API Docs")).click();
        assertEquals(urlexpected,navegador.getCurrentUrl());
    }

    @Test
    public void testOPenCode(){

        String urlexpected = "https://github.com/mwinteringham/restful-booker";
        navegador.findElement(By.linkText("Code")).click();
        assertEquals(urlexpected,navegador.getCurrentUrl());
    }

    @Test
    public void testOPenWebsite(){

        String urlexpected = "https://www.mwtestconsultancy.co.uk/";
        navegador.findElement(By.linkText("Website")).click();
        assertEquals(urlexpected,navegador.getCurrentUrl());
    }

    @Test
    public void testOPenTwitter(){

        String urlexpected = "https://twitter.com/2bittester";
        navegador.findElement(By.linkText("@2bittester")).click();
        assertEquals(urlexpected,navegador.getCurrentUrl());
    }
    @After
    public void tearDown() {
        // Fechar o navegador
        navegador.quit();
    }
}
