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
	
	@FindBy(how = How.NAME, using = "created")
	@CacheLookup
	WebElement labelCreatedComputer;

	/**
	 * Add new computer by entering value to all fields.
	 */
	public void addNewComputer(String computerName, String introducedDate,
			String discontinuedDate, String company) {
		tboxComputerName.sendKeys(computerName);
		tboxIntroducedDate.sendKeys(introducedDate);
		tboxDiscontinuedDate.sendKeys(discontinuedDate);
		dbtnCompany.click();
		Select dropdown = new Select(dbtnCompany);
		dropdown.selectByVisibleText(company);
		dbtnCompany.click();
	}

	/**
	 * Click on create a new computer.
	 */
	public void clickCreate() {
		btnCreateComputer.click();
	}
	
	/**
	 * Validate the label of created computer appears.
	 */
	public boolean validateCreatedLabel() {
		return labelCreatedComputer.isDisplayed();
	}
	
}
