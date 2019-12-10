package framework.browser;

import framework.utils.PropertiesRead;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static WebDriver driver;
    private static final int TIMEOUT = Integer.parseInt(PropertiesRead.readFromFrameworkConfig("timeout"));
    private static String browserName = PropertiesRead.readFromFrameworkConfig("browser");

    static final Logger log = Logger.getLogger(Browser.class);


    public static WebDriver getBrowser() {
        if (driver == null) {
            driver = BrowserFactory.getBrowser(browserName);
        }
        return driver;
    }

    public static void goToUrl(String url) {
        log.info("Go to " + url);
        getBrowser().get(url);
    }

    public static void maximize() {
        log.info("Full screen mode is on");
        getBrowser().manage().window().maximize();
    }

    public static void close() {
        log.info("Browser closes");
        getBrowser().close();
    }

    public static void setImplicitlyWait() {
        log.info("Timeout is " + TIMEOUT);
        getBrowser().manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }

    public static void switchToFrame(String frameName) {
        log.info("Switching to the frame");
        getBrowser().switchTo().frame(frameName);
    }

}
