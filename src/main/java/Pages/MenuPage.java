package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BasePage {
    @FindBy(linkText = "Cart")
    WebElement getCart;

    public MenuPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickCart() {
        Click(getCart);
    }
}