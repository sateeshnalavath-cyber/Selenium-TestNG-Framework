package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class RemoveProductTest extends BaseTest {

    @Test
    public void verifyRemoveProduct() {

        
        ConfigReader config = new ConfigReader();

        // Login page object
        LoginPage loginPage = new LoginPage(driver);

        // Login
        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password"));

        // Home page object
        HomePage homePage = new HomePage(driver);

        // Add product
        homePage.addProductToCart();

        // Remove product
        homePage.removeProduct();

        // Verify Add To Cart button displayed
        Assert.assertTrue(
                driver.getPageSource().contains("Add to cart"));
    }
}