package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyAddToCart() {

        // Read config data
        ConfigReader config = new ConfigReader();

        // Login page object
        LoginPage loginPage = new LoginPage(driver);

        // Login
        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password"));

        // Home page object
        HomePage homePage = new HomePage(driver);

        // Add product to cart
        homePage.addProductToCart();

        // Verify product added
        Assert.assertTrue(driver.getPageSource().contains("Remove"));
    }
}