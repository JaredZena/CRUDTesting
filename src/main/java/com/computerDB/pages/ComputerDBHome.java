package com.computerDB.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ComputerDBHome {

	WebDriver driver;
	public static String UpdatedCompName;
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

	/**
	 * Enter computer name and click on Add new computer button
	 */
	public void filterComputerByName(String computerName) throws InterruptedException {
		// Thread.sleep(3000);
		tboxSearch.sendKeys(computerName);
		computername = computerName;
		btnSearchSubmit.click();
	}

	/**
	 * To click on Add new computer button
	 */
	public void clickAddNewComp() {
		btnAddComp.click();
	}

	/**
	 * Enter added computer name and click on computer for edit
	 */
	public void ClickAddedComputer() {
		tboxSearch.sendKeys(AddComputer.newCompName);
		FirstCellName.click();
	}

	/**
	 * Enter computer name and click on Filter by name.
	 */
	public void verifyCompName() {
		tboxSearch.sendKeys(AddComputer.newCompName);
		btnSearchSubmit.click();
		ReturnedCompName = FirstCellNameEditComp.getText();
	}

	/**
	 * Get total No. of computers from countitle and validate filter computer
	 * name with each computer.
	 */
	public void verifyFilter() {
		int Flag = 0, temp = 0;
		String countitle = labelrecords.getText();
		String[] count = countitle.split("\\s+");
		int totalcomps = Integer.parseInt(count[0]);
		do {

			try {
				for (int i = 1; i <= totalcomps; i++) {
					String ComputerName = filterComps.findElement(By.xpath("tr[" + i + "]//td[1]")).getText();

					if (!ComputerName.toLowerCase().contains(computername.toLowerCase())) {
						Flag = 1;
						break;
					} else
						temp++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (temp == totalcomps) {
				break;
			} else if (btnNext.isDisplayed()) {
				btnNext.click();
			}
		} while (btnNext.isDisplayed());
	}
}
