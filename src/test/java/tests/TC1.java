package tests;

import framework.browser.Browser;
import framework.utils.PropertiesRead;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.pages.MainPage;

import java.util.UUID;

public class TC1 {
    static final Logger log = Logger.getLogger(TC1.class);
    private static final String PAGE = PropertiesRead.readFromFrameworkConfig("page");
    String randomText = UUID.randomUUID().toString();
    private String frameName = "mce_0_ifr";
    private final String STRONG = "strong";

    @BeforeTest
    public void init() {
        PropertyConfigurator.configure(PropertiesRead.readFromFrameworkConfig("logfile"));
        Browser.getBrowser();
        Browser.setImplicitlyWait();
        Browser.goToUrl(PAGE);
        Browser.maximize();
    }

    @Test
    public void iFrameTest() {
        MainPage mainPage = new MainPage();
        log.info("iFrame page opening check");
        Assert.assertTrue(mainPage.pageIsDisplayed());
        mainPage.getFrame().switchToFrame(frameName);
        mainPage.getFrame().writeRandomText(randomText);
        log.info("Check if text is written");
        Assert.assertEquals(randomText, mainPage.getFrame().getTextBoxText());
        mainPage.getFrame().highlightText();
        mainPage.getFrame().switchToDefaultContent();
        mainPage.getFontEditor().boldFontClick();
        log.info("Check if text is bold");
        Assert.assertTrue(mainPage.getTextChangesInfo().toLowerCase().contains(STRONG));
    }

    @AfterTest
    public void close() {
        Browser.close();
    }

}
