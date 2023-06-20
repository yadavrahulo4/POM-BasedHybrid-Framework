package org.learn.vtiger.OR.marketing.leads;

import org.learn.vtiger.base.BaseOR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadsPageOR extends BaseOR {

	@FindBy(name = "firstname")
	private WebElement firstNameTB;
	@FindBy(name = "lastname")
	private WebElement lastNameTB;
	@FindBy(xpath="//input[@name = 'company']")
	private WebElement companyTB;
	@FindBy(name = "designation")
	private WebElement titleTB;
	@FindBy(id = "phone")
	private WebElement phoneTB;
	@FindBy(id = "mobile")
	private WebElement mobileTB;
	@FindBy(id = "fax")
	private WebElement faxTB;
	@FindBy(id = "email")
	private WebElement emailTB;
	@FindBy(name = "lane")
	private WebElement streetTB;
	@FindBy(id = "code")
	private WebElement poCodeTB;
	@FindBy(id = "country")
	private WebElement countryTB;
	@FindBy(id = "pobox")
	private WebElement poboxTB;
	@FindBy(id = "city")
	private WebElement cityTB;
	@FindBy(id = "state")
	private WebElement stateTB;
	@FindBy(name = "description")
	private WebElement descriptionTB;
	@FindBy(xpath = "//input[contains(@name,'name')]/parent::td/parent::tr//preceding-sibling::tr//input[@title='Save [Alt+S]']")
	private WebElement saveButtonBasicIInfoAbove;
	@FindBy(xpath = "//b[contains(text(),'Description Information')]/parent::td//parent::tr//following-sibling::tr//input[@title='Save [Alt+S]']")
	private WebElement saveButtonBasicIInfoBelow;
	@FindBy(xpath = "//input[contains(@name,'name')]/parent::td/parent::tr//preceding-sibling::tr//input[@title='Cancel [Alt+X]']")
	private WebElement cancelButtonBasicIInfoAbove;
	@FindBy(xpath = "//b[contains(text(),'Description Information')]/parent::td//parent::tr//following-sibling::tr//input[@title='Cancel [Alt+X]']")
	private WebElement cancelButtonBasicIInfoBelow;

	/**
	 * @return the firstNameTB
	 */
	public WebElement getFirstNameTB() {
		return firstNameTB;
	}

	/**
	 * @return the lastNameTB
	 */
	public WebElement getLastNameTB() {
		return lastNameTB;
	}

	/**
	 * @return the companyTB
	 */
	public WebElement getCompanyTB() {
		return companyTB;
	}

	/**
	 * @return the designationTB
	 */
	public WebElement getTitleTB() {
		return titleTB;
	}

	/**
	 * @return the phoneTB
	 */
	public WebElement getPhoneTB() {
		return phoneTB;
	}

	/**
	 * @return the mobileTB
	 */
	public WebElement getMobileTB() {
		return mobileTB;
	}

	/**
	 * @return the faxTB
	 */
	public WebElement getFaxTB() {
		return faxTB;
	}

	/**
	 * @return the emailTB
	 */
	public WebElement getEmailTB() {
		return emailTB;
	}

	/**
	 * @return the streetTB
	 */
	public WebElement getStreetTB() {
		return streetTB;
	}

	/**
	 * @return the poCodeTB
	 */
	public WebElement getPoCodeTB() {
		return poCodeTB;
	}

	/**
	 * @return the countryTB
	 */
	public WebElement getCountryTB() {
		return countryTB;
	}

	/**
	 * @return the poboxTB
	 */
	public WebElement getPoboxTB() {
		return poboxTB;
	}

	/**
	 * @return the cityTB
	 */
	public WebElement getCityTB() {
		return cityTB;
	}

	/**
	 * @return the stateTB
	 */
	public WebElement getStateTB() {
		return stateTB;
	}

	/**
	 * @return the descriptionTB
	 */
	public WebElement getDescriptionTB() {
		return descriptionTB;
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

	public CreateLeadsPageOR(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
}
