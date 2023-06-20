package org.learn.vtiger.OR.login;

import org.learn.vtiger.base.BaseOR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOR extends BaseOR{

	@FindBy(name = "user_name")
	private WebElement usernameTB;

	@FindBy(name = "user_password")
	private WebElement userPasswordBT;

	@FindBy(name = "login_theme")
	private WebElement colorTheme;

	@FindBy(name = "login_language")
	private WebElement languageTheme;

	@FindBy(name = "Login")
	private WebElement loginBT;

	@FindBy(xpath = "//b")
	private WebElement errorMsg;

	public WebElement getErrorMsgOnInvalidLogin() {
		return errorMsg;
	}

	public WebElement getUsernameTB() {
		return usernameTB;
	}

	public WebElement getUserPasswordBT() {
		return userPasswordBT;
	}

	public WebElement getColorTheme() {
		return colorTheme;
	}

	public WebElement getLanguageTheme() {
		return languageTheme;
	}

	public WebElement getLoginBT() {
		return loginBT;
	}

	public LoginOR(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

}
