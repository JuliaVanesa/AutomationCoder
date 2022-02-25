import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PruebaDemo {

    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();
    @Test
    public void navegarToHome() {
        driver.manage().window().maximize();
        driver.navigate().to(url);
        Assert.assertEquals("STORE", driver.getTitle());
        driver.quit();
    }
}
