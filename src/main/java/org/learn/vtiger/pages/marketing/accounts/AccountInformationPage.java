package org.learn.vtiger.pages.marketing.accounts;

import org.learn.vtiger.OR.marketing.accounts.AccountsInformationPageOR;
import org.learn.vtiger.base.BasePage;
import org.learn.vtiger.utility.Utility;

public class AccountInformationPage extends BasePage {
	private Utility objUtility;
	private AccountsInformationPageOR or;

	/**
	 * Parameterized constructor To use generic Method
	 * 
	 * @param objUtility
	 */
	public AccountInformationPage(Utility objUtility) {
		// TODO Auto-generated constructor stub
		super(objUtility);
		this.objUtility = objUtility;
	or=	new AccountsInformationPageOR(objUtility.getDriver());
	}
	
}