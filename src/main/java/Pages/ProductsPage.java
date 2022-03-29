package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsPage extends BasePage {
    @FindBy(css = "img.card-img-top")
    WebElement cardLaptop;

    public ProductsPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickFirstLaptop() {
        Click(cardLaptop);
    }

    public void ClickProductInPriceRanger(int minPrice, int maxPrice) {
        getPriceInPriceRange(minPrice, maxPrice).findElement(By.xpath(".//preceding-sibling::h4")).click();
    }

    public WebElement getPriceInPriceRange(int minPrice, int maxPrice) {
        int price;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("MacBook Pro")));
        List<WebElement> pricesElements = driver.findElements(By.xpath("//h5[contains(text(), '$')]"));
        for (WebElement priceElement : pricesElements) {
            price = Integer.parseInt(priceElement.getText().replace("$", ""));
            if (price > minPrice && price < maxPrice) {
                return priceElement;
            }
        }
        return null;
    }
}