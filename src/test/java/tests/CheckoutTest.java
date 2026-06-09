package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyCheckout() throws InterruptedException {

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

        // Checkout page
        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        // Click checkout
        checkoutPage.clickCheckout();
        System.out.println("Current URL = " + driver.getCurrentUrl());

        checkoutPage.enterDetails();

     //   System.out.println(driver.getPageSource());

     //   System.out.println("After Continue : "
    //            + driver.getCurrentUrl());
    }
}