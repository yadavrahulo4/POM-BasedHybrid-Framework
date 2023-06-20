package org.learn.vtiger.reusable_vtiger_dependent;

import java.util.ArrayList;
import java.util.List;

import org.learn.vtiger.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Application dependent reusable method.
 * 
 * @author QA
 */
public class SearchTable {
	private AdvanceSearch objAdvanceSearch;

	@FindBy(xpath = "//form[@name='basicSearch']/table[@class='searchUIBasic small']")
	private WebElement searchForTb;

	@FindBy(xpath = "//div[@id='basicsearchcolumns_real']//select[@id='bas_searchfield']")
	private WebElement searcchInDropDown;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement searchNowBtBasicSearch;

//	@FindBy(xpath = "//td[@class='searchAlph']")
//	private List alphabet;

	@FindBy(xpath = "//table[@class='searchUIBasic small']//td[text()='[x]']")
	private WebElement closeSearchTableBt;

	@FindBy(xpath = "//div[@id='searchAcc']//a")
	private WebElement advanceSearch;

	@FindBy(xpath = "//div[@id='advSearch']//a")
	private WebElement basicSearch;

	@FindBy(xpath = "//input[@value='all']")
	private WebElement matchAllTHeFollowingRadioBt;

	@FindBy(xpath = "//input[@value='any']")
	private WebElement MatchAnyTheFollowingRadioButton;

	@FindBy(xpath = "//input[@name='more']//parent::td//following-sibling::td//input[@value=' Search Now ']")
	private WebElement searchNowBTAdvanceSearch;

	private Utility objUtilitySearchTable;

	/**
	 * constructor of {@link SearchTable} class used to create a webElement of
	 * SearchTable and initilize it in global variable ,so it can be used for
	 * further operations using non-static methods of {@link SearchTable} class.
	 * 
	 * @param objUtility
	 */
	public SearchTable(Utility objUtility) {
		objUtilitySearchTable = objUtility;
	}

	/**
	 * this method will send string element(@param valueToSearch) provided by
	 * argument to searchBox present in search table.
	 * 
	 * @param valueToSearch to search desired value in search box table
	 */
	public void sendkeysOnSearchFor(String valueToSearch) {
		// TODO Auto-generated method stub
		objUtilitySearchTable.send_WebElement(searchForTb, "(Search for) Text-Box ", valueToSearch);
	}

	/**
	 * To fetch all dropDown Options present in search in field
	 * 
	 * @return ArrayList<String> list of dropDown options.
	 */
	public ArrayList<String> getDropdownOptionsOf_In() {
		ArrayList<String> o = objUtilitySearchTable.getDropdownOptions(searcchInDropDown, " (Search in) Dropdown ");
		return o;
	}

	public void selectDropdownOption(String selectBy, Object dropDownOptionToBeSelected) {
		// TODO Auto-generated method stub
		objUtilitySearchTable.selectDropdownOption(searcchInDropDown, "SearchIn DropDown", selectBy,
				dropDownOptionToBeSelected);
	}

	/**
	 * To click on searchNow button in SearchTable
	 */
	public void clickOnSearchNow() {
		// TODO Auto-generated method stub
		objUtilitySearchTable.click(searchNowBtBasicSearch, "(Search now) Button ");
	}

	/**
	 * To click on CloseButton Present on Right Top Corner of SearchTable
	 */
	public void clickOnCloseSearchTable() {
		// TODO Auto-generated method stub
		objUtilitySearchTable.click(closeSearchTableBt, " close Search Table Button ");
	}

	/**
	 * To Search element Starting with given Character.
	 * 
	 * @param alphabet
	 */
	public void searchViaAlphabetCharacter(String alphabet) {
		// TODO Auto-generated method stub
		char alph = alphabet.charAt(0);
		if (alph >= 65 && alph <= 91) {
			List<WebElement> we = objUtilitySearchTable.getWebElements("xpath", "//td[@class='searchAlph']");
			for (WebElement webElement : we) {
				String text = webElement.getText();
				if (text.equalsIgnoreCase(alphabet)) {
					objUtilitySearchTable.click(webElement, "Search via Alphabet on " + alphabet);
				}
			}
		}
	}

	/**
	 * To click on goToAdvanceSearch link and move to AdvanceSearch Table.
	 */
	public AdvanceSearch goToAdvanceSearch() {
		objUtilitySearchTable.click(advanceSearch, "(Go To Advance Search) Link ");
		if (objAdvanceSearch == null)
			return objAdvanceSearch = new AdvanceSearch();
		return objAdvanceSearch;
	}

	/**
	 * This class is designed to built vTiger dependent methods present in Advance
	 * Search element Table present inside searchBox.
	 * 
	 * @author QA
	 */
	public class AdvanceSearch {
		/**
		 * To go on basic SearchBox
		 * 
		 */
		public void Clickon_goToBasicSearch() {
			objUtilitySearchTable.click(basicSearch, "(Go To Advance Search) Link ");
		}

		/**
		 * To check or unCheck (MatchAllTheFollowing) Radio Button.
		 * 
		 * @return {@link AdvanceSearch} object to do further operations.
		 */
		public AdvanceSearch clickOn_MatchAllTheFollowingRadioButton() {
			objUtilitySearchTable.click(matchAllTHeFollowingRadioBt, "(MatchAllTheFollowing) RadioButton ");
			return objAdvanceSearch;
		}

		/**
		 * To check or unCheck (MatchAnyOfTheFollowing) Radio Button.
		 * 
		 * @return {@link AdvanceSearch}
		 */
		public AdvanceSearch clickOn_MatchAnyTheFollowingRadioButton() {
			objUtilitySearchTable.click(MatchAnyTheFollowingRadioButton, "(MatchAnyOfTheFollowing) RadioButton ");
			return objAdvanceSearch;
		}

		/**
		 * To click on Search Now button
		 */
		public void ClickOn_SearchNow() {
			objUtilitySearchTable.click(searchNowBTAdvanceSearch, "(MatchAnyOfTheFollowing) RadioButton ");
		}
	}

}