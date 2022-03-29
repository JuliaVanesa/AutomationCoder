import Data.DataProviderClass;
import Pages.*;
import Utility.DriverFactory;
import Utility.PropertiesFile;
import Utility.Utilidades;
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




    @BeforeTest
    public void openBrowser() {
        HomePage homePage = new HomePage();
        homePage.navegarUrl();

    }

    @Test (dataProvider = "DemoBlazeTest", dataProviderClass = DataProviderClass.class)
    public void categoriesLaptops(String name, String country, String city, String card, String month, String year) throws InterruptedException {

        //Busco Laptops
        CategoryPage categoryPage;
        categoryPage = new CategoryPage();
        categoryPage.ClickLaptop();

        // Primer producto
        ProductsPage productsPage;
        productsPage = new ProductsPage();
        productsPage.ClickProductInPriceRanger(780, 890);

        // Laptop y precio
        ProductPage productPage;
        productPage = new ProductPage();
        String laptop;
        String precio;
        laptop = productPage.getLaptop();
        precio = Utilidades.igualarPrecio (productPage.getPrice());
        System.out.println("laptop: " + laptop + "\nPrecio: " + precio);

        //Agregar al carrito
        productPage.clickAddToCart();

        //Alert
        WebDriverWait alertWait = new WebDriverWait(DriverFactory.getDriver(), 3);
        alertWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        String alertmsg = alert.getText();
        Assert.assertEquals("Product added", alertmsg );
        alert.accept();

        //Ingresar en Cart
        MenuPage menuPage;
        menuPage = new MenuPage();
        menuPage.clickCart();

        //Asercion en titulo y precio
        CartPage cartPage;
        cartPage = new CartPage();

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
        informationPage = new InformationPage();

        informationPage.completarForm(name, country, city, card, month,year);
        informationPage.clickPurchase();

        //Asercion del texto
        ModalConfirmPage modalConfirmPage;
        modalConfirmPage = new ModalConfirmPage();

        String textConfirm = modalConfirmPage.textConfirm();
        String textExpected = "Thank you for your purchase!";

        Thread.sleep(3000);
        modalConfirmPage.confirmOk();
        //softAssert.assertEquals(textConfirm, textExpected);
        System.out.println("-----------------------------");
        System.out.println("Resultado actual: " + textConfirm  + "\nResultado esperado: " + textExpected);

        softAssert.assertAll();


    }

    @AfterTest
    public void closeBrowser() {
        HomePage homePage = new HomePage();
        homePage.quit();
    }

}
