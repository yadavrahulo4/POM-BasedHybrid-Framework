package org.learn.vtiger.OR.marketing.accounts;

import org.learn.vtiger.base.BaseOR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountsPageOR extends BaseOR  {

	/**
	 * @return the basicIInfoColumn
	 */
	public WebElement getBasicIInfoColumn() {
		return basicIInfoColumn;
	}

	/**
	 * @return the moreIInfoColumn
	 */
	public WebElement getMoreIInfoColumn() {
		return moreIInfoColumn;
	}

	/**
	 * @return the accountnameTb
	 */
	public WebElement getAccountnameTb() {
		return accountnameTb;
	}

	/**
	 * @return the websiteTb
	 */
	public WebElement getWebsiteTb() {
		return websiteTb;
	}

	/**
	 * @return the phoneTb
	 */
	public WebElement getPhoneTb() {
		return phoneTb;
	}

	/**
	 * @return the faxTb
	 */
	public WebElement getFaxTb() {
		return faxTb;
	}

	/**
	 * @return the email1
	 */
	public WebElement getEmail1() {
		return email1;
	}

	/**
	 * @return the billingStreet
	 */
	public WebElement getBillingStreet() {
		return billingStreet;
	}

	/**
	 * @return the billingPostBox
	 */
	public WebElement getBillingPostBox() {
		return billingPostBox;
	}

	/**
	 * @return the billingCity
	 */
	public WebElement getBillingCity() {
		return billingCity;
	}

	/**
	 * @return the billingCityCode
	 */
	public WebElement getBillingCityCode() {
		return billingCityCode;
	}

	/**
	 * @return the billingCountry
	 */
	public WebElement getBillingCountry() {
		return billingCountry;
	}

	/**
	 * @return the billingaddress
	 */
	public WebElement getBillingaddress() {
		return billingaddress;
	}

	/**
	 * @return the descriptionTB
	 */
	public WebElement getDescriptionTB() {
		return DescriptionTB;
	}

	/**
	 * @return the otherPhoneTB
	 */
	public WebElement getOtherPhoneTB() {
		return otherPhoneTB;
	}

	/**
	 * @return the otherEmailTB
	 */
	public WebElement getOtherEmailTB() {
		return otherEmailTB;
	}

	/**
	 * @return the saveButtonBasicIInfoAbove
	 */
	public WebElement getSaveButtonBasicIInfoAbove() {
		return saveButtonBasicIInfoAbove;
	}

	/**
	 * @return the saveButtonBasicIInfoBelow
	 */
	public WebElement getSaveButtonBasicIInfoBelow() {
		return saveButtonBasicIInfoBelow;
	}

	/**
	 * @return the cancelButtonBasicIInfoAbove
	 */
	public WebElement getCancelButtonBasicIInfoAbove() {
		return cancelButtonBasicIInfoAbove;
	}

	/**
	 * @return the cancelButtonBasicIInfoBelow
	 */
	public WebElement getCancelButtonBasicIInfoBelow() {
		return cancelButtonBasicIInfoBelow;
	}

	@FindBy(id = "bi")
	private WebElement basicIInfoColumn;
	@FindBy(id = "mi")
	private WebElement moreIInfoColumn;
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement accountnameTb;
	@FindBy(xpath = "//input[@name='website']")
	private WebElement websiteTb;
	@FindBy(id = "phone")
	private WebElement phoneTb;
	@FindBy(id = "fax")
	private WebElement faxTb;
	@FindBy(id = "email1")
	private WebElement email1;
	@FindBy(name = "bill_street")
	private WebElement billingStreet;
	@FindBy(id = "bill_pobox")
	private WebElement billingPostBox;
	@FindBy(id = "bill_city")
	private WebElement billingCity;
	@FindBy(id = "bill_code")
	private WebElement billingCityCode;
	@FindBy(id = "bill_country")
	private WebElement billingCountry;
	@FindBy(xpath = "//b[text()='Copy Billing address']")
	private WebElement billingaddress;
	@FindBy(name = "description")
	private WebElement DescriptionTB;
	@FindBy(xpath = "otherphone")
	private WebElement otherPhoneTB;
	@FindBy(name = "email2")
	private WebElement otherEmailTB;
	
	@FindBy(xpath = "//input[contains(@name,'accountname')]/parent::td/parent::tr//preceding-sibling::tr//input[@title='Save [Alt+S]']")
	private WebElement saveButtonBasicIInfoAbove;
	@FindBy(xpath = "//b[contains(text(),'Description Information')]/parent::td//parent::tr//following-sibling::tr//input[@title='Save [Alt+S]']")
	private WebElement saveButtonBasicIInfoBelow;
	@FindBy(xpath = "//input[contains(@name,'accountname')]/parent::td/parent::tr//preceding-sibling::tr//input[@title='Cancel [Alt+X]']")
	private WebElement cancelButtonBasicIInfoAbove;
	@FindBy(xpath = "//b[contains(text(),'Description Information')]/parent::td//parent::tr//following-sibling::tr//input[@title='Cancel [Alt+X]']")
	private WebElement cancelButtonBasicIInfoBelow;
 

	
	public CreateAccountsPageOR(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
}
