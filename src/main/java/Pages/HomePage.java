package Pages;

import Utility.PropertiesFile;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    private String url = PropertiesFile.getProperty("url");

    public HomePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
        ;
    }

    public void navegarUrl() {
        this.driver.manage().window().maximize();
        this.driver.navigate().to(url);
    }

    public void quit() {
        this.driver.quit();
    }
}