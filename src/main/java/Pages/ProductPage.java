package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {


    @FindBy (css ="h2.name")
    WebElement nameLaptop;


    @FindBy (css = "h3.price-container")
    WebElement priceLaptop;

    @FindBy (linkText = "Add to cart")
    WebElement addToCart;

    public ProductPage () {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getLaptop () {
       return GetText(nameLaptop);
    }
    public String getPrice() {
        return GetText(priceLaptop);
    }


    public void clickAddToCart() {
        Click(addToCart);
    }

}


