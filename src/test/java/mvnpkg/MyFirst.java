package mvnpkg;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFirst {
public WebDriver d;
WebElement search;
WebElement searchIcon;

@AfterMethod
public void titleCatch(){
	String tit=d.getTitle();
	System.out.println("The title is-"+tit);
}

@BeforeMethod
public void m1() { 
	System.out.println("Next test case is executed");
}

@Test(priority=11) 
public void search() throws InterruptedException {
	search = d.findElement(By.id("twotabsearchtextbox"));
	searchIcon = d.findElement(By.id("nav-search-submit-button"));
	search.sendKeys("mobile");
	searchIcon.submit();
	Thread.sleep(6000);
}

@Test(priority=10)
public void launchSite() {
	d.navigate().to("https://www.facebook.com");
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
