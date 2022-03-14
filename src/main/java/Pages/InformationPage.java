package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformationPage {
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

    WebDriver driver;


    public InformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void completarForm (String name, String country, String city, String card, String month, String year) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(nameInput));
        nameInput.sendKeys(name);
        countryInput.sendKeys(country);
        cityInput.sendKeys(city);
        cardInput.sendKeys(card);
        monthInput.sendKeys(month);
        yearInput.sendKeys(year);

    }
    public void clickPurchase() {
        buttonPurchase.click();
    }
}
