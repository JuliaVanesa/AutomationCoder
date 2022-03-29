package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CategoryPage extends BasePage {

    @FindBy(linkText = "Laptops")
    WebElement laptopsCategory;

    public CategoryPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void ClickLaptop() {
        Click(laptopsCategory);
    }
}