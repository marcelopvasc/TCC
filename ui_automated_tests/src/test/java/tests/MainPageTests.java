package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Web;
import support.ReadPropertyFile;

import java.util.Set;


public class MainPageTests extends ReadPropertyFile{

    private WebDriver navegador;


    @Before
    public void setUp() {
        navegador = Web.createChrome("http://localhost:3001/");
        navegador.manage().window().maximize();

    }

    @Test
    public void testOPenAPIDocs(){

        navegador.findElement(By.linkText(getResource("clickableElementAPI"))).click();
        assertEquals(getResource("urlExpected"),navegador.getCurrentUrl());
    }

    @Test
    public void testOPenCode(){

        navegador.findElement(By.linkText(getResource("clickableElementOC"))).click();
        assertEquals(getResource("urlExpectedOC"),navegador.getCurrentUrl());
    }

    @Test
    public void testOPenWebsite(){

        navegador.findElement(By.linkText(getResource("clickableElementWS"))).click();
        assertEquals(getResource("urlExpectedWS"),navegador.getCurrentUrl());
    }

    @Test
    public void testOPenTwitter(){

        navegador.findElement(By.linkText(getResource("clickableElementTW"))).click();
        assertEquals(getResource("urlExpectedTW"),navegador.getCurrentUrl());
    }

    @Test
    public void testOPenApiFrameworkCourse() {


        navegador.findElement(By.xpath(getResource("clickableElementFC"))).click();

        Set<String> handles = navegador.getWindowHandles();
        System.out.println(handles);
        for (String handle1 : navegador.getWindowHandles()){
            navegador.switchTo().window(handle1);
            navegador.getCurrentUrl();
        }
        assertEquals(getResource("urlExpectedFC"), navegador.getCurrentUrl());

    }

    @Test
    public void testOPenHTTPCourse(){

        navegador.findElement(By.xpath(getResource("clickableElementHC"))).click();

        Set<String> handles = navegador.getWindowHandles();
        System.out.println(handles);
        for (String handle1 : navegador.getWindowHandles()){
            navegador.switchTo().window(handle1);
            navegador.getCurrentUrl();
        }
        assertEquals(getResource("urlExpectedHC"), navegador.getCurrentUrl());
    }

    @Test
    public void testOPenBlocksCourse(){

        navegador.findElement(By.xpath(getResource("clickableElementBC"))).click();

        Set<String> handles = navegador.getWindowHandles();
        System.out.println(handles);
        for (String handle1 : navegador.getWindowHandles()){
            navegador.switchTo().window(handle1);
            navegador.getCurrentUrl();
        }

        assertEquals(getResource("urlExpectedBC"), navegador.getCurrentUrl());
    }

    @After
    public void tearDown() {
        // Fechar o navegador
        navegador.quit();
    }
}
