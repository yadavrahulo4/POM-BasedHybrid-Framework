package org.learn.vtiger.testScripts;

import java.util.Map;

import org.testng.annotations.Test;

public class TS01_Login extends BaseTest {
	/**
	 * @category TestScript
	 * @scenario To test and verify login using valid credentials and also validate
	 *           homePage title after valid Login.
	 * @param testCaseName_Id - To create unique testCase in ExtentReport html File.
	 */
	@Test
	public void tc001_verifyLoginWithValidCredentials() {
		utl.validatePageTitle("admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM");
	}

	/**
	 * @param string
	 * @category TestScript
	 * @scenario To test and verify login using InValid credentials and also
	 *           validate Login title after valid Login.
	 * @param testCaseName_Id To identify testCase uniquely
	 */
	@Test
	public void tc002_verifyLoginWithInValidCredentials() {
		homePage.signOut();
	    loginobj.InValidlogin();
		utl.validatePageTitle("vtiger CRM 5 - Commercial Open Source CRM");
	}

	/**
	 * @param string
	 * @category TestScript
	 * @scenario To test and verify login using Multiple credentials and also
	 *           validate Login title after valid Login and verify error message in
	 *           case of inValid Login.
	 * @param testCaseName_Id To identify testCase uniquely
	 */
	@Test(dataProvider = "TestData")
	public void tc003LoginWithMultipleData() {
//		objUtility.createTest(testCaseName_Id); // -------**can we keep this in for loop present below
//		objUtility.launchBrowser(objUtility.readDataFromProperties("browsername"));
//		LoginPage loginPage = new LoginPage(objUtility);
//		ExcelAutomation objAutomation = new ExcelAutomation();
//		List<Map<String, String>> totalListData = objAutomation.readAllData("LoginTestData");
		for (int i = 1; i < super.totalListData.size(); i++) {
			Map<String, String> map = totalListData.get(i);
			String username = map.get("UserName");
			String password = map.get("Password");
			loginobj.login(username, password);
			if (map.get("Scenario").equals("InValid")) {
				utl.validateText(loginobj.getErrorMsg(), map.get("ErrorMsg"), "Error Message");
			} else {
				utl.validatePageTitle("admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM");
				super.loginobj.signOut();
			}
		}
	}
}