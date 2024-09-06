package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

public class LoginPage extends BaseClass {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "Email Address")
	private WebElement emailId;

	@FindBy(id = "Password")
	private WebElement pswd;

	@FindBy(xpath = "//a[text()='Forgot Password?']")
	private WebElement forgetPassworslink;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitbtn;

	@FindBy(xpath = "//button[@class='btn btn-outline-secondary me-5 align-items-center']")
	private WebElement googlebtn;

	@FindBy(xpath = "//button[@class='btn btn-outline-secondary']")
	private WebElement facebookbtn;

	@FindBy(xpath = "//a[text()='Register Now']")
	private WebElement registernowLink;
	
	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getPswd() {
		return pswd;
	}

	public WebElement getForgetPassworslink() {
		return forgetPassworslink;
	}


	public WebElement getSubmitbtn() {
		return submitbtn;
	}


	public WebElement getGooglebtn() {
		return googlebtn;
	}


	public WebElement getFacebookbtn() {
		return facebookbtn;
	}

	public WebElement getRegisternowLink() {
		return registernowLink;
	}

	public void performLogin(String username, String password) {
		elementSendKeys(getEmailId(), username);
		elementSendKeys(getPswd(), password);
		elementClick(getSubmitbtn());
	}
	
}
