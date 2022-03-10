import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PruebaDemo {

    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();
    @Test
    public void navegarToHome() {
        driver.manage().window().maximize();
        driver.navigate().to(url);
        //Assert.assertEquals("STORE", driver.getTitle());
        driver.quit();
    }
}
