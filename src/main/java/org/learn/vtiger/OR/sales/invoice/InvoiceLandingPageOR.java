package org.learn.vtiger.OR.sales.invoice;

import org.learn.vtiger.base.BaseOR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoiceLandingPageOR extends BaseOR {

	public InvoiceLandingPageOR(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Invoice...']")
	private WebElement createInvoiceBT;
	
	public WebElement getCreateInvoiceBT() {
		return createInvoiceBT;
	}
}
