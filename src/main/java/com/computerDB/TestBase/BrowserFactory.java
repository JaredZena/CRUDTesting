
package com.computerDB.TestBase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory{
	public static WebDriver driver;
	
	/**
	 * @param browserName
	 * @param url
	 * @Method- To open browser , maximize browser and enter url.
	 */
	public WebDriver startBrowser(String browserName, String url){
		
		if(browserName.equalsIgnoreCase("Firefox")){
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		}
		 if(browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");//Specify driver location 
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		}
		return null;
	}
}