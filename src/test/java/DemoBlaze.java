import Data.DataProviderClass;
import Pages.*;
import Utility.DriverFactory;
import Utility.Utilidades;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DemoBlaze {

    @BeforeTest
    public void openBrowser() {
        HomePage homePage = new HomePage();
        homePage.navegarUrl();
    }

    @Test(dataProvider = "DemoBlazeTest", dataProviderClass = DataProviderClass.class)
    public void categoriesLaptops(String name, String country, String city, String card, String month, String year) throws InterruptedException {

        //Busco Laptops
        CategoryPage categoryPage = new CategoryPage();
        categoryPage.ClickLaptop();

        // Primer producto
        ProductsPage productsPage = new ProductsPage();
        productsPage.ClickProductInPriceRanger(780, 890);

        // Laptop y precio
        ProductPage productPage = new ProductPage();
        String laptop;
        String precio;
        laptop = productPage.getLaptop();
        precio = Utilidades.igualarPrecio(productPage.getPrice());
        System.out.println("laptop: " + laptop + "\nPrecio: " + precio);

        //Agregar al carrito
        productPage.clickAddToCart();

        //Alert
        WebDriverWait alertWait = new WebDriverWait(DriverFactory.getDriver(), 3);
        alertWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        String alertmsg = alert.getText();
        Assert.assertEquals("Product added", alertmsg);
        alert.accept();

        //Ingresar en Cart
        MenuPage menuPage = new MenuPage();
        menuPage.clickCart();

        //Asercion en titulo y precio
        CartPage cartPage = new CartPage();
        String titulo = cartPage.CartTitle();
        String precioCart = cartPage.CartPrice();
        Assert.assertEquals(titulo, laptop);
        Assert.assertEquals(precioCart, precio);
        System.out.println("titulo: " + titulo + "\nprecio: " + precioCart);

        //Click en place Order
        cartPage.clickPlaceOrder();

        //Completar Formulario
        InformationPage informationPage = new InformationPage();
        informationPage.completarForm(name, country, city, card, month, year);
        informationPage.clickPurchase();

        //Asercion del texto
        ModalConfirmPage modalConfirmPage = new ModalConfirmPage();
        String textConfirm = modalConfirmPage.textConfirm();
        String textExpected = "Thank you for your purchase!";
        Assert.assertEquals(textConfirm, textExpected);
        System.out.println("-----------------------------");
        System.out.println("Resultado actual: " + textConfirm + "\nResultado esperado: " + textExpected);

        //Validar price, name, card igual al modal
        System.out.println(modalConfirmPage.getValidateData());
        Assert.assertTrue(modalConfirmPage.getValidateData().contains(precioCart));
        Assert.assertTrue(modalConfirmPage.getValidateData().contains(card));
        Assert.assertTrue(modalConfirmPage.getValidateData().contains(name));
        Thread.sleep(500); //Esto sé que no va, pero no funciona si lo saco.
        modalConfirmPage.confirmOk();
    }

    @AfterTest
    public void closeBrowser() {
        HomePage homePage = new HomePage();
        homePage.quit();
    }
}