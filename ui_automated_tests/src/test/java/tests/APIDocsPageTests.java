package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Web;
import static org.junit.Assert.*;

public class APIDocsPageTests {

    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome("http://localhost:3001/apidoc/index.html");
    }


    @Test
    public void testFilterGet(){


        navegador.findElement(By.xpath("//input[@class='form-control search']")).sendKeys("Get");
        WebElement getBookingIds = navegador.findElement(By.linkText("GetBookingIds"));
        String getBookingIdsElem = getBookingIds.getText();
        WebElement getBooking = navegador.findElement(By.linkText("GetBooking"));
        String getBookingElem = getBooking.getText();
        System.out.println("GetBookingIDs: " + getBookingIdsElem);
        System.out.println("GetBooking: " + getBookingElem);

        String getBI = "GetBookingIds";
        String getB = "GetBooking";

        assertEquals(getBI, getBookingIdsElem);
        assertEquals(getB, getBookingElem);

    }

    @Test
    public void testFilterCreate(){

        navegador.findElement(By.xpath("//input[@class='form-control search']")).sendKeys("Create");
        WebElement createToken = navegador.findElement(By.linkText("CreateToken"));
        String createTokenElem = createToken.getText();
        WebElement createBooking = navegador.findElement(By.linkText("CreateBooking"));
        String createBookingElem = createBooking.getText();
        System.out.println("CreateTokenElem: " + createTokenElem);
        System.out.println("CreateBookingElem: " + createBookingElem);

        String getCT = "CreateToken";
        String getCB = "CreateBooking";

        assertEquals(getCT, createTokenElem);
        assertEquals(getCB, createBookingElem);

    }

    @Test
    public void testOptionCreateTokenSection(){

        navegador.findElement(By.linkText("CreateToken")).click();
        String urlSection = "http://localhost:3001/apidoc/index.html#api-Auth-CreateToken";
        assertEquals(urlSection, navegador.getCurrentUrl());
    }

    @Test
    public void testOptionGetBookingIdsSection(){

        navegador.findElement(By.linkText("GetBookingIds")).click();
        String urlSection = "http://localhost:3001/apidoc/index.html#api-Booking-GetBookings";
        assertEquals(urlSection, navegador.getCurrentUrl());
    }

    @Test
    public void testOptionGetBookingSection(){

        navegador.findElement(By.linkText("GetBooking")).click();
        String urlSection = "http://localhost:3001/apidoc/index.html#api-Booking-GetBooking";
        assertEquals(urlSection, navegador.getCurrentUrl());
    }

    @Test
    public void testOptionCreateBookingSection(){

        navegador.findElement(By.linkText("CreateBooking")).click();
        String urlSection = "http://localhost:3001/apidoc/index.html#api-Booking-CreateBooking";
        assertEquals(urlSection, navegador.getCurrentUrl());
    }

    @Test
    public void testOptionUpdateBookingSection(){

        navegador.findElement(By.linkText("UpdateBooking")).click();
        String urlSection = "http://localhost:3001/apidoc/index.html#api-Booking-UpdateBooking";
        assertEquals(urlSection, navegador.getCurrentUrl());
    }

    @Test
    public void testOptionPartialUpdateBookingSection(){

        navegador.findElement(By.linkText("PartialUpdateBooking")).click();
        String urlSection = "http://localhost:3001/apidoc/index.html#api-Booking-PartialUpdateBooking";
        assertEquals(urlSection, navegador.getCurrentUrl());
    }

    @Test
    public void testOptionDeleteUpdateBookingSection(){

        navegador.findElement(By.linkText("DeleteBooking")).click();
        String urlSection = "http://localhost:3001/apidoc/index.html#api-Booking-DeleteBooking";
        assertEquals(urlSection, navegador.getCurrentUrl());
    }


    @Test
    public void testOptionHealthCheckSection(){

        navegador.findElement(By.linkText("HealthCheck")).click();
        String urlSection = "http://localhost:3001/apidoc/index.html#api-Ping-Ping";
        assertEquals(urlSection, navegador.getCurrentUrl());
    }

    @After
    public void tearDown() {
        // Fechar o navegador
        navegador.quit();
    }
}
