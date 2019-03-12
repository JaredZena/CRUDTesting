package com.computerDB.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditComputer {
	WebDriver driver;

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
	
	@FindBy(how = How.XPATH, using ="//div[contains(.,'updated')]")
	@CacheLookup
	WebElement labelUpdatedComputer;

	/**
	 * Edit computer by editing all fields of edit computer Enter random string
	 * to computer name
	 */
	public void editComputer(String computerName, String introducedDate,
			String discontinuedDate, String company) {
		tboxComputerName.clear();
		tboxComputerName.sendKeys(computerName);
		tboxIntroducedDate.clear();
		tboxIntroducedDate.sendKeys(introducedDate);
		tboxDiscontinuedDate.clear();
		tboxDiscontinuedDate.sendKeys(discontinuedDate);
		dbtnCompany.click();
		Select dropdown = new Select(dbtnCompany);
		dropdown.selectByVisibleText(company);
		dbtnCompany.click();
	}
	
	/**
	 * Click on Save this computer.
	 */
	public void clickSave() {
		btnSaveComputer.click();
	}
	
	/**
	 * Validate the label of updated computer appears.
	 */
	public boolean validateUpdatedLabel() {
		return labelUpdatedComputer.isDisplayed();
	}
}
