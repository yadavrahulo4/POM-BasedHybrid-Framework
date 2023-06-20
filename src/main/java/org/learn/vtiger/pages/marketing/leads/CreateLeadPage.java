package org.learn.vtiger.pages.marketing.leads;

import java.util.Map;

import org.learn.vtiger.OR.marketing.leads.CreateLeadsPageOR;
import org.learn.vtiger.base.BasePage;
import org.learn.vtiger.utility.Utility;

public class CreateLeadPage extends BasePage {

	private Utility objUtility;
	private CreateLeadsPageOR or;

	public CreateLeadPage(Utility objUtility) {
		super(objUtility);
		this.objUtility = objUtility;
		or = new CreateLeadsPageOR(objUtility.getDriver());
		// TODO Auto-generated constructor stub
	}

	/**
	 * To fill basic Details on Leads Page
	 * @param mapData
	 * @return CreateLeadPage object
	 */
	public void enterBasicInfo(Map<String, String> mapData) {
		// TODO Auto-generated method stub
		
		System.out.println(mapData.get("FirstName"));
		System.out.println(mapData.get("LastName"));
		System.out.println(mapData.get("Company"));
		
		objUtility.send_WebElement(or.getFirstNameTB(), " First Name TextBox", mapData.get("FirstName"));
		objUtility.send_WebElement(or.getLastNameTB(), " Last Name TextBox", mapData.get("LastName"));
		objUtility.send_WebElement(or.getCompanyTB(), " Company TextBox", mapData.get("Company"));
		objUtility.send_WebElement(or.getPhoneTB(), " Phone TextBox", mapData.get("Phone").toString());
		objUtility.send_WebElement(or.getMobileTB(), "Mobile TextBox", mapData.get("Mobile").toString());
		objUtility.send_WebElement(or.getFaxTB(), "Fax TextBox", mapData.get("fax").toString());
		objUtility.send_WebElement(or.getEmailTB(), "Email TextBox", mapData.get("E-mail"));
		objUtility.send_WebElement(or.getPoCodeTB(), "PostalCode TextBox", mapData.get("PostalCode"));
		objUtility.send_WebElement(or.getCityTB(), "City TextBox", mapData.get("City"));
		objUtility.send_WebElement(or.getStateTB(), "State TextBox", mapData.get("State"));
		objUtility.send_WebElement(or.getDescriptionTB(), "Discription TextBox", mapData.get("Description"));
	
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

}
