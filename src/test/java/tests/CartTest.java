package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class CartTest extends BaseTest {

    @Test
    public void verifyCartProduct() {

        // Read config data
        ConfigReader config = new ConfigReader();

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password"));

        // Home page
        HomePage homePage = new HomePage(driver);

        // Add product
        homePage.addProductToCart();

        // Open cart
        homePage.openCart();

        // Cart page
        CartPage cartPage = new CartPage(driver);

        // Verify product in cart
        Assert.assertTrue(cartPage.isProductDisplayed());
    }
}