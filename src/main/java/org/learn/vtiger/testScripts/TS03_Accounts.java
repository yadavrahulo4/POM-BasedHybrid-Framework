package org.learn.vtiger.testScripts;

import org.learn.vtiger.pages.home.home.HomePage;
import org.learn.vtiger.pages.login.LoginPage;
import org.learn.vtiger.pages.marketing.accounts.AccountsLandingPage;
import org.learn.vtiger.pages.marketing.accounts.CreateAccountsPage;
import org.learn.vtiger.utility.Utility;

public class TS03_Accounts extends BaseTest {

	private Utility objUtility ;
	public TS03_Accounts(Utility objUtility ) {
		// TODO Auto-generated constructor stub
		this.objUtility=objUtility;
	}

	public void tc001_ToTestVerifyAccountCreations(String testName_ID) {
		objUtility.createTest(testName_ID);
		objUtility.launchBrowser(objUtility.readDataFromProperties("browsername"));
		LoginPage loginPage = new LoginPage(objUtility);
		HomePage objHomePage = loginPage.validlogin();
		AccountsLandingPage accountsLandingPage = objHomePage.goToSubModuleAccountsViaMouseOver();
		CreateAccountsPage createAccountsPage = accountsLandingPage.clickCreateAccountBt();
		


		createAccountsPage.enterBasicInformation();
		createAccountsPage.MoreInformation();
		createAccountsPage.saveButtonBasicIInfoAbove();
//		objUtility.closeBrowser();

	}
}