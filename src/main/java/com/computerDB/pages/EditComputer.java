package com.computerDB.pages;

import java.security.SecureRandom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditComputer {
	WebDriver driver;
	public static String CompNameAfterUpdate;
	public static String CompNameBeforeUpdate;

	public EditComputer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "name")
	@CacheLookup
	WebElement tboxComputerName;

	@FindBy(how = How.ID, using = "introduced")
	@CacheLookup
	WebElement tboxIntroducedDate;

	@FindBy(how = How.ID, using = "discontinued")
	@CacheLookup
	WebElement tboxDiscontinuedDate;

	@FindBy(how = How.ID, using = "company")
	@CacheLookup
	WebElement dbtnCompany;

	@FindBy(how = How.XPATH, using = ".//input[@value='Save this computer']")
	@CacheLookup
	WebElement btnSaveComputer;

	/**
	 * Edit computer by editing all fields of edit computer Enter random string
	 * to computer name
	 */
	public void editComputer() {
		CompNameBeforeUpdate = tboxComputerName.getAttribute("value");
		tboxComputerName.clear();
		CompNameAfterUpdate = randomString(4);
		tboxComputerName.sendKeys(CompNameAfterUpdate);
		tboxComputerName.sendKeys(CompNameAfterUpdate);
		tboxIntroducedDate.clear();
		tboxIntroducedDate.sendKeys("2001-01-08");
		tboxDiscontinuedDate.clear();
		tboxDiscontinuedDate.sendKeys("2006-01-10");
		dbtnCompany.click();
		Select dropdown = new Select(dbtnCompany);
		dropdown.selectByVisibleText("RCA");
		dbtnCompany.click();
		btnSaveComputer.click();
	}

	/**
	 * To generate random string
	 */
	static final String random = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(random.charAt(rnd.nextInt(random.length())));
		return sb.toString();
	}
}
