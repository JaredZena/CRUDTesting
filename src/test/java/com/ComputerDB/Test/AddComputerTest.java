package com.ComputerDB.Test;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.computerDB.TestBase.BrowserFactory;
import com.computerDB.pages.AddComputer;
import com.computerDB.pages.ComputerDBHome;
import com.computerDB.reports.CreateReport;
import com.itextpdf.text.DocumentException;

public class AddComputerTest extends BrowserFactory{
	    ComputerDBHome objDBHome;
		AddComputer objAddComp;
		CreateReport objCreateRep;
		
		/**
		 * Tc - Test add new computer with all fields and verify whether computer added successfully
		 * @throws InterruptedException
		 * @throws IOException 
		 * @throws DocumentException 
		 */
		@Test(dataProvider="getData")
		public void openBrowserEnterUrlAndVerifyAddedComputer(String computerName,
				String introducedDate, String discontinuedDate, String company, Boolean dataIsValid) 
						throws InterruptedException, IOException, DocumentException{
		WebDriver driver =	startBrowser("Chrome", "http://computer-database.herokuapp.com/computers");
		objDBHome = new ComputerDBHome(driver);
		objCreateRep = new CreateReport(driver);
        objDBHome.clickAddNewComp();
        objAddComp = new AddComputer(driver);
        objAddComp.addNewComputer(computerName,introducedDate,discontinuedDate,company);
        objAddComp.clickCreate();
        //Decide if Add computer will be tested with valid or invalid data 
        //according to the input data
        if(dataIsValid) {
        	objDBHome.verifyCompName(computerName);
        	//To validate Added computer and computer name after adding to DB are equal
        	Assert.assertEquals(computerName,ComputerDBHome.ReturnedCompName);
        	//To validate home page is navigated back
        	Assert.assertEquals(objDBHome.validateHomePage(), true);
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
		  return new Object[][]{{"ABC245", "2019-03-09","2019-03-10","IBM",true}, 
			  {"", "d","m","IBM",false}};
		}
}
