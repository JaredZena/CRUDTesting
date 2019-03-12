package com.computerDB.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ComputerDBHome {

	WebDriver driver;
	public static String ReturnedCompName = null;

	public ComputerDBHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String computername = null;

	@FindBy(how = How.XPATH, using = ".//input[@id='searchbox']")
	@CacheLookup
	WebElement tboxSearch;

	@FindBy(how = How.ID, using = "searchsubmit")
	@CacheLookup
	WebElement btnSearchSubmit;

	@FindBy(how = How.XPATH, using = ".//table[@class='computers zebra-striped']//tbody")
	@CacheLookup
	WebElement filterComps;

	@FindBy(how = How.XPATH, using = ".//section//h1")
	@CacheLookup
	WebElement labelrecords;

	@FindBy(how = How.XPATH, using = ".//li[@class='next']")
	@CacheLookup
	WebElement btnNext;

	@FindBy(how = How.ID, using = "add")
	@CacheLookup
	WebElement btnAddComp;

	@FindBy(how = How.XPATH, using = ".//table[@class='computers zebra-striped']//tbody//tr[1]/td[1]/a")
	@CacheLookup
	WebElement FirstCellName;

	@FindBy(how = How.XPATH, using = ".//table[@class='computers zebra-striped']//tbody//tr[1]/td[1]/a")
	@CacheLookup
	WebElement FirstCellNameEditComp;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/form/fieldset/div[1]/div/span")
	@CacheLookup
	WebElement labelRequired;
	
	@FindBy(how = How.XPATH, using = "//*[@id='main']/form/fieldset/div[2]/div/span")
	@CacheLookup
	WebElement labelDate1;
	
	@FindBy(how = How.XPATH, using = "//*[@id='main']/form/fieldset/div[3]/div/span")
	@CacheLookup
	WebElement labelDate2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/form/div/a")
	@CacheLookup
	WebElement btnCancel;

	@FindBy(how = How.XPATH, using = ".//*[contains(text(), 'computers found')]")
	@CacheLookup
	WebElement labelNComputersFound;

	/**
	 * To click on Add new computer button
	 */
	public void clickAddNewComp() {
		btnAddComp.click();
	}

	/**
	 * Enter added computer name and click on computer for edit
	 */
	public void ClickAddedComputer(String computerName) {
		tboxSearch.sendKeys(computerName);
		FirstCellName.click();
	}

	/**
	 * Enter computer name and click on Filter by name.
	 */
	public void verifyCompName(String computerName) {
		tboxSearch.sendKeys(computerName);
		btnSearchSubmit.click();
		ReturnedCompName = FirstCellNameEditComp.getText();
	}
	
	/**
	 * Verify label colors when color error is expected.
	 */
	public boolean isErrorDetected() {
		String expectedColor = "rgba(157, 38, 29, 1)";
		if (labelRequired.getCssValue("color").equalsIgnoreCase(expectedColor) &&
		labelDate1.getCssValue("color").equalsIgnoreCase(expectedColor) &&
		labelDate2.getCssValue("color").equalsIgnoreCase(expectedColor)) {
			return true;
		}
		return false;
	}
	/**
	 * Click on Cancel button.
	 */
	public void clickCancel() {
		btnCancel.click();
	}

	/**
	 * Validate home page (partial).
	 */
	public boolean validateHomePage() {
		return labelNComputersFound.isDisplayed();
	}
}