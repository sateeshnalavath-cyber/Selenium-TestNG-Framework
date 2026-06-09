package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class FailureTest extends BaseTest {

    @Test
    public void failedTest() {

        driver.get("https://www.saucedemo.com");

        Assert.assertTrue(false);
    }
}