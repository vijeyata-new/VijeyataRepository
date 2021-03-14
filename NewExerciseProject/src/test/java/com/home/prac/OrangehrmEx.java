package com.home.prac;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class OrangehrmEx {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","E:\\Upgraded_sel\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver d=new ChromeDriver(opt);
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.manage().window().maximize();
		d.get("https://www.orangehrm.com/");
//------------------------------------ ****COPYRIGHT CHECK****-----------------------------------------		
		String s = d.getPageSource();
		String chk1 = "copyright";
		String chk2 = "birthdate";
		
		if(s.contains(chk1)) {
			System.out.println("Copyright is present on the home page");
		}
		else {
			System.out.println("Copyright is not present on the home page");
		}
		if(s.contains(chk2)) {
			System.out.println("Birthdate is available");
		}
		else {
			System.out.println("Birthdate is not available");
		}
			
//------------------------------------------------------------------------------------------------------		
		WebElement accCookie = d.findElement(By.linkText("Accept Cookies"));
		if(accCookie.isDisplayed()) {
			accCookie.click();
		}
		
		File f = new File("E:\\Upgraded_sel\\NewExerciseProject\\src\\test\\resources\\TestData\\UserDetails.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		WebElement trialBut = d.findElement(By.linkText("FREE 30 Day Trial"));
		trialBut.click();
		
		WebElement username = d.findElement(By.id("Form_submitForm_subdomain"));
		WebElement fname = d.findElement(By.id("Form_submitForm_FirstName"));
		WebElement lname = d.findElement(By.id("Form_submitForm_LastName"));
		WebElement email = d.findElement(By.id("Form_submitForm_Email"));
		WebElement job = d.findElement(By.id("Form_submitForm_JobTitle"));
		WebElement emp = d.findElement(By.id("Form_submitForm_NoOfEmployees"));
		Select dde = new Select(emp);
		WebElement comp = d.findElement(By.id("Form_submitForm_CompanyName"));
		WebElement inds = d.findElement(By.id("Form_submitForm_Industry"));
		Select ddi = new Select(inds);
		WebElement phone = d.findElement(By.id("Form_submitForm_Contact"));
		WebElement country = d.findElement(By.id("Form_submitForm_Country"));
		Select ddc = new Select(country);

		String temp = "";
		int rowcount=sheet.getLastRowNum() - sheet.getFirstRowNum();
		for(int i=0;i<=rowcount;i++) {
			int cellcount = sheet.getRow(i).getLastCellNum();

			for(int j=0;j<cellcount;j++) {
				temp = sheet.getRow(i).getCell(j).getStringCellValue();	
				
				if(j==0) {
					username.clear();
					username.sendKeys(temp);
				}
				if(j==1) {
					fname.clear();
					fname.sendKeys(temp);
				}
				if(j==2) {
					lname.clear();
					lname.sendKeys(temp);
				}
				if(j==3) {
					email.clear();
					email.sendKeys(temp);
				}
				if(j==4) {
					job.clear();
					job.sendKeys(temp);
				}
				if(j==5) {
					dde.selectByValue(temp);
				}
				if(j==6) {
					comp.clear();
					comp.sendKeys(temp);
				}
				if(j==7) {
					ddi.selectByVisibleText(temp);
				}
				if(j==8) {
					phone.clear();
					phone.sendKeys(temp);
				}
				if(j==9) {
					ddc.selectByVisibleText(temp);
				}
			}
		}
	}
}
