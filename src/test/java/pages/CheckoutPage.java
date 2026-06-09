package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    By checkoutBtn = By.id("checkout");
    By firstName   = By.id("first-name");
    By lastName    = By.id("last-name");
    By postalCode  = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn   = By.id("finish");
    By successMsg  = By.className("complete-header");
    By errorMsg    = By.cssSelector("h3[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickCheckout() {
        // Wait for cart page to fully load first
        wait.until(ExpectedConditions.urlContains("cart"));
        // Then click checkout button
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        // Wait for step-one page to load
        wait.until(ExpectedConditions.urlContains("checkout-step-one"));
    }

    public void enterDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName))
                .sendKeys("Sateesh");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName))
                .sendKeys("QA");
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode))
                .sendKeys("500001");

        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));
        System.out.println("After Continue : " + driver.getCurrentUrl());
    }
    public void finishOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(successMsg)).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}