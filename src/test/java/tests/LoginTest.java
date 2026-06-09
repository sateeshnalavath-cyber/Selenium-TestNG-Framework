package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {
	@Test
	public void verifyLogin() {

	    LoginPage loginpage = new LoginPage(driver);

	    ConfigReader config = new ConfigReader();

	    loginpage.login(
	            config.getProperty("username"),
	            config.getProperty("password"));

	    HomePage homePage = new HomePage(driver);

	    Assert.assertTrue(homePage.isProductsDisplayed());
}
}