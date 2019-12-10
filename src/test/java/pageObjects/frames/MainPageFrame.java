package pageObjects.frames;

import framework.base.BaseForm;
import framework.browser.Browser;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class MainPageFrame extends BaseForm {
    private TextBox iFrameTextBox = new TextBox(By.cssSelector("#tinymce > p"), "iFrame TextBox");
    private static Label iFrameLabel = new Label(By.xpath("//*[@id='mce-content-body']"), "iFrame label");

    public MainPageFrame() {
        super(iFrameLabel);
    }

    public void switchToFrame(String frameName) {
        Browser.switchToFrame(frameName);
    }

    public void writeRandomText(String randomText) {
        iFrameTextBox.clear();
        iFrameTextBox.sendKeys(randomText);
    }

    public String getTextBoxText() {
        return iFrameTextBox.getText();
    }

    public void highlightText() {
        iFrameTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    }

    public void switchToDefaultContent() {
        Browser.getBrowser().switchTo().defaultContent();
    }
}
