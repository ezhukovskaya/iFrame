package pageObjects.forms;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class FontEditor extends BaseForm {
    private static Label fontEditor = new Label(By.xpath("//div[@id='mceu_23-body']"), "Font Editor");
    private Button boldText = getFormElement("mce-i-bold");

    private Button getFormElement(String elementName) {
        By elementLocator = By.xpath(String.format("//*[contains(@class, '%s')]", elementName));
        return new Button(elementLocator, elementName);
    }

    public void boldFontClick() {
        boldText.click();
    }


    public FontEditor() {
        super(fontEditor);
    }
}
