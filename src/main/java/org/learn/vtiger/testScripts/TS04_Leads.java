package org.learn.vtiger.testScripts;

import java.util.List;
import java.util.Map;

import org.learn.vtiger.pages.home.home.HomePage;
import org.learn.vtiger.pages.login.LoginPage;
import org.learn.vtiger.pages.marketing.leads.CreateLeadPage;
import org.learn.vtiger.pages.marketing.leads.LeadsLandingPage;
import org.learn.vtiger.utility.ExcelAutomation;
import org.learn.vtiger.utility.Utility;

public class TS04_Leads extends BaseTest {
	private Utility objUtility;

	public TS04_Leads(Utility objUtility) {
		// TODO Auto-generated constructor stub
		this.objUtility = objUtility;
	}

	public void tc001_createLeadWithTestData(String testCaseName_Id) {
		objUtility.createTest(testCaseName_Id); // -------**can we keep this in for loop present below
		objUtility.launchBrowser(objUtility.readDataFromProperties("browsername"));
		LoginPage loginPage = new LoginPage(objUtility);
		HomePage homePage = loginPage.validlogin();
		LeadsLandingPage leadsLandingPage = homePage.goToMarkretingLeads();
		CreateLeadPage createLeadPage = leadsLandingPage.CreateLeadBT();
		ExcelAutomation excel = new ExcelAutomation();
		List<Map<String, String>> listdata = excel.readAllData("LeadCreation");
		for (int i=1;i<listdata.size();i++) {
		Map<String,String>map=listdata.get(i);
			createLeadPage.enterBasicInfo(map);
			createLeadPage.saveButtonBasicIInfoAbove();
			if (map.get("Scenario").equals("InValid")) {
				objUtility.validatePopUpMsg(map.get("ErrorMsg"));
			} else {
				
				
				
				
				objUtility.navigateBack();
			}
			objUtility.refreshPage();

		}

		objUtility.closeBrowser();
	}
}
