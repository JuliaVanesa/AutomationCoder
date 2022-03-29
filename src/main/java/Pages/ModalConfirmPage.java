package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalConfirmPage extends BasePage {
    @FindBy(xpath = "//h2[normalize-space()='Thank you for your purchase!']")
    WebElement msjConfirm;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement buttonOK;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    WebElement validateData;

    public ModalConfirmPage() {
        this.driver = getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public String textConfirm() {
        return GetText(msjConfirm);
    }

    public void confirmOk() {
        Click(buttonOK);
    }

    public String getValidateData() {
        return GetText(validateData);
    }
}