package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtils;

public class DataDrivenLoginTest extends BaseTest {

	@DataProvider(name = "loginData")
	public Object[][] getData() throws IOException {

	    System.out.println("DataProvider Called");

	    return ExcelUtils.getLoginData();
	}

    @Test(dataProvider = "loginData")
    public void verifyLogin(String username,
                            String password) {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(username, password);

        HomePage homePage =
                new HomePage(driver);

        Assert.assertTrue(
                homePage.isProductsDisplayed());

        System.out.println(
                "Login Successful : "
                + username);
    }
}