package com.ComputerDB.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.computerDB.TestBase.BrowserFactory;
import com.computerDB.pages.ComputerDBHome;

public class ComputerDBTest extends BrowserFactory {

	ComputerDBHome objDBHome;

	/**
	 * TC-Test filter computer by name and verify filter successfully
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void openBrowserEnterUrlAndVerifyFilter() throws InterruptedException {
		WebDriver driver = startBrowser("Chrome", "http://computer-database.herokuapp.com/computers");
		objDBHome = new ComputerDBHome(driver);
		objDBHome.filterComputerByName("ACE");
		objDBHome.verifyFilter();
		driver.quit();

	}
}
