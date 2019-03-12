package com.ComputerDB.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.computerDB.TestBase.BrowserFactory;
import com.computerDB.pages.ComputerDBHome;
import com.computerDB.pages.EditComputer;
import com.computerDB.reports.CreateReport;
import com.itextpdf.text.DocumentException;

public class EditComputerTest extends BrowserFactory {

	ComputerDBHome objDBHome;
	EditComputer objEditComp;
	CreateReport objCreateRep;

	/**
	 * TC-Test Edit computer and verify computer edited successfully.
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws DocumentException 
	 * @throws MalformedURLException 
	 */
	@Test(dataProvider="getData")
	public void openBrowserEnterUrlAndVerifyEditedComputer(String computerName,
			String introducedDate, String discontinuedDate, String company, 
			String oldComputerName, Boolean dataIsValid) throws InterruptedException, MalformedURLException, DocumentException, IOException {
		WebDriver driver = startBrowser("Chrome", "http://computer-database.herokuapp.com/computers");
		objCreateRep = new CreateReport(driver);
		objDBHome = new ComputerDBHome(driver);
		objDBHome.ClickAddedComputer(oldComputerName);
		objEditComp = new EditComputer(driver);
		objEditComp.editComputer(computerName,introducedDate,discontinuedDate,company);
		objEditComp.clickSave();
        //Decide if Add computer will be tested with valid or invalid data 
        //according to the input data
        if(dataIsValid) {
        	// verify computer name before update and after update are equal
        	Assert.assertNotSame(oldComputerName, computerName);
        	//To validate home page is navigated back
        	Assert.assertEquals(objDBHome.validateHomePage(), true);
        	//To validate Updated computer label
        	Assert.assertEquals(objEditComp.validateUpdatedLabel(), true);
        }else {
        	//When data entered is not valid check for expected conditions when error appears
        	Assert.assertEquals(objDBHome.isErrorDetected(), true);
        }

		driver.quit();
	}
	
	/**
	 * Provide data set. This method makes the testing framework data-driven.
	 */
	@DataProvider
	public Object[][] getData() {
	  return new Object[][]{{"Absolut188", "2013-12-25","2017-05-21","Sony","ABC245",true}, 
		  {"", "d","m","IBM","ABC245",false}};
	}
}
