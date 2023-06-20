package org.learn.vtiger.pages.sales.invoice;

import java.util.Map;

import org.learn.vtiger.OR.sales.invoice.CreateInvoicePageOR;
import org.learn.vtiger.base.BasePage;
import org.learn.vtiger.utility.Utility;

public class CreateInvoicePage extends BasePage {

	private CreateInvoicePageOR or;
	private Utility objUtility;

	public CreateInvoicePage(Utility objUtility) {
		super(objUtility);
		or= new CreateInvoicePageOR(objUtility.getDriver());
		this.objUtility= objUtility;
	}
	
	public void enterBasicInfo(Map<String ,String> testData) {
		objUtility.send_WebElement(or.getSubjectTB(), "Subject TextBox", testData.get("Subject"));
		objUtility.send_WebElement(or.getCustomerNoTB(), "Customer No TextBox", testData.get("Customer No"));
		//objUtility.send_WebElement(or.getContactNameTB(), "Customer No TextBox", testData.get("Customer No"));
		//window handle......
		objUtility.send_WebElement(or.getDueDateTB(), "DueDate TextBox", testData.get("DueDate"));
		objUtility.send_WebElement(or.getExciseDutyTB(), "ExciseDuty TextBox", testData.get("ExciseDuty"));
		objUtility.send_WebElement(or.getAccountNameTB(), "AccountName TextBox", testData.get("AccountName"));
		objUtility.send_WebElement(or.getInvoiceDateTB(), "InvoiceDate TextBox", testData.get("InvoiceDate"));
		objUtility.send_WebElement(or.getPurchaseOrderTB(), "PurchaseOrder TextBox", testData.get("PurchaseOrder"));
		objUtility.send_WebElement(or.getSalesCommisionTB(), "SalesCommision TextBox", testData.get("SalesCommision"));
		objUtility.send_WebElement(or.getBillingAddressTB(), "BillingAddress TextBox", testData.get("BillingAddress"));
		objUtility.send_WebElement(or.getBillingPostalBoxTB(), "BillingPostalBox TextBox", testData.get("BillingPostalBox"));
		objUtility.send_WebElement(or.getBillingCityTB(), "BillingCity TextBox", testData.get("BillingCity"));
		objUtility.send_WebElement(or.getBillingStateTB(), "BillingState TextBox", testData.get("BillingState"));
		objUtility.send_WebElement(or.getBillingCodeTB(), "BillingPostalCode TextBox", testData.get("BillingPostalCode"));
		objUtility.send_WebElement(or.getBillingCountryTB(), "BillingCountry TextBox", testData.get("BillingCountry"));
		
		objUtility.click(or.getCoppyBillingAddressRadioBT(), "BillingPostalBox TextBox");
		objUtility.click(or.getSaveBT1BasicInfo(), "BillingPostalBox TextBox");
	}

}
