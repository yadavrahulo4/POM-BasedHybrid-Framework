package org.learn.vtiger.pages.marketing.accounts;

import org.learn.vtiger.OR.marketing.accounts.AccountsLandingPageOR;
import org.learn.vtiger.base.BasePage;
import org.learn.vtiger.utility.Utility;

public class AccountsLandingPage extends BasePage {
	private Utility objUtility;
	private AccountsLandingPageOR or;

	public AccountsLandingPage(Utility objUtility) {
		// TODO Auto-generated constructor stub
		super(objUtility);
		or = new AccountsLandingPageOR(objUtility.getDriver());
		this.objUtility = objUtility;
	}

	public CreateAccountsPage clickCreateAccountBt() {
		// TODO Auto-generated method stub
		objUtility.click(or.getCreateAccountBt(), "Create Account Button");
		return new CreateAccountsPage(objUtility) ;
	}

	
}
