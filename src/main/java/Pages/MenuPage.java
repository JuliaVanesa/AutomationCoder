package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MenuPage extends BasePage{
    @FindBy(linkText = "Cart")
    WebElement getCart;


    public MenuPage () {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickCart() {
        Click(getCart);
    }

}


