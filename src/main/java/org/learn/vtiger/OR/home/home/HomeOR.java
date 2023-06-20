package org.learn.vtiger.OR.home.home;

import org.learn.vtiger.base.BaseOR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeOR extends BaseOR {
	public HomeOR(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//a[text()='My Home Page']")
	private WebElement myHomePageModule;
	@FindBy(xpath = "//a[text()='Marketing']")
	private WebElement marketingsModule;
	@FindBy(xpath = "//a[text()='Sales']")
	private WebElement salesModule;
	@FindBy(xpath = "//a[text()='Support']")
	private WebElement supportModule;
	@FindBy(xpath = "//a[text()='Analytics']")
	private WebElement analyticsModule;
	@FindBy(xpath = "//a[text()='Inventory']")
	private WebElement inventoryModule;
	@FindBy(xpath = "//a[text()='Settings']")
	private WebElement settingsModule;
	@FindBy(xpath = "//a[text()='Tools']")
	private WebElement toolsModule;
	@FindBy(xpath = "//div[@id='My Home Page_sub']//a[text()='Calendar']")
	private WebElement calenderSubModuleOnMouseOver;
	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Calendar']")
	private WebElement calenderSubModule;
	@FindBy(xpath = "//div[@id='My Home Page_sub']//a[text()='Webmail']")
	private WebElement webMailSubModuleOnMouseOver;
	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Webmail']")
	private WebElement webMailSubModule;
	@FindBy(xpath = "//div[@id='Marketing_sub']//a[text()='Accounts']")
	private WebElement accountsSubModule_Marketing;

	public WebElement getMarketingsModule() {
		return marketingsModule;
	}

	public WebElement getSalesModule() {
		return salesModule;
	}

	public WebElement getSupportModule() {
		return supportModule;
	}

	public WebElement getAnalyticsModule() {
		return analyticsModule;
	}

	public WebElement getInventoryModule() {
		return inventoryModule;
	}

	public WebElement getSettingsModule() {
		return settingsModule;
	}

	public WebElement getToolsModule() {
		return toolsModule;
	}

	public WebElement getMyHomePageModule() {
		return myHomePageModule;
	}

	public WebElement getCalenderSubModuleOnMouseOver() {
		return calenderSubModuleOnMouseOver;
	}

	public WebElement getCalenderSubModule() {
		return calenderSubModule;
	}

	public WebElement getWebMailSubModuleOnMouseOver() {
		return webMailSubModuleOnMouseOver;
	}

	public WebElement getWebMailSubModule() {
		return webMailSubModule;
	}

	public WebElement getAccountsSubModule_Marketing() {
		return accountsSubModule_Marketing;
	}

}
