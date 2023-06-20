import org.openqa.selenium.WebElement;

public class TestcaseLayer {
	public static void main(String[] args) {
		Automation obj = new Automation("fisfs");
		obj.createTest("TC001_ LoginPage");
		obj.launchBrowser("chrome");
		obj.hitURL("http://localhost:8888");
		obj.validatePageTitle("vtiger CRM 5 - Commercial Open Source CRM");
//		obj.send("name", "user_name", "userNamebox", "admin");
		obj.validateSize("name", "user_name", "UserNameBox", 22, 140);
		obj.validateSize("name", "user_password", "PasswordBox", 23, 141);
		obj.validateSize("name", "Login", "Login Button", 40, 138);
		obj.validatelocation("name", "user_name", "UserNameBox", 632, 230);
		obj.validatelocation("name", "user_password", "PasswordBox", 632, 262);
		obj.validatelocation("name", "Login", "Login Button", 632, 350);
		obj.validateTextbox("name", "user_name", "userNamebox", "admin");
//		obj.send("name", "user_password", "passwordBox", "1234");
		obj.validateTextbox("name", "user_password", "passwordbox", "1234");
//		 obj.click("name", "Login", "login button ");
		obj.validateClickButton("name", "Login", "login button ");
		obj.createTest("TC002_Homepage");
		obj.validatePageTitle("admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM");
		obj.click3("xpath", "//table[@class='level2Bg']//td/a[text()='Calendar']", "callender");
		WebElement we = obj.getWebElemnt("id", "view_Option");
		obj.getDropdownOptions(we, "name", "Weekly Calendar View");
		//obj.selectDropdownOption(we, "index", 1);
		obj.flushed();
	}
}