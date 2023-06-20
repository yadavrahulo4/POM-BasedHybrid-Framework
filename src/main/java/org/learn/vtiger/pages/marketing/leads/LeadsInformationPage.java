package org.learn.vtiger.pages.marketing.leads;

import org.learn.vtiger.OR.marketing.leads.LeadsInformationPageOR;
import org.learn.vtiger.base.BasePage;
import org.learn.vtiger.utility.Utility;

public class LeadsInformationPage extends BasePage {
	
	private Utility objUtility;
	private LeadsInformationPageOR or;

	/**
	 * Parameterized constructor To use generic Method
	 * 
	 * @param objUtility
	 */
	public LeadsInformationPage(Utility objUtility) {
		// TODO Auto-generated constructor stub
		super(objUtility);
		this.objUtility = objUtility;
	or=	new LeadsInformationPageOR(objUtility.getDriver());
	}
	
	
}
