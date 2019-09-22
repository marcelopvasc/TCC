package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import support.Web;

public class HTTPCoursePageTests {

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
