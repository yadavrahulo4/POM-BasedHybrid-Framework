package org.learn.vtiger.pages.home.calender;

import org.learn.vtiger.utility.Utility;
import org.openqa.selenium.support.PageFactory;

public class CalenderPage {
	private Utility objUtility;

	public CalenderPage(Utility objUtility) {
		// TODO Auto-generated constructor stub
		this.objUtility = objUtility;
		PageFactory.initElements(objUtility.getDriver(), this);

	}

}
