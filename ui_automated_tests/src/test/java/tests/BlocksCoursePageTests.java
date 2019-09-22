package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Web;

public class BlocksCoursePageTests {

    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome();
    }

    @After
    public void tearDown() {
        // Fechar o navegador
        navegador.quit();
    }
}
