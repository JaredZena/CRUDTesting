package com.computerDB.reports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreateReport {
	
	WebDriver driver;
	public static String testerName = "Mario Jared Zena";
	public static String project = "Computer_Database_Test";
	public static String screenshotsDir = "./Screenshots/";
	public static Integer screenshotNumber = 1;
	public static Integer reportNumber = 1;
	
	public CreateReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void shotScreen(Integer screenshotNumber2) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(screenshotsDir+screenshotNumber2+".png"));
			System.out.println("Screenshot captured");
	}
	
	public void addTestDetails(Document document) throws DocumentException{
		LocalDate currentDate = LocalDate.now();
		document.add(new Paragraph("Test Evidence Report                  "+currentDate+"                 Tester Name: "+testerName));
		document.add(new Paragraph("                        Project Name: "+project));
		document.add(new Paragraph("                  "));
	}
	
	public Integer countScreenshots() {
		File directory = new File("screenshotsDir");
		int fileCount = directory.list().length;
		return fileCount;
	}
	
	public static PdfPCell createImageCell(String screenshotUri) throws BadElementException, MalformedURLException, IOException {
		Image img = Image.getInstance(screenshotUri);
		PdfPCell cell = new PdfPCell(img,true);
		return cell;
	}
	
	public void emptyScreenshotsDir() throws IOException {
		File directory = new File(screenshotsDir);
		FileUtils.cleanDirectory(directory);
	}
	
	public void createDocument() throws DocumentException, MalformedURLException, IOException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("./test-output/PDFReports/"+project+reportNumber+".pdf"));
		document.open();
		
		addTestDetails(document);
		
		PdfPTable table = new PdfPTable(1);

		for (int i = 1; i < countScreenshots()+1 ; i++) {
			table.addCell(createImageCell(screenshotsDir + i +".png"));
		}
		
		document.add(table);
		document.close();
		reportNumber++;
		emptyScreenshotsDir();
		System.out.println("Screenshots saved in PDF document");
	}
	
}
