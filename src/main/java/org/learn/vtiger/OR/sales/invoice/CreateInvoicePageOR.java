package org.learn.vtiger.OR.sales.invoice;

import org.learn.vtiger.base.BaseOR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateInvoicePageOR extends BaseOR {
	public CreateInvoicePageOR(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

//BAsic info column
	@FindBy(xpath = "//b[text()='Basic Information']")
	private WebElement basicInfoColumn;
	@FindBy(name = "subject")
	private WebElement subjectTB;
	@FindBy(id = "customerno")
	private WebElement customerNoTB;
	@FindBy(name = "contact_name")
	private WebElement contactNameTB;
	@FindBy(id = "jscal_field_duedate")
	private WebElement dueDateTB;
	@FindBy(id = "exciseduty")
	private WebElement exciseDutyTB;
	@FindBy(id = "single_accountid")
	private WebElement AccountNameTB;
	@FindBy(xpath = "//input[@value='U']")
	private WebElement AssignedToUserRadioBT;
	@FindBy(xpath = "//input[@value='T']")
	private WebElement assignedToGroupRadioBT;
	@FindBy(name = "salesorder_name")
	private WebElement salesOrderTB;
	@FindBy(id = "jscal_field_invoicedate")
	private WebElement invoiceDateTB;
	@FindBy(id = "vtiger_purchaseorder")
	private WebElement purchaseOrderTB;
	@FindBy(id = "salescommission")
	private WebElement salesCommisionTB;
	@FindBy(xpath = "//select[@name='invoicestatus']")
	private WebElement statusDropDown;
	@FindBy(name = "bill_street")
	private WebElement billingAddressTB;
	@FindBy(id = "bill_pobox")
	private WebElement billingPostalBoxTB;
	@FindBy(id = "bill_city")
	private WebElement billingCityTB;
	@FindBy(id = "bill_state")
	private WebElement billingStateTB;
	@FindBy(id = "bill_code")
	private WebElement billingCodeTB;
	@FindBy(id = "bill_country")
	private WebElement billingCountryTB;
	@FindBy(xpath = "//b[text()='Copy Shipping address']//preceding-sibling::input")
	private WebElement coppyShippingAddressRadioBT;
	@FindBy(xpath = "//b[text()='Copy Billing address']//preceding-sibling::input")
	private WebElement coppyBillingAddressRadioBT;
	@FindBy(name = "ship_street")
	private WebElement shippingAddressTB;
	@FindBy(id = "ship_pobox")
	private WebElement shippingPostalBoxTB;
	@FindBy(id = "ship_city")
	private WebElement shippingCityTB;
	@FindBy(id = "ship_state")
	private WebElement shippingStateTB;
	@FindBy(id = "ship_code")
	private WebElement shippingCodeTB;
	@FindBy(id = "ship_country")
	private WebElement shippingCountryTB;
	@FindBy(xpath = "//input[contains(@name,'name')]/parent::td/parent::tr//preceding-sibling::tr//input[@title='Save [Alt+S]']")
	private WebElement saveBT1BasicInfo;
	@FindBy(xpath = "//input[contains(@name,'name')]/parent::td/parent::tr//preceding-sibling::tr//input[@title='Cancel [Alt+X]']")
	private WebElement cancelBT1BasicInfo;
	@FindBy(xpath = "//table[@class='crmTable']/parent::td/parent::tr//following-sibling::tr//input[@title='Save [Alt+S]']")
	private WebElement saveBT2BasicInfo;
	@FindBy(xpath = "//table[@class='crmTable']/parent::td/parent::tr//following-sibling::tr//input[@title='Cancel [Alt+X]']")
	private WebElement cancelBT2BasicInfo;
	// moreInformation table elements
	@FindBy(xpath = "//b[text()='More Information ']")
	private WebElement moreInfoColumn;
	@FindBy(xpath = "//textarea[@name='terms_conditions']")
	private WebElement terms_ConditionTB;
	@FindBy(name = "description")
	private WebElement descriptionTB;
	@FindBy(xpath = "//b[text()='Terms & Conditions']/parent::td/parent::tr/preceding-sibling::tr//input[@title='Save [Alt+S]']")
	private WebElement MoreInfoSaveBT1;
	@FindBy(xpath = "//b[text()='Terms & Conditions']/parent::td/parent::tr/preceding-sibling::tr//input[@title='Cancel [Alt+X]']")
	private WebElement MoreInfoCancelBT1;
	@FindBy(xpath = "//b[contains(text(),'Description Information')]/parent::td//parent::tr//following-sibling::tr//input[@title='Save [Alt+S]']")
	private WebElement MoreInfoSaveBT2;
	@FindBy(xpath = "//b[contains(text(),'Description Information')]/parent::td//parent::tr//following-sibling::tr//input[@title='Cancel [Alt+X]']")
	private WebElement MoreInfoCancelBT2;
	
	public WebElement getBasicInfoColumn() {
		return basicInfoColumn;
	}

	public WebElement getSubjectTB() {
		return subjectTB;
	}

	public WebElement getCustomerNoTB() {
		return customerNoTB;
	}

	public WebElement getContactNameTB() {
		return contactNameTB;
	}

	public WebElement getDueDateTB() {
		return dueDateTB;
	}

	public WebElement getExciseDutyTB() {
		return exciseDutyTB;
	}

	public WebElement getAccountNameTB() {
		return AccountNameTB;
	}

	public WebElement getAssignedToUserRadioBT() {
		return AssignedToUserRadioBT;
	}

	public WebElement getAssignedToGroupRadioBT() {
		return assignedToGroupRadioBT;
	}

	public WebElement getSalesOrderTB() {
		return salesOrderTB;
	}

	public WebElement getInvoiceDateTB() {
		return invoiceDateTB;
	}

	public WebElement getPurchaseOrderTB() {
		return purchaseOrderTB;
	}

	public WebElement getSalesCommisionTB() {
		return salesCommisionTB;
	}

	public WebElement getStatusDropDown() {
		return statusDropDown;
	}

	public WebElement getBillingAddressTB() {
		return billingAddressTB;
	}

	public WebElement getBillingPostalBoxTB() {
		return billingPostalBoxTB;
	}

	public WebElement getBillingCityTB() {
		return billingCityTB;
	}

	public WebElement getBillingStateTB() {
		return billingStateTB;
	}

	public WebElement getBillingCodeTB() {
		return billingCodeTB;
	}

	public WebElement getBillingCountryTB() {
		return billingCountryTB;
	}

	public WebElement getCoppyShippingAddressRadioBT() {
		return coppyShippingAddressRadioBT;
	}

	public WebElement getCoppyBillingAddressRadioBT() {
		return coppyBillingAddressRadioBT;
	}

	public WebElement getShippingAddressTB() {
		return shippingAddressTB;
	}

	public WebElement getShippingPostalBoxTB() {
		return shippingPostalBoxTB;
	}

	public WebElement getShippingCityTB() {
		return shippingCityTB;
	}

	public WebElement getShippingStateTB() {
		return shippingStateTB;
	}

	public WebElement getShippingCodeTB() {
		return shippingCodeTB;
	}

	public WebElement getShippingCountryTB() {
		return shippingCountryTB;
	}

	public WebElement getSaveBT1BasicInfo() {
		return saveBT1BasicInfo;
	}

	public WebElement getCancelBT1BasicInfo() {
		return cancelBT1BasicInfo;
	}

	public WebElement getSaveBT2BasicInfo() {
		return saveBT2BasicInfo;
	}

	public WebElement getCancelBT2BasicInfo() {
		return cancelBT2BasicInfo;
	}

	public WebElement getMoreInfoColumn() {
		return moreInfoColumn;
	}

	public WebElement getTerms_ConditionTB() {
		return terms_ConditionTB;
	}

	public WebElement getDescriptionTB() {
		return descriptionTB;
	}

	public WebElement getMoreInfoSaveBT1() {
		return MoreInfoSaveBT1;
	}

	public WebElement getMoreInfoCancelBT1() {
		return MoreInfoCancelBT1;
	}

	public WebElement getMoreInfoSaveBT2() {
		return MoreInfoSaveBT2;
	}

	public WebElement getMoreInfoCancelBT2() {
		return MoreInfoCancelBT2;
	}

}
