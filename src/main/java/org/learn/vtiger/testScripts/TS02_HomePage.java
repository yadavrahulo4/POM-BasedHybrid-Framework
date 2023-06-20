package org.learn.vtiger.testScripts;

import org.learn.vtiger.pages.home.home.HomePage;
import org.learn.vtiger.pages.login.LoginPage;
import org.learn.vtiger.utility.Utility;

public class TS02_HomePage extends BaseTest {
	private Utility objUtility ;
	public TS02_HomePage(Utility objUtility2) {
		// TODO Auto-generated constructor stub
		this.objUtility= objUtility2;
	}

	/**
	 * To test and verify signOut from Marketings Landing Page Module.
	 * 
	 * @category HomePageTestCase
	 * @param testName_ID
	 */

	public void toTest_VerifySignOut(String testName_ID) {
		// TODO Auto-generated constructor stub
		objUtility.createTest(testName_ID);
		objUtility.launchBrowser(objUtility.readDataFromProperties("browsername"));
		
		LoginPage objLoginPage = new LoginPage(objUtility);
		HomePage objHomePage = objLoginPage.validlogin();

		objHomePage.goToMarketingsLandingPage();
		objLoginPage.signOut();
		objUtility.closeBrowser();
	}

	/**
	 * To test and verify signOut from Home Page Module.
	 *
	 * @category HomePageTestCase
	 * @param testName_ID
	 */
	public void toTest_VerifyAllMainModules(String testName_ID) {
		// TODO Auto-generated constructor stub
		objUtility.createTest(testName_ID);

		objUtility.launchBrowser(objUtility.readDataFromProperties("browsername"));
		LoginPage objLoginPage = new LoginPage(objUtility);

		HomePage objHomePage = objLoginPage.validlogin();
		objHomePage.goToMarketingsLandingPage();
		objHomePage.goToSalesLandingPage();
		objHomePage.goToSupportLandingPage();
		objHomePage.goToAnalyticsLandingPage();
		objHomePage.goToInventoryLandingPage();
		objHomePage.goToToolsLandingPage();
		objHomePage.goToSettingsLandingPage();

		objUtility.closeBrowser();
	}
}
