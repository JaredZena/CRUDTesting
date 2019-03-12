package com.ComputerDB.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.computerDB.TestBase.BrowserFactory;
import com.computerDB.pages.AddComputer;
import com.computerDB.pages.ComputerDBHome;
import com.computerDB.reports.CreateReport;
import com.itextpdf.text.DocumentException;

public class CancelAddComputerTest extends BrowserFactory {
	ComputerDBHome objDBHome;
	AddComputer objAddComp;
	CreateReport objCreateRep;

	/**
	 * Tc - Test add new computer with all fields and verify whether computer added successfully
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws DocumentException 
	 * @throws MalformedURLException 
	 */
	@Test(dataProvider="getData")
	public void openBrowserEnterUrlAndVerifyCancelAddedComputer(String computerName,
			String introducedDate, String discontinuedDate, String company, Boolean dataIsValid) 
					throws InterruptedException, MalformedURLException, DocumentException, IOException{
	WebDriver driver =	startBrowser("Chrome", "http://computer-database.herokuapp.com/computers");
	objCreateRep = new CreateReport(driver);
	objDBHome = new ComputerDBHome(driver);
    objDBHome.clickAddNewComp();
    objAddComp = new AddComputer(driver);
    objAddComp.addNewComputer(computerName,introducedDate,discontinuedDate,company);
    objDBHome.clickCancel();
    
    Assert.assertEquals(objDBHome.validateHomePage(), true);
    
	driver.quit();
	}
	
	/**
	 * Provide data set. This method makes the testing framework data-driven.
	 */
	@DataProvider
	public Object[][] getData() {
	  return new Object[][]{{"Absolut188", "2013-12-25","2017-05-21","Nokia",true}};
	}
}
