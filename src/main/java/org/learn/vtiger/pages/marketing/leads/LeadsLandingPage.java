package org.learn.vtiger.pages.marketing.leads;

import org.learn.vtiger.OR.marketing.leads.LeadsLandingPageOR;
import org.learn.vtiger.base.BasePage;
import org.learn.vtiger.utility.Utility;

public class LeadsLandingPage extends BasePage {

	private LeadsLandingPageOR or;
	private Utility objUtility;

	public LeadsLandingPage(Utility objUtility) {
		super(objUtility);
		this.objUtility = objUtility;
		or = new LeadsLandingPageOR(objUtility.getDriver());
		// TODO Auto-generated constructor stub
	}

	public CreateLeadPage CreateLeadBT() {
		// TODO Auto-generated method stub
		objUtility.click(or.getCreateLeadBt(), "Create Lead Button");
		return new CreateLeadPage(objUtility);
	}

}
