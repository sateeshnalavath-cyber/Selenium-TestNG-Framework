package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    // Products title
    By productsTitle = By.xpath("//span[text()='Products']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Verify Products page
    public boolean isProductsDisplayed() {
        return driver.findElement(productsTitle).isDisplayed();
    }
    
 // Backpack Add To Cart button
    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
 // Add product to cart
    public void addProductToCart() {

        driver.findElement(addToCartBtn).click();
     
    }
 // Remove button
    By removeBtn = By.id("remove-sauce-labs-backpack"); 
 // Remove product from cart
    public void removeProduct() {

        driver.findElement(removeBtn).click();
    }
 // Cart icon
    By cartIcon = By.className("shopping_cart_link");
 // Open cart
    public void openCart() {

        driver.findElement(cartIcon).click();
    }
 // Finish button
    By finishBtn = By.id("finish");
 // Complete order
    public void finishOrder() {

        driver.findElement(finishBtn).click();
    }
}