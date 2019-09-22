package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Web;

import java.util.Set;


public class MainPageTests {

    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome("http://localhost:3001/");
        navegador.manage().window().maximize();

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

    @Test
    public void testOPenApiFrameworkCourse() {

        //String  handle = navegador.getWindowHandle();
        navegador.findElement(By.xpath("//a/img[contains(@src,'/images/buildanapi.png')]")).click();
        String url = "https://www.ministryoftesting.com/dojo/series/let-s-build-an-api-checking-framework-mark-winteringham";

        Set<String> handles = navegador.getWindowHandles();
        System.out.println(handles);
        for (String handle1 : navegador.getWindowHandles()){
            navegador.switchTo().window(handle1);
            navegador.getCurrentUrl();
        }
        String urlCur = navegador.getCurrentUrl();
        System.out.println("Expected: " + url +
                "\nCurrent: " + urlCur);
        assertEquals(url, urlCur);

    }

    @Test
    public void testOPenHTTPCourse(){

        navegador.findElement(By.xpath("//a/img[contains(@src,'/images/introhttp.png')]")).click();
        String url = "https://www.ministryoftesting.com/dojo/series/introduction-to-http";

        Set<String> handles = navegador.getWindowHandles();
        System.out.println(handles);
        for (String handle1 : navegador.getWindowHandles()){
            navegador.switchTo().window(handle1);
            navegador.getCurrentUrl();
        }
        String urlCur = navegador.getCurrentUrl();
        System.out.println("Expected: " + url +
                "\nCurrent: " + urlCur);
        assertEquals(url, urlCur);
    }

    @Test
    public void testOPenBlocksCourse(){

        navegador.findElement(By.xpath("//a/img[contains(@src,'/images/bbofti.png')]")).click();
        String url = "https://www.ministryoftesting.com/dojo/series/the-building-blocks-of-the-internet-mark-winteringham";

        Set<String> handles = navegador.getWindowHandles();
        System.out.println(handles);
        for (String handle1 : navegador.getWindowHandles()){
            navegador.switchTo().window(handle1);
            navegador.getCurrentUrl();
        }
        String urlCur = navegador.getCurrentUrl();
        System.out.println("Expected: " + url +
                "\nCurrent: " + urlCur);
        assertEquals(url, urlCur);
    }

    @After
    public void tearDown() {
        // Fechar o navegador
        navegador.quit();
    }
}
