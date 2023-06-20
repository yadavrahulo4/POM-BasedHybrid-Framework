package org.learn.vtiger.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseOR {

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutBt;

	//marketing
	@FindBy(xpath="//a[text()='Marketing']")
	private WebElement marketingModuleLink;
	
	@FindBy(xpath="//div[@id='Marketing_sub']//a[text()='Leads']")
	private WebElement marketing_leadsLinkOnMouseOver;
	
	
	
	//sales
	@FindBy(xpath="//a[text()='Sales']")
	private WebElement salesModuleLink;
	
	@FindBy(xpath="//div[@id='Sales_sub']//a[text()='Invoice']")
	private WebElement sales_InvoiceLinkOnMouseOver;
	
	public WebElement getSalesModuleLink() {
		return salesModuleLink;
	}
	public WebElement getSales_InvoiceLinkOnMouseOver() {
		return sales_InvoiceLinkOnMouseOver;
	}

	public WebElement getMarketingModuleLink() {
		return marketingModuleLink;
	}
	public WebElement getSignOutBt() {
		return signOutBt;
	}
	public WebElement getMarketing_leadsLinkOnMouseOver() {
		return marketing_leadsLinkOnMouseOver;
	}
	public BaseOR(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
}
