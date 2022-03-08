import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlaze {

    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();

    @Test
    public void categoriesLaptops()  {

        driver.manage().window().maximize();
        driver.navigate().to(url);

        //Busco Laptops
        driver.findElement(By.linkText("Laptops")).click();


        // Primer producto
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.card-img-top"))).click();
        //driver.findElement().click();


        // Laptop y precio
        String laptop;
        String precio;

        laptop = driver.findElement(By.cssSelector("h2.name")).getText();

        precio = driver.findElement((By.cssSelector("h3.price-container"))).getText();

        System.out.println("laptop: " + laptop + "Precio" + precio);


        //Agregar al carrito
        driver.findElement(By.linkText("Add to cart")).click();


        //Creo alert
        Alert alert = driver.switchTo().alert();
        String alertmsg = alert.getText();
        alert.accept();

        //Comparar texto de alerta
        Assert.assertEquals("Product added", alertmsg );
        driver.quit();

    }
}
