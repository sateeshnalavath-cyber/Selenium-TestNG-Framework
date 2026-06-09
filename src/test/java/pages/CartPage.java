package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    // Product name
    By productName = By.xpath("//div[text()='Sauce Labs Backpack']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Verify product present in cart
    public boolean isProductDisplayed() {

        return driver.findElement(productName).isDisplayed();
    }
}