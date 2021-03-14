package mvnpkg;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonPr {

	public WebDriver d;
	public WebElement search;
	public WebElement searchIcon;
	public WebElement chose;
	public WebElement buynow;
	public WebElement usern;
	public WebElement contBut;
	public WebElement passwrd;
	public WebElement loginBut;
	
	@Test(priority=4)
	public void login() {
		usern = d.findElement(By.xpath("//*[@id='ap_email']"));
		usern.sendKeys("vijeyata.thorat@gmail.com");
		contBut = d.findElement(By.xpath("//*[@id='continue']"));
		contBut.click();
		passwrd = d.findElement(By.xpath("//*[@id='ap_password']"));
		passwrd.sendKeys("Vijeyata@123");
		loginBut = d.findElement(By.xpath("//*[@id='signInSubmit']"));
		loginBut.click();
		
	}
	
	@Test(priority=3)
	public void newTabs() throws InterruptedException {
		ArrayList<String> browserTabs = new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window(browserTabs.get(1));
		buynow = d.findElement(By.id("buy-now-button"));
		buynow.click();
		Thread.sleep(6000);
	}
	
	@Test(priority=2)
	public void selectp() throws InterruptedException {
		chose = d.findElement(By.xpath("//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[1]/div/div/span/a/div/img"));
		chose.click();
		Thread.sleep(6000);
	}
	
	
	@Test(priority=1) 
	public void search() throws InterruptedException {
		search = d.findElement(By.id("twotabsearchtextbox"));
		searchIcon = d.findElement(By.id("nav-search-submit-button"));
		search.sendKeys("apple macbook air");
		searchIcon.submit();
		Thread.sleep(6000);
	}

	@Test(priority=0)
	public void launchSite() {
		d.navigate().to("https://www.amazon.in");
	}

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\Upgraded_sel\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		d=new ChromeDriver(opt);
		d.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
	}
}
