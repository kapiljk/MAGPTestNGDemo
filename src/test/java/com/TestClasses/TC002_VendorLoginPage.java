package com.TestClasses;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.Pages.LoginPage;
import com.Pages.PreLoginPage;

public class TC002_VendorLoginPage extends BaseClass {

	//public static WebDriver driver;
	@BeforeClass
	public void openBrowser() throws IOException {
		getDriver(getCellValue("TestData", 2, 1));
		//getDriver("edge");
		enterAppInUrl(getCellValue("TestData", 3, 1));
		//enterAppInUrl("https://magp.myairports.com.my/auth");
		maximizeWindow();
	}
	
	@Test
	private void validLoginVendor() throws IOException {
		PreLoginPage pl = new PreLoginPage(driver);
		pl.vendorLogin();
		LoginPage l = new LoginPage(driver);
		l.performLogin(getCellValue("TestData", 0, 1), getCellValue("TestData", 1, 1));
	}
	
	
}
