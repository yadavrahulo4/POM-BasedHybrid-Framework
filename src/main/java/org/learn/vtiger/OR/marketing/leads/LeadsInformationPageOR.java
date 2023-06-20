package org.learn.vtiger.OR.marketing.leads;

import org.learn.vtiger.base.BaseOR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LeadsInformationPageOR extends BaseOR {

	public LeadsInformationPageOR(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	

}
