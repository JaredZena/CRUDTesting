# ComputerDB
Other Files:
------
1. Functional Test Cases.pdf: Functional tests

2. GUI Test Cases.pdf: GUI tests

Purpose:
-------
Automated and Manual tests for http://computer-database.herokuapp.com/computers

Description:
------------
Test cases are automated using Selenium + Java,TestNG
Created Maven Project and added dependencies for selenium and TestNG
Used page object module i.e created separate page for each web page and defined objects on respective pages.

com.computerDB.pages : Contains all web pages of computer DB

com.computerDB.TestBase : Contains browsers to open drivers

com.ComputerDB.Test : Contains tests for all pages.

Prerequisites:
-------------
1. Eclipse (Used Version: Mars.2 Release (4.5.2))

2. Chrome Driver : (Used Version :2.27)
Download link - https://chromedriver.storage.googleapis.com/index.html?path=2.27/

3. Add TestNG plugin to eclipse

Steps:

       a. Click on "Help" > "Install New software"
       b. Add the link 'http://beust.com/eclipse' in Work with text box.
       c. TestNG feature will be shown, expand the tree node then verify the version.
       d. Tick the checkbox of TestNG
       e. Click on Next button then Finish button. 

Executing:
----------

Update Maven Project:

	> Right click on project 

	> Click on Maven 

	> Click on Upadte project

Run the Tests:

Open com.ComputerDB.Test which is in src/test/java

	> Right click on Test file (e.g. AddComputerTest.java) 

	> click on "Run AS"

	> TestNG Test


