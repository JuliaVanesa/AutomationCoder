package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalConfirmPage extends BasePage{
    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement msjConfirm;


    @FindBy (xpath = "//button[contains(text(),'OK')]")
    WebElement buttonOK;

    public ModalConfirmPage() {
        this.driver = getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public String textConfirm() {
        return GetText(msjConfirm);
    }

    public void confirmOk() { Click(buttonOK);}
}
