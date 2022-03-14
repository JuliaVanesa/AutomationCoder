package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    @FindBy(xpath = "//tr[@class='success']//td[2]")
    WebElement getTitle;
    WebDriver driver;

    @FindBy (xpath = "//tr[@class='success']//td[3]")
    WebElement getPrice;

    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    WebElement getPlaceOrder;

    public CartPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String CartTitle() {
        return getTitle.getText();
    }

    public String CartPrice() {
        return getPrice.getText();
    }

    public void clickPlaceOrder() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(getPlaceOrder)).click();
    }
}
