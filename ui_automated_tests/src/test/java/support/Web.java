package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChrome(String url) {

        //Headless
        ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); // open Browser in maximized mode
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
		options.addArguments("--proxy-server='105.112.150.10'");
        //options.setExperimentalOption("--disable-dev-shm-usage");
		//options.addArguments("--headless");
        //options.setExperimentalOption("useAutomationExtension", false);
        //options.addArguments("window-size=1200x600");
        

        // To OPen browser remove options from parameter
       // System.setProperty("webdriver.chrome.driver", "D:\\workspace-slave\\workspace\\AutomaticTest\\ui_automated_tests\\src\\test\\java\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe --whitelist-ip %*");
        WebDriver navegador = new ChromeDriver(options);
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        navegador.get(url);

        return navegador;
    }

}
