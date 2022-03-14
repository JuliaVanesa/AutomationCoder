package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {
    
    @FindBy (linkText = "Laptops")
    WebElement laptopsCategory;
    WebDriver driver;

    @FindBy (css = "img.card-img-top")
    WebElement cardLaptop;

    
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); ;
    }
    
    public void ClickLaptop() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(laptopsCategory)).click();

    }

    public void clickFirstLaptop() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(cardLaptop)).click();
    }
}
