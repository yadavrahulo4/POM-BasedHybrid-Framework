package org.learn.vtiger.pages.login;

import org.learn.vtiger.OR.login.LoginOR;
import org.learn.vtiger.base.BasePage;
import org.learn.vtiger.pages.home.home.HomePage;
import org.learn.vtiger.utility.Utility;

/**
 * @author yadavRahul
 */
public class LoginPage extends BasePage {

	private Utility objUtility;
	private LoginOR loginOr;

	public LoginPage(Utility objUtility) {
		super(objUtility);
		// TODO Auto-generated constructor stub
		loginOr = new LoginOR(objUtility.getDriver());
		this.objUtility = objUtility;
//		try {
//			PageFactory.initElements(objUtility.getDriver(), Class.forName("LoginPage"));
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * NonStatic method of {@link LoginPage}, used to launch ,hit
	 * ,enterValidCredentials ,clickLogin Button .
	 * 
	 * @return
	 * 
	 * @category Functionality_LoginPage
	 */
	public HomePage validlogin() {
		// TODO Auto-generated method stub
		login(objUtility.readDataFromProperties("username"), objUtility.readDataFromProperties("userpassword"));
		return new HomePage(objUtility);
	}

	/**
	 * Reusable method for login in case of multiple login Scenarios
	 * 
	 * @param userName
	 * @param password
	 */
	public void login(String userName, String password) {
		// TODO Auto-generated method stub
		objUtility.hitURL("http://localhost:8888");
		objUtility.send_WebElement(loginOr.getUsernameTB(), "User Name Box", userName);
		objUtility.send_WebElement(loginOr.getUserPasswordBT(), "Password Box", password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objUtility.click(loginOr.getLoginBT(), "LoginButton");
	}

	/**
	 * NonStatic method of {@link LoginPage}, used to get options present in
	 * ColourTheme DropDown on login Page .
	 * 
	 * @category Functionality_LoginPage
	 */
	public void getColorThemeOptions() {
		// TODO Auto-generated method stub
		objUtility.getDropdownOptions(loginOr.getColorTheme(), " Colour Theme Dropdown ");
	}

	/**
	 * NonStatic method of {@link LoginPage}, used to select a given option via
	 * given argument in Color Theme DropDown on login Page .
	 * 
	 * @category Functionality_LoginPage
	 * 
	 */
	public void SelectColourTheme(String selectType, Object value) {
		// TODO Auto-generated method stub
		objUtility.selectDropdownOption(loginOr.getColorTheme(), " Colour Theme Dropdown ", selectType, value);
	}

	/**
	 * NonStatic method of {@link LoginPage}, used to get options present in
	 * Language DropDown on login Page .
	 * 
	 * @category Functionality_LoginPage
	 */
	public void getLanguageOptions() {
		// TODO Auto-generated method stub
		objUtility.getDropdownOptions(loginOr.getLanguageTheme(), " Language Dropdown ");
	}

	/**
	 * NonStatic method of {@link LoginPage}, used to select a given option via
	 * given argument in Language DropDown.
	 * 
	 * @category Functionality_LoginPage
	 */
	public void SelectLanguageOptions(String selectType, Object value) {
		// TODO Auto-generated method stub
		objUtility.selectDropdownOption(loginOr.getLanguageTheme(), " Language Dropdown ", selectType, value);
	}
	
	/**
	 * 
	 * NonStatic method of {@link LoginPage}, used to launch ,hit ,enter InValid
	 * Credentials ,click Login Button .
	 * 
	 * @category Validation NegativeScenario
	 */
	public void InValidlogin() {
		// TODO Auto-generated method stub
		login(objUtility.readDataFromProperties("invalidusername"),
				objUtility.readDataFromProperties("invalidpassword"));
	}

	/**
	 * 
	 * NonStatic method of {@link LoginPage}, used to launch ,hit ,enter InValid
	 * Credentials ,click Login Button .
	 * 
	 * @category Functionality_LoginPage
	 */
	public String getErrorMsg() {
		// TODO Auto-generated method stub
		String msg=objUtility.getText(loginOr.getErrorMsgOnInvalidLogin(),"Error msg");
		return msg;
	}

	/**
	 * @category Validation Method
	 */
	public void validateUserNameBox() {
		// TODO Auto-generated method stub
		objUtility.actionable(loginOr.getUsernameTB(), "UserNameBox");
		objUtility.validatelocation(loginOr.getUsernameTB(), "UserNameBox", 640, 230);
		objUtility.validateSize(loginOr.getUsernameTB(), "UserNameBox", 22, 149);
	}

	/**
	 * @category Validation Method
	 */
	public void validatePasswordBox() {
		objUtility.actionable(loginOr.getUserPasswordBT(), "PasswordBox");
		objUtility.validatelocation(loginOr.getUserPasswordBT(), "PasswordBox", 640, 262);
		objUtility.validateSize(loginOr.getUserPasswordBT(), "PasswordBox", 22, 149);
	}

	/**
	 * @category Validation Method
	 */
	public void validateLoginButton() {
		objUtility.actionable(loginOr.getLoginBT(), "Login Button");
		objUtility.validatelocation(loginOr.getLoginBT(), "Login Button", 640, 350);
		objUtility.validateSize(loginOr.getLoginBT(), "Login Button", 40, 138);
	}
}