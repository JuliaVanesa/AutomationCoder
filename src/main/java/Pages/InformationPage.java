package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformationPage extends BasePage {
    @FindBy(id="name")
    WebElement nameInput;

    @FindBy(id="country")
    WebElement countryInput;

    @FindBy(id="city")
    WebElement cityInput;

    @FindBy(id="card")
    WebElement cardInput;

    @FindBy(id="month")
    WebElement monthInput;

    @FindBy(id="year")
    WebElement yearInput;

    @FindBy(xpath = "//button[normalize-space()='Purchase']")
    WebElement buttonPurchase;




    public InformationPage() {
        this.driver = getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public void completarForm (String name, String country, String city, String card, String month, String year) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(nameInput));
        SendKeys(nameInput, name);
        SendKeys(countryInput, country);
        SendKeys(cityInput, city);
        SendKeys(cardInput, card);
        SendKeys(monthInput, month);
        SendKeys(yearInput, year);

    }
    public void clickPurchase() {
        Click(buttonPurchase);
    }
}
