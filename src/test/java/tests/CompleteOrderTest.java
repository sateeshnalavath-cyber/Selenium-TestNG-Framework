package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class CompleteOrderTest extends BaseTest {

    @Test
    public void verifyOrderSuccess() throws InterruptedException {

        // Read Config Data
        ConfigReader config = new ConfigReader();

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password"));

        // Home Page
        HomePage homePage = new HomePage(driver);

        // Add Product
        homePage.addProductToCart();

        // Open Cart
        homePage.openCart();

        // Checkout Page
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Click Checkout
        checkoutPage.clickCheckout();

        // Enter User Details
        checkoutPage.enterDetails();

        // Verify Step Two Page
        System.out.println("After Continue : "
                + driver.getCurrentUrl());

        // Finish Order
        checkoutPage.finishOrder();

        // Verify Success Message
        Assert.assertEquals(
                checkoutPage.getSuccessMessage(),
                "Thank you for your order!");

        System.out.println("Order Completed Successfully");
    }
}