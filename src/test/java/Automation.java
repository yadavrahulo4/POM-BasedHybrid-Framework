import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation {
	public ExtentTest extTest; // do it private
	public WebDriver driver; // do it private
	private ExtentReports rep;

	/**
	 * creates Extent report file
	 * 
	 * @param TestnameID
	 * @return utility
	 */

	protected void report(String filename) {
		try {
			rep = new ExtentReports();
			rep.attachReporter(new ExtentSparkReporter(
					new File("testLayer\\" + filename + getDateTime("d-MMM-hh-mm-ss") + ".html")));
		} catch (Exception e) {
			System.out.println("report not created ");
		}
	}

	/**
	 * instantiate new test case in ExtentReport
	 * 
	 * @param TestnameID
	 */
	public void createTest(String TestnameID) {
		// TODO Auto-generated method stub
		try {
			extTest = rep.createTest(TestnameID);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ExtentTest refrence not initilized");
		}
	}

	/**
	 * generatesExtent Report file
	 */
	public void flushed() {
		// TODO Auto-generated method stub
		try {
			this.rep.flush();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" report not flushed");
		}
	}

	/**
	 * returns date in specified format
	 * 
	 * @return String
	 */
	public String getDateTime(String dateformat) {
		// TODO Auto-generated method stub
		try {
			return new SimpleDateFormat(dateformat).format(new Date());
		} catch (Exception e) {
			// TODO: handle exception
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
				// TODO Auto-generated catch block
				extTest.log(Status.INFO, "Exception occured  during  taking ScreenShot ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			extTest.log(Status.INFO, "Screen Shot not captured ");
		}
	}

	public void launchBrowser(String browser) {
		// TODO Auto-generated method stub
		try {
			if (browser.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();

				driver = new EdgeDriver();
			} else {
				extTest.log(Status.INFO, " Invalid browser name ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			extTest.log(Status.FAIL, "Exception occured while browser Launch  ");
		} finally {
			if (driver != null) {
				extTest.log(Status.INFO, " browser Launched Sucessfully !");
			} else
				extTest.log(Status.FAIL, " browser not  Launched  !");
		}
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			extTest.log(Status.INFO, " browser Closed Sucessfully !");
		} catch (Exception e) {
			// TODO: handle exception
			extTest.log(Status.FAIL, " Exception occured while browser closure !");
		}
	}

	public void closeALLBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			extTest.log(Status.INFO, " All  browser opened via automation process closed Sucessfully !");
		} catch (Exception e) {
			extTest.log(Status.FAIL, " Exception occured while browser closure !");
		}
	}

	public void hitURL(String URL) {
		try {
			driver.get(URL);
			extTest.log(Status.INFO, URL + " hitted sucessfully !!");
		} catch (Exception s) {
			// TODO: handle exception
			driver.navigate().to(URL);
			extTest.log(Status.INFO, URL + " hitted sucessfully !!");
		} catch (Throwable e) {
			// TODO: handle exception
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
		// TODO Auto-generated method stub
		if (we.getTagName().equalsIgnoreCase("select"))
			return true;
		extTest.log(Status.FAIL, "Given WebElement as Argument  isn't DropDown");
		return false;
	}

//	public void selectDropdownOption(WebElement we, String selectby, int value) {
//		try {
//			if (isTagNameSameAsRequires(we, "select")) {
//				Select s = new Select(we);
//				if (selectby.equalsIgnoreCase("index"))
//	s.selectByIndex(value);
//				else if (selectby.equalsIgnoreCase("name"))
//					s.selectByVisibleText((String) value);
//				else if (selectby.equalsIgnoreCase("value"))
//					s.selectByValue((String) value);
//				else
//					extTest.log(Status.FAIL, "INVALID Selectby type  :- " + selectby);
//				extTest.log(Status.INFO, "selected Dropdown option" + value + "  via selectBy" + selectby + "()");
//			}
//
//		} catch (UnexpectedTagNameException e) {
//			// TODO: handle exception
//			extTest.log(Status.FAIL, "Given WebElement as Argument  isn't DropDown !");
//		} catch (Exception e) {
//			// TODO: handle exception
//			sS("Handle_DropDown");
//		}
//	}

	public void getDropdownOptions(WebElement we, String selectby, Object value) {
		try {
			if (isTagNameSameAsRequires(we, "select")) {
				ArrayList<String> al = new ArrayList<String>();
				List<WebElement> a = new Select(we).getOptions();
				for (WebElement webElement : a) {
					String s = webElement.getText();
					al.add(s);
				}
				extTest.log(Status.INFO, "Dropdown options are :-" + al);
			}
		} catch (Exception e) {
			// TODO: handle exception
			extTest.log(Status.FAIL, "not able to fetch options present in dropdown");
		}
	}

	public Automation(String filename) {
		// TODO Auto-generated constructor stub
		report(filename);
	}

	public WebElement getWebElemnt(String locatorType, String locator) {
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
			// TODO: handle exception
			extTest.log(Status.INFO, "No Such Element present on webpage OR wrong locatorvalue");
		}
		return we;
	}

	public void send_WebElement(String locatorType, String locator, String element, String value) {
		// TODO Auto-generated method stub
		System.out.println(locatorType + " " + locator);
		try {
			WebElement we_ = getWebElemnt(locatorType, locator);
			we_.sendKeys(value);
			extTest.log(Status.INFO, element + "(" + value + ") entered sucessfully");
		} catch (Exception e) {
			// TODO: handle exception
			extTest.log(Status.FAIL, "exception occured while using sendkey WebElement");
			e.printStackTrace();
		}
	}

	public void send_Actions(String locatorType, String locator, String element, String value) {
		WebElement we = getWebElemnt(locatorType, locator);
		try {
			new Actions(this.driver).sendKeys(we, value).build().perform();
			extTest.log(Status.INFO, element + "(" + value + ") entered sucessfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "exception occured while using sendkey Actions");
		}
	}

	public void send_JS(String locatorType, String locator, String element, String value) {
		// TODO Auto-generated method stub
		WebElement we = getWebElemnt(locatorType, locator);
		try {
			JavascriptExecutor jsobj = (JavascriptExecutor) driver;
			jsobj.executeScript("arguments[0].Value=" + value + ";", we);
			extTest.log(Status.INFO, element + "(" + value + ") entered sucessfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "exception occured while using sendkey JavaScript");
		}
	}

	public void send3(String locatorType, String locator, String element, String value) {
		// TODO Auto-generated method stub
		WebElement we = getWebElemnt(locatorType, locator);
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

	public void click_WebElement(String locatorType, String locator, String element) {
		// TODO Auto-generated method stub
		WebElement we = getWebElemnt(locatorType, locator);
		try {
			we.click();
			extTest.log(Status.INFO, "clicked sucessfully on " + element);
		} catch (Exception e) {
			// TODO: handle exception
			extTest.log(Status.FAIL, "exception occured while using click WebElement");
		}
	}

	public void click_Actions(String locatorType, String locator, String element) {
		// TODO Auto-generated method stub
		WebElement we = getWebElemnt(locatorType, locator);
		try {
			new Actions(this.driver).sendKeys(we).build().perform();
			extTest.log(Status.INFO, "clicked sucessfully on " + element);
		} catch (Exception e) {
			extTest.log(Status.FAIL, "exception occured while using click  Actions");
		}
	}

	public void click_JS(String locatorType, String locator, String element) {
		// TODO Auto-generated method stub
		WebElement we = getWebElemnt(locatorType, locator);
		try {
			JavascriptExecutor jsobj = (JavascriptExecutor) driver;
			jsobj.executeScript("arguments[0].click();", we);
			extTest.log(Status.INFO, "clicked sucessfully on " + element);
		} catch (Exception e) {
			extTest.log(Status.FAIL, "exception occured while using click JS");
		}
	}

	public void click3(String locatorType, String locator, String element) {
		// TODO Auto-generated method stub
		WebElement we = getWebElemnt(locatorType, locator);
		try {
			we.click();
			extTest.log(Status.INFO, "clicked on" + element);
		} catch (ElementNotInteractableException e) {
			new Actions(driver).click(we).build().perform();
			extTest.log(Status.INFO, "clicked on" + element);
		} catch (Exception w) {
			JavascriptExecutor jsobj = (JavascriptExecutor) driver;
			jsobj.executeScript("arguments[0].click();", we);
			extTest.log(Status.INFO, "clicked on" + element);
		} catch (Throwable e) {
			// TODO: handle exception
			extTest.log(Status.INFO, "Unable to click on  " + element);
		}

	}

	private boolean actionable(String locatorType, String locator, String elementName) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		WebElement we = getWebElemnt(locatorType, locator);

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

	public void validateTextbox(String locatorType, String locator, String element, String valuetoSend) {
		WebElement we = getWebElemnt(locatorType, locator);
		try {
			if (actionable(locatorType, locator, element)) {
				we.clear();
				send3(locatorType, locator, element, valuetoSend);
			}
		} catch (Exception e) {
			sS(element);
		}
	}

	public void validateClickButton(String locatorType, String locator, String element) {
		WebElement we = getWebElemnt(locatorType, locator);
		try {
			if (actionable(locatorType, locator, element)) {
				click3(locatorType, locator, element);
			}
		} catch (Exception e) {
			sS(element);
		}
	}

	private boolean isSelected(WebElement we, String element) {
		// TODO Auto-generated method stub
		boolean a = we.isSelected();
		if (a) {
			extTest.log(Status.INFO, element + "   is  Selected By default.");
		}
		extTest.log(Status.INFO, element + "   is not Selected By default.");
		return a;
	}

	public void validateCheckBox(String locatorType, String locator, String element, String valuetoSend) {
		// TODO Auto-generated method stub
		WebElement we = getWebElemnt(locatorType, locator);
		try {
			if (actionable(locatorType, locator, element)) {
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
	 * To verify specified webPage title with current webPageTitle
	 * 
	 * @param title
	 */
	public void validatePageTitle(String title) {
		// TODO Auto-generated method stub
		try {
			String currentPageTitle = driver.getTitle();
			if (currentPageTitle.equals(title))
				extTest.log(Status.PASS, "pageTitle is same as specified :-" + title);
			else
				extTest.log(Status.FAIL, "pageTitle mis-matched wit given (Current title is " + currentPageTitle + ")");
		} catch (Exception e) {
			extTest.log(Status.FAIL, " exception occured   ,handeled  ");

		}
	}

	public void validateSize(String locatorType, String locatorValue, String elementName, int requiredHeight,
			int requiredWidth) {
		// TODO Auto-generated method stub
		try {
			Dimension a = getWebElemnt(locatorType, locatorValue).getSize();
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

	public void validatelocation(String locatorType, String locatorValue, String elementName, int x_cordinate_Expected,
			int y_cordinate_Expected) {
		try {
			Point a = getWebElemnt(locatorType, locatorValue).getLocation();
			int actual_X = a.x;
			int actual_Y = a.y;
			if (actual_X == x_cordinate_Expected)
				extTest.log(Status.INFO, elementName + "  X-cordinate  verified ! (matched with expexcted result) ");
			else
				extTest.log(Status.FAIL, elementName + " X-cordinate  mis-matched with expexcted result.");
			if (actual_Y == y_cordinate_Expected)
				extTest.log(Status.INFO, elementName + " Y-cordinate  verified ! (matched with expexcted result)");
			else
				extTest.log(Status.FAIL, elementName + " Y-cordinate  mis-matched with expexcted result.");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "exception occured while elements location  validation.");
		}
	}

	public void explicitWait(Duration maxTime , WebElement we) {
		// TODO Auto-generated method stub
		try {
			WebDriverWait obj = new WebDriverWait(driver, maxTime);
			obj.until(ExpectedConditions.visibilityOf(we));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void implicitWait(int i) {
		// TODO Auto-generated method stub
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
