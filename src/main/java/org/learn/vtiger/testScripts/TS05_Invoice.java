package org.learn.vtiger.testScripts;

import org.learn.vtiger.pages.home.home.HomePage;
import org.learn.vtiger.pages.login.LoginPage;
import org.learn.vtiger.pages.sales.invoice.CreateInvoicePage;
import org.learn.vtiger.pages.sales.invoice.InvoiceLandingPage;
import org.learn.vtiger.utility.ExcelAutomation;
import org.learn.vtiger.utility.Utility;

public class TS05_Invoice extends BaseTest {
	private Utility objUtility;

	public TS05_Invoice(Utility objUtility) {
		// TODO Auto-generated constructor stub
		this.objUtility = objUtility;
	}

	public void tc001_toCreateInvoice(String testCaseName_Id) {
		// TODO Auto-generated method stub
		objUtility.createTest(testCaseName_Id);
		objUtility.launchBrowser(objUtility.readDataFromProperties("browsername"));
		LoginPage loginPage = new LoginPage(objUtility);
		HomePage homePage = loginPage.validlogin();
		InvoiceLandingPage invoiceLandingPage = homePage.goToSalesInvoice();
		CreateInvoicePage createInvoicePage = invoiceLandingPage.clickCreateInvoiveBT();
		new ExcelAutomation().readAllData("");
		createInvoicePage.enterBasicInfo(null);
	}

}
