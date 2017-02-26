package com.computerDB.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddComputer {

	WebDriver driver;
	public static String newCompName = "ABC";

	public AddComputer(WebDriver driver) {
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

	@FindBy(how = How.XPATH, using = ".//input[@type='submit']")
	@CacheLookup
	WebElement btnCreateComputer;

	/**
	 * Add new computer by entering value to all fields.
	 */
	public void addNewComputer() {
		tboxComputerName.sendKeys(newCompName);
		tboxIntroducedDate.sendKeys("2001-01-01");
		tboxDiscontinuedDate.sendKeys("2006-01-01");
		dbtnCompany.click();
		Select dropdown = new Select(dbtnCompany);
		dropdown.selectByVisibleText("IBM");
		dbtnCompany.click();
		btnCreateComputer.click();
	}
}
