import Pages.CategoryPage;
import Pages.MenuPage;
import Pages.ProductPage;
import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlaze {

    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();

    @Test
    public void categoriesLaptops(){

        driver.manage().window().maximize();
        driver.navigate().to(url);

        //Busco Laptops
        CategoryPage homePage;
        homePage = new CategoryPage(driver);
        homePage.ClickLaptop();

        // Primer producto
        homePage.clickFirstLaptop();

        // Laptop y precio
        ProductPage productPage;
        productPage = new ProductPage(driver);
        String laptop;
        String precio;
        laptop = productPage.getLaptop();
        precio = productPage.getPrice();
        System.out.println("laptop: " + laptop + "Precio" + precio);

        //Agregar al carrito
        productPage.clickAddToCart();

        //Alert
        WebDriverWait alertWait = new WebDriverWait(driver, 3);
        alertWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertmsg = alert.getText();
        Assert.assertEquals("Product added", alertmsg );
        alert.accept();

        //Ingresar en Cart
        MenuPage menuPage;
        menuPage = new MenuPage(driver);
        menuPage.clickCart();
        //driver.quit();
    }
}
