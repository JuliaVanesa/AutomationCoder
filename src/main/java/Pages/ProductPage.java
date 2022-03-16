package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;

    @FindBy (css ="h2.name")
    WebElement nameLaptop;


    @FindBy (css = "h3.price-container")
    WebElement priceLaptop;

    @FindBy (linkText = "Add to cart")
    WebElement addToCart;

    public ProductPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLaptop () {
       return nameLaptop.getText();
    }
    public String getPrice() {
        return priceLaptop.getText();
    }


    public void clickAddToCart() {
        addToCart.click();
    }
}


