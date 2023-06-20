package org.learn.vtiger.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * SingleTon Class comprises of generic (Application-Independent) methods.
 * Utility methods are created via using library of {java , selenium
 * ,extentReports(AventStack)}
 * 
 * @author QA
 */
public  class Utility {

	private WebDriver driver;
	private ExtentTest extTest;

	private Utility() {

	}

	private static Utility ObjUtility;
	private static ExtentReports rep;

	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Description - returns Object of Utility as it is a singleton class its object
	 * can't be created
	 * 
	 * @param filename
	 * @param testCaseID_Name
	 * @return
	 */
	public static Utility getUtility() {

		if (ObjUtility == null) {
			ObjUtility = new Utility();
		}
		return ObjUtility;
	}

	/**
	 * @param repot_filename
	 * @param testcaseID_Name
	 */

	public void GenerateReport(String repot_filename) {
		try {
			rep = new ExtentReports();
			rep.attachReporter(new ExtentSparkReporter(
					new File("testLayer\\" + repot_filename + /* getDateTime("d-MMM-hh-mm-ss") + */".html")));
		} catch (Exception e) {
			System.out.println("report not created ");
		}
	}

	public void createTest(String testcaseID_Name) {
		try {
			extTest = rep.createTest(testcaseID_Name);
		} catch (Exception e) {
			System.out.println("ExtentTest refrence not initilized");
		}
	}

	/**
	 * generatesExtent Report file
	 */
	public void flushed() {
		try {
			rep.flush();
		} catch (Exception e) {
			System.out.println(" report not flushed");
		}
	}

	/**
	 * returns date in specified format
	 * 
	 * @return String
	 */
	public String getDateTime(String dateformat) {
		try {
			return new SimpleDateFormat(dateformat).format(new Date());
		} catch (Exception e) {
			extTest.log(Status.INFO, "Exception occured  during  fetching date . ");
		}
		return dateformat;
	}

	/**
	 * Takes ScreenShot and saves with Specified fileName
	 * 
	 * @param fileName
	 * @return String
	 */
	public void sS(String fileName) {
		try {
			File form = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String fullFileName = fileName + getDateTime("d-MMM-hh-mm-ss") + ".png";
			File to = new File("vTigerJava\\ScreenShot\\" + fullFileName);
			try {
				Files.copy(form, to);
				extTest.log(Status.INFO, "Unexpected result ,ScreenShot captured (" + fileName + ")");
			} catch (IOException e) {

				extTest.log(Status.INFO, "Exception occured  during  taking ScreenShot ");
			}
		} catch (Exception e) {

			extTest.log(Status.INFO, "Screen Shot not captured ");
		}
	}

//	public void launchBrowser(String browser) {
//
//		try {
//			String a = browser.toLowerCase();
//			switch (a) {
//			case "edge": {
//				WebDriverManager.edgedriver().setup();
//				driver = new EdgeDriver();
//				break;
//			}
//			case "chrome": {
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//				break;
//			}
//			case "firefox": {
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//				break;
//			}
//			case "ie": {
//				WebDriverManager.iedriver().setup();
//				driver = new EdgeDriver();
//				break;
//			}
//			default:
//				extTest.log(Status.INFO, " Invalid browser name :-  " + browser);
//			}
//		} catch (Exception e) {
//
//			extTest.log(Status.FAIL, "Exception occured while browser Launch  ");
//		} finally {
//			if (driver != null) {
//				extTest.log(Status.INFO, " browser Launched Sucessfully !");
//			} else
//				extTest.log(Status.FAIL, " browser not  Launched  !");
//		}
//	}

	public void launchBrowser(String browser) {

		try {
			if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
//				WebDriverManager.chromedriver().setup();
				ChromeOptions op = new ChromeOptions();
				op.addArguments("--remote-allow-origins=*");
				// op.addArguments("incognito");
				driver = new ChromeDriver(op);
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new EdgeDriver();
			} else
				extTest.log(Status.INFO, " Invalid browser name :-  " + browser);

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, "Exception occured while browser Launch  ");
		} finally {
			if (driver != null) {
				extTest.log(Status.INFO, " browser Launched Sucessfully !");
			} else
				extTest.log(Status.FAIL, " browser not  Launched  !");
		}
	}

	public void refreshPage() {
		
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			
		}
	}
	public void navigateBack() {
		
		try {
			driver.navigate().back();
		} catch (Exception e) {
			
		}
	}
	public void navigateForward() {

		try {
			driver.navigate().forward();
		} catch (Exception e) {

		}
	}
	
	
	

	public void closeBrowser() {
		try {

			driver.close();
			extTest.log(Status.INFO, " browser Closed Sucessfully !");
		} catch (Exception e) {
			extTest.log(Status.FAIL, " Exception occured while browser closure !");
		}
	}

	public void closeALLBrowser() {

		try {
			driver.quit();
			extTest.log(Status.INFO, " All  browser opened via automation process closed Sucessfully !");
		} catch (Exception e) {
			extTest.log(Status.FAIL, " Exception occured while browser closure !");
		}
	}

	public String getText(WebElement we, String elementName) {

		String text = "";
		try {
			text = we.getText();
			extTest.log(Status.INFO, "Fetched  Text from " + elementName + " is  " + text);
		} catch (Exception e) {
			extTest.log(Status.FAIL, "not able to fetch text of " + elementName);
		}
		return text;
	}

	public String getAttributeValue(WebElement we, String elementName, String attributeName) {

		String attributeValue = "";
		try {
			attributeValue = we.getAttribute(attributeName);
			extTest.log(Status.INFO,
					"Fetched  Text from " + elementName + " for " + attributeName + " is  " + attributeValue);
		} catch (Exception e) {

			extTest.log(Status.FAIL, "not able to fetch text of " + elementName);

		}
		return attributeValue;

	}

	public void hitURL(String url) {
		try {
			driver.get(url);
			extTest.log(Status.INFO, url + " hitted sucessfully !!");
		} catch (Exception s) {

			driver.navigate().to(url);
			extTest.log(Status.INFO, url + " hitted sucessfully !!");
		} catch (Throwable e) {

			extTest.log(Status.FAIL, "problem occured while Launch url Hitting ");
		}
	}

	/**
	 * verifies that TagName of an element on html page is same as specified or not
	 * 
	 * @param we
	 * @param tagName
	 * @return boolean
	 */
	private boolean isTagNameSameAsRequires(WebElement we, String tagName) {

		if (we.getTagName().equalsIgnoreCase(tagName))
			return true;
		extTest.log(Status.FAIL, "Given WebElement as Argument  isn't DropDown");
		return false;
	}

	public void selectDropdownOption(WebElement we, String elementName, String selectBy, Object value) {
		try {

			if (isTagNameSameAsRequires(we, "select")) {
				Select s = new Select(we);
				if (selectBy.equalsIgnoreCase("index"))
					s.selectByIndex((Integer) value);
				else if (selectBy.equalsIgnoreCase("name"))
					s.selectByVisibleText((String) value);
				else if (selectBy.equalsIgnoreCase("value"))
					s.selectByValue((String) value);
				else
					extTest.log(Status.FAIL, "INVALID Selectby type  :- " + selectBy);
				extTest.log(Status.INFO,
						"selected Dropdown option" + value + "  via selectBy" + selectBy + "()  for " + elementName);
			}

		} catch (UnexpectedTagNameException e) {
			extTest.log(Status.FAIL, "Given WebElement as Argument  isn't DropDown !");
		} catch (Exception e) {
			sS("Handle_DropDown");
		}
	}

	/**
	 * To Check if two Strings are equal(returns True)or not(returns False)
	 * @param actualText   pass actualText as String
	 * @param expectedText pass expctedText as String
	 * @param ElementName  To create a Detailed report using ExtentReport
	 */
	public boolean validateText(String actualText, String expectedText, String ElementName) {
		try {
			if (actualText.equals(expectedText)) {
				extTest.log(Status.PASS, ElementName + " is same as expected text");
				return true;
			}
			extTest.log(Status.PASS, ElementName + " mis-matched with expected text");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This Method is used to fetch all options of a dropDown , described with a
	 * locatorValue.
	 * 
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 * @return ArrayList<String> object which contains DropDown Options
	 */
	public ArrayList<String> getDropdownOptions(WebElement we, String elementName) {
		ArrayList<String> al = new ArrayList<String>();
		try {
			if (actionable(we, elementName)) {

				if (isTagNameSameAsRequires(we, "select")) {
					al = new ArrayList<String>();
					List<WebElement> a = new Select(we).getOptions();
					for (WebElement webElement : a) {
						String s = webElement.getText();
						al.add(s);
					}
					extTest.log(Status.INFO, "Dropdown options are :-" + al);
					return al;
				}
			}
		} catch (Exception e) {
			extTest.log(Status.FAIL, "not able to fetch options present in dropdown");
		}
		return al;
	}

	/**
	 * This method is used to locate an element on a webPage with help of given
	 * parameters.
	 * 
	 * @param locatorType
	 * @param locator
	 * @return WebElement
	 */
	public WebElement getWebElement(String locatorType, String locator) {
		WebElement we = null;
		try {
			if (locatorType.equalsIgnoreCase("xpath"))
				we = driver.findElement(By.xpath(locator));
			else if (locatorType.equalsIgnoreCase("name"))
				we = driver.findElement(By.name(locator));
			else if (locatorType.equalsIgnoreCase("id"))
				we = driver.findElement(By.id(locator));
			else if (locatorType.equalsIgnoreCase("css"))
				we = driver.findElement(By.cssSelector(locator));
			else if (locatorType.equalsIgnoreCase("classname"))
				we = driver.findElement(By.className(locator));
			else if (locatorType.equalsIgnoreCase("tagname"))
				we = driver.findElement(By.tagName(locator));
			else if (locatorType.equalsIgnoreCase("linktext"))
				we = driver.findElement(By.linkText(locator));
			else if (locatorType.equalsIgnoreCase("partiallinktext"))
				we = driver.findElement(By.partialLinkText(locator));
			else
				System.err.println("INVALID LOCATOR TYPE ");
		} catch (Exception e) {

			extTest.log(Status.INFO, "No Such Element present on webpage OR wrong locatorvalue");
		}
		return we;
	}

	public List<WebElement> getWebElements(String locatorType, String locator) {
		List<WebElement> we = new ArrayList<WebElement>();
		try {
			if (locatorType.equalsIgnoreCase("xpath"))
				we = driver.findElements(By.xpath(locator));
			else if (locatorType.equalsIgnoreCase("name"))
				we = driver.findElements(By.name(locator));
			else if (locatorType.equalsIgnoreCase("id"))
				we = driver.findElements(By.id(locator));
			else if (locatorType.equalsIgnoreCase("css"))
				we = driver.findElements(By.cssSelector(locator));
			else if (locatorType.equalsIgnoreCase("classname"))
				we = driver.findElements(By.className(locator));
			else if (locatorType.equalsIgnoreCase("tagname"))
				we = driver.findElements(By.tagName(locator));
			else if (locatorType.equalsIgnoreCase("linktext"))
				we = driver.findElements(By.linkText(locator));
			else if (locatorType.equalsIgnoreCase("partiallinktext"))
				we = driver.findElements(By.partialLinkText(locator));
			else
				System.err.println("INVALID LOCATOR TYPE ");
		} catch (Exception e) {

			extTest.log(Status.INFO, "No Such Element present on webpage OR wrong locatorvalue");
		}
		return we;
	}

	public void implicitlyWait(int timeINSeconds) {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeINSeconds));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public org.openqa.selenium.support.ui.WebDriverWait WebDriverWait(int time) {

		org.openqa.selenium.support.ui.WebDriverWait w = new org.openqa.selenium.support.ui.WebDriverWait(driver,
				Duration.ofSeconds(time));
		return w;
	}

	/**
	 * @param locatorType "name" OR "xPath" OR "
	 * @param locator
	 * @param element
	 * @param value
	 */
	public void send_WebElement(WebElement we, String element, String value) {

		try {
			we.sendKeys(value);
			extTest.log(Status.INFO, element + "(" + value + ") entered sucessfully");
		} catch (Exception e) {

			extTest.log(Status.FAIL, "exception occured while using sendkey WebElement" + element);
			e.printStackTrace();
		}
	}

	public void send_Actions(WebElement we, String element, String value) {

		try {
			new Actions(this.driver).sendKeys(we, value).build().perform();
			extTest.log(Status.INFO, element + "(" + value + ") entered sucessfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "exception occured while using sendkey Actions");
		}
	}

	public void send_JS(WebElement we, String element, String value) {

		try {
			JavascriptExecutor jsobj = (JavascriptExecutor) driver;
			jsobj.executeScript("arguments[0].Value=" + value + ";", we);
			extTest.log(Status.INFO, element + "(" + value + ") entered sucessfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "exception occured while using sendkey JavaScript");
		}
	}

	public void send3(WebElement we, String element, String value) {

		try {
			we.sendKeys(value);
			extTest.log(Status.INFO, element + "(" + value + ") entered sucessfully");
		} catch (ElementNotInteractableException e) {
			new Actions(this.driver).sendKeys(we, value).build().perform();
			extTest.log(Status.INFO, element + "(" + value + ") entered sucessfully");
		} catch (Exception w) {
			JavascriptExecutor jsobj = (JavascriptExecutor) driver;
			jsobj.executeScript("arguments[0].Value=" + value + ";", we);
			extTest.log(Status.INFO, element + "(" + value + ") entered sucessfully");
		} catch (Throwable e) {
			// new utility(driver, extTest).sS(element);
			extTest.log(Status.INFO, "Unable to type  on  " + element);
		}
	}

	public void click(WebElement we, String element) {

		try {
			we.click();
			extTest.log(Status.INFO, "clicked sucessfully on " + element);
		} catch (Exception e) {

			extTest.log(Status.FAIL, "exception occured while using click WebElement");
			e.printStackTrace();
		}
	}

	public void click_Actions(WebElement we, String element) {

		try {
			new Actions(this.driver).sendKeys(we).build().perform();
			extTest.log(Status.INFO, "clicked sucessfully on " + element);
		} catch (Exception e) {
			extTest.log(Status.FAIL, "exception occured while using click  Actions");
			e.printStackTrace();
		}
	}

	public void click_JS(WebElement we, String element) {

		try {
			JavascriptExecutor jsobj = (JavascriptExecutor) driver;
			jsobj.executeScript("arguments[0].click();", we);
			extTest.log(Status.INFO, "clicked sucessfully on " + element);
		} catch (Exception e) {
			extTest.log(Status.FAIL, "exception occured while using click JS");
			e.printStackTrace();
		}
	}

	public void mouseover_click(WebElement MouseOverOn, WebElement clickOnWebElement, String elementName) {
		// TODO Auto-generated method stub
		try {
			new Actions(driver).moveToElement(MouseOverOn).click(clickOnWebElement).perform();
			extTest.log(Status.INFO, "Clicked via mouse-over on " + elementName);
		} catch (Exception e) {
			extTest.log(Status.FAIL, " Exception occured while trying to mouse-over on " + elementName);
		}

	}

	public boolean actionable(WebElement we, String elementName) {

		boolean var = false;
		try {
			if (we.isDisplayed()) {
				extTest.log(Status.PASS, elementName + "   is visble.");
				if (we.isEnabled()) {
					extTest.log(Status.PASS, elementName + "   is clickable.");
					var = true;
				} else
					extTest.log(Status.FAIL, elementName + "  is not clickable.");
			} else
				extTest.log(Status.FAIL, elementName + "   is not visble.");
		} catch (Exception e) {
			sS(elementName);
		}
		return var;
	}

	public void isDisplayed(WebElement we, String elementName) {

		try {
			if (we.isDisplayed()) {
				extTest.log(Status.PASS, elementName + "   is visble.");

			} else
				extTest.log(Status.FAIL, elementName + "   is not visble.");
		} catch (Exception e) {
			sS(elementName);
		}
	}

	public void validateTextbox(WebElement we, String element, String valuetoSend) {

		try {
			if (actionable(we, element)) {
				we.clear();
				send3(we, element, valuetoSend);
			}
		} catch (Exception e) {
			sS(element);
		}
	}

	public void validateClickButton(WebElement we, String element) {
		try {
			if (actionable(we, element)) {
				click(we, element);
			}
		} catch (Exception e) {
			sS(element);
		}
	}

	private boolean isSelected(WebElement we, String element) {

		boolean a = we.isSelected();
		if (a) {
			extTest.log(Status.INFO, element + "   is  Selected By default.");
		}
		extTest.log(Status.INFO, element + "   is not Selected By default.");
		return a;
	}

	public String getPopUpMsg() {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = driver.switchTo().alert().getText();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return msg;
	}

	public void acceptPopUpMsg() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void dismissPopUpMsg() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void sendPopUpDescription(String Description) {
		try {
			driver.switchTo().alert().sendKeys(Description);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean validatePopUpMsg(String expextedMsg) {
		// TODO Auto-generated method stub
		boolean value = false;
		try {
			value = getPopUpMsg().equals(expextedMsg);
			if (value) {
				extTest.log(Status.PASS, "Error Msg is same as expected :-" + expextedMsg);
			} else {
				extTest.log(Status.FAIL, "Error Msg mis-matched with given (Current msg is " + getPopUpMsg() + ")");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return value;

	}

	public void validateCheckBox(WebElement we, String element) {

		try {
			if (actionable(we, element)) {
				boolean a = isSelected(we, element);
				we.click();
				boolean b = we.isSelected();
				if (a != b)
					extTest.log(Status.INFO, "checkbox " + element + " is Selectable and Deselectable .");
			}

		} catch (Exception e) {
			sS(element);
		}
	}

	/**
	 * 
	 * To verify specified webPage title with current webPageTitle
	 * 
	 * @param title
	 */
	public boolean validatePageTitle(String title) {
		boolean value = false;
		try {
			String currentPageTitle = driver.getTitle();
			value = currentPageTitle.equals(title);
			if (value) {
				extTest.log(Status.PASS, "Current pageTitle is same as expected :-" + title);
			} else
				extTest.log(Status.FAIL,
						"pageTitle mis-matched with given (Current title is " + currentPageTitle + ")");
		} catch (Exception e) {
			extTest.log(Status.FAIL, " exception occured   ,handeled  ");
		}
		return value;
	}

	public void validateSize(WebElement we, String elementName, int requiredHeight, int requiredWidth) {

		try {
			Dimension a = we.getSize();
			int actulalHeight = a.getHeight();
			int actulalWidth = a.getWidth();
			if (actulalHeight == requiredHeight)
				extTest.log(Status.INFO, elementName + " height verified ! (matched with expexcted result.) ");
			else
				extTest.log(Status.FAIL, elementName + " height  mis-matched with expexcted result.");
			if (actulalWidth == requiredWidth)
				extTest.log(Status.INFO, elementName + " width  verified ! (matched with expexcted result)");
			else
				extTest.log(Status.FAIL, elementName + " width  mis-matched with expexcted result");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "exception occured while elements size validation.");
		}
	}

	public void validatelocation(WebElement we, String elementName, int x_cordinate_Expected,
			int y_cordinate_Expected) {
		try {
			Point a = we.getLocation();
			int actual_X = a.x;
			int actual_Y = a.y;
			System.out.println(elementName + "   -->   " + x_cordinate_Expected + "=actual x cordinate "
					+ y_cordinate_Expected + "=actual y cordinate ");
			System.out.println(
					elementName + "   -->   " + actual_X + "=actual x cordinate " + actual_Y + "=actual y cordinate ");
			if (actual_X == x_cordinate_Expected)
				extTest.log(Status.INFO, elementName + "  X-cordinate  verified ! (matched with expexcted result) ");
			else
				extTest.log(Status.FAIL, elementName + " X-cordinate  mis-matched with expexcted result.");
			if (actual_Y == y_cordinate_Expected)
				extTest.log(Status.INFO, elementName + " Y-cordinate  verified ! (matched with expexcted result)");
			else
				extTest.log(Status.FAIL, elementName + " Y-cordinate  mis-matched with expexcted result.");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "exception occured while " + elementName + " location  validation. ");
		}
	}

	public void mouseOver(WebElement we, String elementName) {

		try {

			new Actions(driver).moveToElement(we).build().perform();
			extTest.log(Status.INFO, "mouse -overed on " + elementName);
		} catch (Exception e) {

			extTest.log(Status.FAIL, " Exception occured while trying to mouse-over on " + elementName);
		}
	}

	public String readDataFromProperties(String keyName) {

		InputStream objInputStream = null;
		try {
			objInputStream = new FileInputStream("src\\main\\resources\\configuration.properties");
		} catch (FileNotFoundException e) {

			extTest.log(Status.INFO, "File Not Found To Reoad Data");
		}
		Properties objProperties = new Properties();
		try {
			objProperties.load(objInputStream);
		} catch (IOException e) {
			extTest.log(Status.INFO, "Caught IOException -  if an error occurred when reading from the input stream.");
		} catch (IllegalArgumentException e) {
			extTest.log(Status.INFO,
					" Caught IllegalArgumentException -  input stream contains a malformed Unicode escape sequence.");
		} catch (NullPointerException e) {
			extTest.log(Status.INFO, "Caught NullPointerException -  inStream is null.");
		}
		String value = objProperties.getProperty(keyName);
		extTest.log(Status.INFO, "fetched value for given key ( " + keyName + " = " + value + " ) .");
		return value;
	}

//TO Fetch Test Data from Excel File and use in test script...returns cellvalue and 
	public Object readAllDataFromExcel() throws InvalidFormatException, IOException {
		File file = new File(System.getProperty("user.dir") + "\\AutomationFrameWork\\TestData\\excelnow.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int column = sheet.getRow(1).getLastCellNum();
		for (int r = 0; r <= rows; r++) {
			XSSFRow row = sheet.getRow(r);
			for (int c = 0; c <= column; c++) {
				XSSFCell cell = row.getCell(r);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					return cell.getStringCellValue();
				case NUMERIC:
					return cell.getNumericCellValue();
				case BOOLEAN:
					return cell.getBooleanCellValue();
				default:
					break;
				}
			}
		}
		workbook.close();
		inputStream.close();
		return 0;
	}
}
