import Pages.*;
import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class DemoBlaze {

    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();

    @BeforeTest
    public void openBrowser() {
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @Test
    public void categoriesLaptops(){

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
        precio = igualarPrecio(productPage.getPrice());
        System.out.println("laptop: " + laptop + "\nPrecio: " + precio);

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

        //Asercion en titulo y precio
        CartPage cartPage;
        cartPage = new CartPage(driver);

        String titulo = cartPage.CartTitle();
        String precio2 = cartPage.CartPrice();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(titulo, laptop);
        softAssert.assertEquals(precio2, precio);
        System.out.println("titulo: " + titulo  + "\nprecio: " + precio2 );

        //Click en place Order
        cartPage.clickPlaceOrder();

        //Completar Formulario
        InformationPage informationPage;
        informationPage = new InformationPage(driver);

        informationPage.completarForm("julia", "Argentina", "Cordoba", "visa", "marzo", "2022");
        informationPage.clickPurchase();

        //Asercion del texto
        ModalConfirmPage modalConfirmPage;
        modalConfirmPage = new ModalConfirmPage(driver);

        String textConfirm = modalConfirmPage.textConfirm();
        String textExpected = "Thank you for your purchase!";

        softAssert.assertEquals(textConfirm, textExpected);
        System.out.println("-----------------------------");
        System.out.println("Resultado actual: " + textConfirm  + "\nResultado esperado: " + textExpected);
        softAssert.assertAll();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    // Igualar el precio del detalle con el precio que traigo de la tabla
        public String igualarPrecio (String precio) {
        int finalPrecio = precio.indexOf("*")-1;
        return (precio.substring(1, finalPrecio));
    }
}
