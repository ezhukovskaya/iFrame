package framework.browser;

import framework.utils.PropertiesRead;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;

public class BrowserFactory {
    static final Logger log = Logger.getLogger(BrowserFactory.class);

    public static WebDriver getBrowser(String browserName) {
        String language = PropertiesRead.readFromFrameworkConfig("language");
        browserName = browserName.toLowerCase();
        log.info("Language of web-site is " + language);
        WebDriver driver = null;
        switch (browserName) {
            case "chrome":
                log.info("Chosen browser is chrome");
                driver = getChromeInstance(language);
                break;
            case "firefox":
                log.info("Chosen browser is firefox");
                driver = getFirefoxInstance(language);
        }
        return driver;
    }

    private static ChromeDriver getChromeInstance(String language) {
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("safebrowsing.enabled", true);
        chromePrefs.put("intl.accept_languages", language);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        return new ChromeDriver(chromeOptions);
    }

    private static FirefoxDriver getFirefoxInstance(String language) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("browser.download.folderList", 2);
        firefoxOptions.addPreference("browser.download.useDownloadDir", true);
        firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-debian-package");
        firefoxOptions.addPreference("pdfjs.disabled", true);
        firefoxOptions.addPreference("intl.accept_languages", language);
        return new FirefoxDriver(firefoxOptions);
    }
}
