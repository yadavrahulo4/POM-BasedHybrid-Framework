package org.learn.vtiger.OR.marketing.accounts;

import org.learn.vtiger.base.BaseOR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsLandingPageOR extends BaseOR {

	public AccountsLandingPageOR(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@title='Create Account...']")
	private WebElement createAccountBt;
	
	public WebElement getCreateAccountBt() {
		return createAccountBt;
	}
}
