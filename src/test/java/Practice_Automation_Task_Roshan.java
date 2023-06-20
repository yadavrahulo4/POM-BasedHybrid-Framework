

public class Practice_Automation_Task_Roshan {

	Automation obj =  new Automation("Practice_Automation_Task_Roshan");

	public  void  run(String[] args) {
		// TODO Auto-generated method stub
		Practice_Automation_Task_Roshan ob = new Practice_Automation_Task_Roshan();
		ob.obj.createTest("TCCRM01"); // correct
		ob.obj.launchBrowser("chrome");
		ob.TCOO1();
		ob.TCOO2();
		ob.TCOO3();
		ob.obj.flushed();

	}

	public void TCOO1() {
		// TODO Auto-generated method stub
		obj.hitURL("http://localhost:8888");
		obj.validateSize("name", "user_name", "UserNameBox", 22, 140);
		obj.validateSize("name", "user_password", "PasswordBox", 23, 141);
		obj.validateSize("name", "Login", "Login Button", 40, 138);
	}

	public void TCOO2() {
		// TODO Auto-generated method stub
		obj.hitURL("http://localhost:8888");
		obj.validatelocation("name", "user_name", "UserNameBox", 632, 230);
		obj.validatelocation("name", "user_password", "PasswordBox", 632, 262);
		obj.validatelocation("name", "Login", "Login Button", 632, 350);
	}

	public void TCOO3() {
		// TODO Auto-generated method stub
		obj.hitURL("http://localhost:8888");
		obj.send3("name", "user_name", "userNamebox", "admin");
		obj.send3("name", "user_password", "passwordBox", "1234");
		obj.click3("name", "Login", "login button ");
		obj.click3("xpath", "// a[text()='Marketing']", "Marketing column");
		obj.click3("xpath", "//table[@class='level2Bg']//a[text()='Leads']", "leads in marketing column ");
		obj.click3("xpath", "//img[@title='Create Lead...']", "create lead button ");
		obj.send3("name", "firstname", "FirstName TextBox", "rahul");
		obj.send3("name", "lastname", "LastName TextBox", "yadav");
		obj.send3("name", "company", "comapanyNAmeText Box ", "xyz limited");
		obj.send3("name", "designation", "Title text box", "aim is to earn money");
		obj.send3("id", "phone", "Phone no TextBox", "0011223344");
		obj.send3("id", "email", "Email TextBox", "rahulyadavnew@gmail.com");
		obj.send3("name", "lane", "Street TextBox", "bhadohi chauri road ");
		obj.send3("id", "country", "Country TextBox", "INDIA");
	}

}
