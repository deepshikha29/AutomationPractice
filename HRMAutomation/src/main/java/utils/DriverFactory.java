package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    static WebDriver driver = null;

    //initializing driver with respect to required browser passed in arguments.
     public static WebDriver launcheBrowser(String BrowserName) {
         switch (BrowserName) {
             case "Firefox":
                 driver = new FirefoxDriver();
                 break;
             case "Chrome":
                 driver = new ChromeDriver();
                 break;
             case "Edge":
                 driver = new EdgeDriver();
                 break;
             default:
                 driver = new ChromeDriver();
         }
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         return driver;

     }
}
