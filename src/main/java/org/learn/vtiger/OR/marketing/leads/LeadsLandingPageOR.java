package org.learn.vtiger.OR.marketing.leads;

import org.learn.vtiger.base.BaseOR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsLandingPageOR extends BaseOR{

	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement CreateLeadBt;

	public LeadsLandingPageOR(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateLeadBt() {
		return CreateLeadBt;
	}
	
}
