package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChrome(String url) {

        //Headless
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");

        // To OPen browser remove options from parameter
        System.setProperty("webdriver.chrome.driver", "\\driver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver(options);
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        navegador.get(url);

        return navegador;
    }

}
