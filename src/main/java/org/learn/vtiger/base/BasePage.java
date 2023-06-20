package org.learn.vtiger.base;

import org.learn.vtiger.pages.login.LoginPage;
import org.learn.vtiger.pages.marketing.leads.LeadsLandingPage;
import org.learn.vtiger.pages.sales.invoice.InvoiceLandingPage;
import org.learn.vtiger.utility.Utility;

public class BasePage  {
	private Utility objUtility;
	private BaseOR baseOr;

	public BasePage(Utility objUtility) {
		// TODO Auto-generated constructor stub
		baseOr=new BaseOR(objUtility.getDriver());
		this.objUtility = objUtility;
	}

	public LoginPage signOut() {
		// TODO Auto-generated method stub
		objUtility.click(baseOr.getSignOutBt(), "SignOut Button");
		return new LoginPage(objUtility);
	}
	
	public LeadsLandingPage goToMarkretingLeads() {
		// TODO Auto-generated method stub
		objUtility.mouseover_click(baseOr.getMarketingModuleLink(),baseOr.getMarketing_leadsLinkOnMouseOver(), "Marketing-Leads Page");
		return new LeadsLandingPage(objUtility);
	}
	
	public InvoiceLandingPage goToSalesInvoice() {
		// TODO Auto-generated method stub
		objUtility.mouseover_click(baseOr.getSalesModuleLink(),baseOr.getSales_InvoiceLinkOnMouseOver(), "Sales-Invoice Page");
		return new InvoiceLandingPage(objUtility);
	}
	
}