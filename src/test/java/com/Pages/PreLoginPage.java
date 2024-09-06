package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

public class PreLoginPage extends BaseClass{
//public WebDriver driver;
	
	public PreLoginPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[normalize-space()='Staff Login']")
	private WebElement staffLoginbtn;
	
	@FindBy(xpath="//a[text()='Vendor Login']")
	private WebElement vendorLoginbtn;

	@FindBy(xpath="//button[text()='Guest Login']")
	private WebElement guestbtn;

	
	
	
	public WebElement getStaffLoginbtn() {
		return staffLoginbtn;
	}

	public void setStaffLoginbtn(WebElement staffLoginbtn) {
		this.staffLoginbtn = staffLoginbtn;
	}

	public WebElement getVendorLoginbtn() {
		return vendorLoginbtn;
	}

	public void setVendorLoginbtn(WebElement vendorLoginbtn) {
		this.vendorLoginbtn = vendorLoginbtn;
	}

	public WebElement getGuestbtn() {
		return guestbtn;
	}

	public void setGuestbtn(WebElement guestbtn) {
		this.guestbtn = guestbtn;
	}
	
	public void staffLogin() {
		elementClick(getStaffLoginbtn());
	}
	public void vendorLogin() {
		elementClick(getVendorLoginbtn());
	}
	public void guestLogin() {
		elementClick(getGuestbtn());
	}
}
