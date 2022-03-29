package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    @FindBy(xpath = "//tr[@class='success']//td[2]")
    WebElement getTitle;

    @FindBy(xpath = "//tr[@class='success']//td[3]")
    WebElement getPrice;

    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    WebElement getPlaceOrder;

    public CartPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public String CartTitle() {
        return GetText(getTitle);
    }

    public String CartPrice() {
        return GetText(getPrice);
    }

    public void clickPlaceOrder() {
        Click(getPlaceOrder);
    }
}