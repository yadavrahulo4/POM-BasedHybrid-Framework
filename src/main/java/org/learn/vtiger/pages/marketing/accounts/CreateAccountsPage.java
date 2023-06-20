package org.learn.vtiger.pages.marketing.accounts;

import org.learn.vtiger.OR.marketing.accounts.CreateAccountsPageOR;
import org.learn.vtiger.base.BasePage;
import org.learn.vtiger.utility.Utility;

public class CreateAccountsPage extends BasePage {
	private CreateAccountsPageOR or;

	public CreateAccountsPage(Utility objUtility) {
		// TODO Auto-generated constructor stub
		super(objUtility);
		or = new CreateAccountsPageOR(objUtility.getDriver());
		this.objUtility = objUtility;
	}

	private Utility objUtility;

	public void enterBasicInformation() {
		// TODO Auto-generated method stub
		objUtility.click(or.getBasicIInfoColumn(), "Basic Information Column");
		objUtility.send_WebElement(or.getAccountnameTb(), "Account Name TextBox", "Rahul Yadav");
		objUtility.send_WebElement(or.getWebsiteTb(), "Website TextBox", "rahulyadavo4official.com");
		objUtility.send_WebElement(or.getPhoneTb(), "phone no. TextBox", "9336638306");
		objUtility.send_WebElement(or.getFaxTb(), "Fax no. TextBox", "d34fzxr566y");
		objUtility.send_WebElement(or.getEmail1(), "Email. TextBox", "yadavrahulo4new@gmail.com");
		objUtility.send_WebElement(or.getBillingStreet(), "Address TextBox", "india up");
		objUtility.send_WebElement(or.getBillingPostBox(), "Billing PoBox TextBox", "kukrauthi");
		objUtility.send_WebElement(or.getBillingCity(), "Biling City TextBox ", "bhadohi");
		objUtility.send_WebElement(or.getBillingCityCode(), "Billing PostalCodeCode TextBox", "221409");
		objUtility.send_WebElement(or.getBillingCountry(), "Billing country TextBox", "INDIA");
		objUtility.click(or.getBillingaddress(), "coppy billing Address radioButton ");
		objUtility.send_WebElement(or.getDescriptionTB(), "Description TextBox",
				"Your Account creation is in progress");
	}

	/**
	 * To click on save Button present in middle at top of create Account Page
	 */
	public void saveButtonBasicIInfoAbove() {
		// TODO Auto-generated method stub
		objUtility.click(or.getSaveButtonBasicIInfoAbove(), "Save Button");
	}

	/**
	 * To click on save Button present in middle at bottom of create Account Page
	 */
	public void saveButtonBasicIInfoBelow() {
		// TODO Auto-generated method stub
		objUtility.click(or.getSaveButtonBasicIInfoBelow(), "Save Button");
	}

	/**
	 * To click on cancel Button present in middle at top of create Account Page
	 */
	public void cancelButtonBasicIInfoAbove() {
		// TODO Auto-generated method stub
		objUtility.click(or.getCancelButtonBasicIInfoAbove(), "Cancel Button");
	}

	/**
	 * To click on save Cancel present in middle at bottom of create Account Page
	 */
	public void cancelButtonBasicIInfoBelow() {
		// TODO Auto-generated method stub
		objUtility.click(or.getCancelButtonBasicIInfoBelow(), "Cancel Button");
	}

	public void MoreInformation() {
		// TODO Auto-generated method stub
		objUtility.click(or.getMoreIInfoColumn(), "More Information Column");
		objUtility.send_WebElement(or.getOtherPhoneTB(), "OtherPhone No. TextBox", "12345678");
		objUtility.send_WebElement(or.getOtherEmailTB(), "Other. TextBox", "12345678");
	}
}
