package org.learn.vtiger.pages.sales.invoice;

import org.learn.vtiger.OR.sales.invoice.InvoiceLandingPageOR;
import org.learn.vtiger.base.BasePage;
import org.learn.vtiger.utility.Utility;

public class InvoiceLandingPage extends BasePage {
	private Utility objUtility;
	private InvoiceLandingPageOR or;

	public InvoiceLandingPage(Utility objUtility) {
		super(objUtility);
		// TODO Auto-generated constructor stub
		this.objUtility = objUtility;
		or = new InvoiceLandingPageOR(objUtility.getDriver());
	}

	public CreateInvoicePage clickCreateInvoiveBT() {
		// TODO Auto-generated method stub
		objUtility.click(or.getCreateInvoiceBT(), "Create InVoice Button");
		return new CreateInvoicePage(objUtility);
	}

}
