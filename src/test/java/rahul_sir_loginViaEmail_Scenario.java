import java.time.Duration;

public class rahul_sir_loginViaEmail_Scenario {

	public static void main(String[] args) {
		Automation obj = new Automation("instagramemailverification");
		obj.createTest("TC001_ LoginPage");
		obj.launchBrowser("chrome");
		obj.hitURL("https://www.instagram.com/accounts/login/");
		obj.explicitWait(Duration.ofSeconds(35), obj.getWebElemnt("name", "username"));
		obj.send_WebElement("name", "username", "userNamebox", "yadavrahulo4");
		obj.send_WebElement("name", "password", "passwordBox", "1234");
		obj.click_WebElement("xpath", "//div[text()='Log in']", "LoginButton ");
		obj.click_WebElement("xpath", "//a[text()='Forgot password?']", "forgot password link button ");
		obj.send_WebElement("xpath", "//input[@name='cppEmailOrUsername']", "enter Email or user name or mobile no.",
				"yadavrahul04102003@gmail.com");
		obj.click_WebElement("xpath", "//button[text()='Send login link']", "send login link button ");
		obj.flushed();
	}

}
