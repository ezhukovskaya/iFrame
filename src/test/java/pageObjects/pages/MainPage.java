package pageObjects.pages;

import framework.base.BaseForm;
import framework.elements.Label;
import org.openqa.selenium.By;
import pageObjects.forms.FontEditor;
import pageObjects.frames.MainPageFrame;

public class MainPage extends BaseForm {
    private static Label iFramePageLabel = new Label(By.xpath("//div[contains(@class, 'example')]"), "iFrame Main Page Label");
    private Label textInfo = new Label(By.xpath("//div[@id='mceu_28-body']"), "Text Change Info");


    public MainPage() {
        super(iFramePageLabel);
    }

    public MainPageFrame getFrame() {
        return new MainPageFrame();
    }

    public FontEditor getFontEditor() {
        return new FontEditor();
    }

    public String getTextChangesInfo() {
        return textInfo.getText();
    }

}
