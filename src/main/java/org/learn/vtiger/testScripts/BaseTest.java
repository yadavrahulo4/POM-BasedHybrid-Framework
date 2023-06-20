package org.learn.vtiger.testScripts;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.learn.vtiger.pages.home.home.HomePage;
import org.learn.vtiger.pages.login.LoginPage;
import org.learn.vtiger.utility.ExcelAutomation;
import org.learn.vtiger.utility.Utility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	protected Utility utl;
	protected HomePage homePage;
	protected String name;
	protected List<Map<String, String>> totalListData;
	public LoginPage loginobj;

	@Parameters("reportFileName")
	@BeforeSuite
	public void reportSetUp(@Optional("htmlReport") String fileName) {
		utl = Utility.getUtility();
		utl.GenerateReport(fileName);
	}

	@Parameters("testCaseId")
	@BeforeMethod
	public void launch_hitUrl_SetUp(@Optional("testCase00") String testCaseId,Method m) {
		name = m.getName();
//		if(name.equals("tc001_verifyLoginWithValidCredentials")|| name.equals("tc002_verifyLoginWithInValidCredentials")) {
//			
//		}else {
//			totalListData = ExcelAutomation.readAllData(name);
//		}
		utl.createTest(testCaseId);
		utl.launchBrowser("chrome");
		utl.hitURL(utl.readDataFromProperties("url"));
		loginobj = new LoginPage(utl);
		homePage = loginobj.validlogin();
	}
	@DataProvider(name = "TestData")
	public Object[][] dataprovider() {
		totalListData= ExcelAutomation.readAllData("tc003LoginWithMultipleData");
		Object[] [] listdata= new Object[totalListData.size()][1];
		for (int i = 0; i < totalListData.size()-1; i++) {
			Object objMap= totalListData.get(i);
			listdata[i][0]=objMap;
		}
		return listdata;
	}


	@AfterMethod
	public void Logout(ITestResult result) {
		int status = result.getStatus();
		if (status == ITestResult.FAILURE) {
			utl.sS(name);
		}
		homePage.signOut();
		utl.closeALLBrowser();
	}

	@AfterSuite
	public void flushReort() {
		utl.flushed();
	}

}