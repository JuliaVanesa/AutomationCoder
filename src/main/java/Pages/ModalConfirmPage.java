package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalConfirmPage {
    @FindBy(xpath = "//h2[normalize-space()='Thank you for your purchase!']")
    WebElement msjConfirm;
    WebDriver driver;

    public ModalConfirmPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String textConfirm() {
        return msjConfirm.getText();
    }
}
