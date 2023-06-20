package org.learn.vtiger.pages.home.home;

import org.learn.vtiger.OR.home.home.HomeOR;
import org.learn.vtiger.base.BasePage;
import org.learn.vtiger.pages.marketing.accounts.AccountsLandingPage;
import org.learn.vtiger.utility.Utility;

public class HomePage extends BasePage {
	
	private Utility objUtility;
	private HomeOR homeOR;

	public HomePage(Utility objUtility) {
		// TODO Auto-generated construcstub
		super(objUtility);
		homeOR= new HomeOR(objUtility.getDriver());
		this.objUtility = objUtility;
	}

	public void goToMarketingsLandingPage() {
		objUtility.click(homeOR.getMarketingsModule(), " Marketings Landing page ");
		objUtility.validatePageTitle("admin - Marketing - Campaigns - vtiger CRM 5 - Commercial Open Source CRM");
	}

	public void goToSalesLandingPage() {
		objUtility.click(homeOR. getSalesModule(), "Sales Landing page");
		objUtility.validatePageTitle("admin - Sales - Leads - vtiger CRM 5 - Commercial Open Source CRM");
	}

	public void goToSupportLandingPage() {
		objUtility.click(homeOR. getSupportModule(), "Support Landing page");
		objUtility.validatePageTitle("admin - Support - Trouble Tickets - vtiger CRM 5 - Commercial Open Source CRM");
	}

	public void goToAnalyticsLandingPage() {
		objUtility.click(homeOR.getAnalyticsModule(), "Analytics Landing page");
		objUtility.validatePageTitle("admin - Analytics - Reports - vtiger CRM 5 - Commercial Open Source CRM");
	}

	public void goToInventoryLandingPage() {
		objUtility.click(homeOR.getInventoryModule(), "Inventory Landing page");
		objUtility.validatePageTitle("admin - Inventory - Products - vtiger CRM 5 - Commercial Open Source CRM");
	}

	public void goToSettingsLandingPage() {
		objUtility.click(homeOR.getSettingsModule(), "Settings Landing page");
		objUtility.validatePageTitle("admin - Settings - Settings - vtiger CRM 5 - Commercial Open Source CRM");
	}

	public void goToToolsLandingPage() {
		objUtility.click(homeOR.getToolsModule(), "Tools Landing page");
		objUtility.validatePageTitle("admin - Tools - RSS - vtiger CRM 5 - Commercial Open Source CRM");
	}

	public void goToSubModuleCalenderPageViaMouseOver() {
		objUtility.mouseOver(homeOR.getMyHomePageModule(), " MyHomepage Module ");
		objUtility.click(homeOR.getCalenderSubModuleOnMouseOver(), "Calendar sub-Module");
	}

	public void goToSubModuleCalenderPage() {
		objUtility.click(homeOR.getCalenderSubModule(), "Calendar sub-Module");
	}

	public void goToSubModuleWebmailPageViaMouseOver() {
		objUtility.mouseOver(homeOR.getMyHomePageModule(), " MyHomepage Module ");
		objUtility.click(homeOR.getWebMailSubModuleOnMouseOver(), "Webmail sub-Module");
	}

	public void goToSubModuleWebmailPage() {
		objUtility.click(homeOR.getWebMailSubModule(), "Webmail sub-Module");
	}

	public AccountsLandingPage goToSubModuleAccountsViaMouseOver() {
		objUtility.mouseOver(homeOR.getMarketingsModule(), "Accounts Module");
		objUtility.click(homeOR.getAccountsSubModule_Marketing(), "Home sub-Module");
		return new AccountsLandingPage(objUtility);
	}

}
