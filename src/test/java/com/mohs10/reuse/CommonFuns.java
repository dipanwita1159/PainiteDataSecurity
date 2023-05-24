package com.mohs10.reuse;

import org.openqa.selenium.WebDriver;

import com.mohs10.base.StartBrowser;
import com.mohs10.ActionDriver.Action;

import com.mohs10.ActionDriver.dataMasking;

import com.mohs10.or.HomePage;

public class CommonFuns extends Action {

	public static Action aDriver;
	public WebDriver driver;

	public CommonFuns() {
		aDriver = new Action();
		driver = StartBrowser.driver;
	}
	// *****************************************************Data Encryption & Decryption Script*******************************************************//

	public void Login(String url, String Userid, String Pwd) throws Exception {

		StartBrowser.childTest = StartBrowser.parentTest.createNode("login for data encryption & Decryption");
		aDriver.navigateToApplication(url);
		aDriver.type(HomePage.loginid, Userid, "emid id entered");
		aDriver.getDecryptedPassword(HomePage.pwd, Pwd, "Decrypted password entered"); // take the encrypted data and
																						// decrypt in script
		aDriver.click(HomePage.LoginButton, "button for login clicked");

	}

	// *****************************************************Data Masking Script*******************************************************//

	public void login(String url, String Userid, String Pwd) throws Exception {

		StartBrowser.childTest = StartBrowser.parentTest.createNode("login for data Masking");
		aDriver.navigateToApplication(url);
		aDriver.type(HomePage.loginid, Userid, "EmailId  entered");
		aDriver.type(HomePage.pwd, Pwd, "Password Entered");
		aDriver.click(HomePage.LoginButton, "button for login clicked");
	}

	public void DataEntry_masked(String name, String rel, String occ, String pName, String age, String contact,
			String Dob) throws Exception {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Enter Masked Data");

		aDriver.click(HomePage.gyno, "Gynology buton clicked");

		dataMasking.masktext(HomePage.Name, name, "name entered");
		dataMasking.maskExpectChar(HomePage.phcName, pName, "Phc Name entered");

		dataMasking.masktext(HomePage.Occupation, occ, "occupation enterd");
		dataMasking.masktext(HomePage.Relegion, rel, "relegion enterd");

		dataMasking.masktext(HomePage.age, age, "enter age");

		dataMasking.masktext(HomePage.contactnumber, contact, "contactnumber entered");

		Thread.sleep(5000);

	}

	public void DataEntry_Unmasked(String distict, String education, String country, String pEdu, String pName)
			throws Exception {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Enter Unmasked data");

		aDriver.type(HomePage.distict, distict, "excelfile");
		aDriver.type(HomePage.education, education, "enter data on eucation");
		aDriver.type(HomePage.country, country, "enter country name");
		aDriver.type(HomePage.P_Education, pEdu, "enter patner education");
		aDriver.type(HomePage.p_name, pName, "enter patner Name");

		Thread.sleep(5000);

	}

	public void unmasked_data2(String city, String education, String Age, String state, String emem, String fmem)
			throws Exception {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Enter Unmasked data");

		aDriver.type(HomePage.city, city, "enter city name");
		aDriver.type(HomePage.education, education, "enter data on eucation");
		// aDriver.type(HomePage.age, Age, " age typed");
		aDriver.type(HomePage.state, state, "enter state");
		aDriver.type(HomePage.fmem, fmem, "enter family member");
		
		
		aDriver.type(HomePage.e_mem, emem, "enter earning member");
	
		Thread.sleep(5000);

	}

	public void logout() throws Exception {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Log-Out");
		aDriver.click(HomePage.logout, "log out button clicked");
		aDriver.click(HomePage.songout, "sing out button clicked");
		Thread.sleep(5000);
	}

}
