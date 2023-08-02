package com.mohs10.scripts;

import org.testng.annotations.Test;

import com.mohs10.ActionDriver.SSreuseclass;
import com.mohs10.ActionDriver.XLUtils;
import com.mohs10.ActionDriver.dataEncryption;
import com.mohs10.base.StartBrowser;

import com.mohs10.reuse.CommonFuns;

public class HomeTest extends StartBrowser {

	String excelFilePath = "TestData\\Data.xlsx";
	String excelsheet = "Login";

	@Test
	public void LoginTestCase3() throws Exception {

		CommonFuns hm2 = new CommonFuns();

		int rowcount = XLUtils.getRowCount(excelFilePath, excelsheet);

		for (int i = 1; i < rowcount; i++) {

			String Email = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 0);
			String Pwd = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 1);
			String occopetion = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 2);
			String rel = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 3);
			String contactnumber = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 4);
			String age = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 5);
			String phcname = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 6);

			String name = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 7);

			String education = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 8);
			String par_edu = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 9);
			String parT_name = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 10);
			String dis = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 11);
			String city = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 12);
			String country = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 13);
			String state = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 14);
			String family_mem = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 15);
			String earning_mem = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 16);
			String url = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 17);
			String Dob=XLUtils.getStringCellData(excelFilePath, excelsheet, i, 18);

			// data Encryption script
			//dataEncryption.encryptData(excelFilePath, excelsheet);

			// data decryption script
			hm2.Login(url, Email, Pwd);

			// data Masked script
			hm2.DataEntry_masked( name,occopetion,rel,phcname,age,contactnumber,Dob);
			//SSreuseclass.SSReusablemethod(driver, "login");// take screenshot

			// UnMasked data passed to the script
			hm2.DataEntry_Unmasked(dis, education, country, par_edu, parT_name);
			hm2.unmasked_data2(city, education, age, state, family_mem, earning_mem);
			
			SSreuseclass.SSReusablemethod(driver, "enter credtential");// take the screenshort
			
			//logout
			hm2.logout();

			Thread.sleep(5000);

		}
	}

}
