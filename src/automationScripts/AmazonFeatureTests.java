package automationScripts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//java.lang.Deprecated;

public class AmazonFeatureTests {
	// testing commit

	ChromeDriver driver;
	int l = 0;
		
	
		@SuppressWarnings("deprecation")
		@BeforeClass
		public void invokeBrowser() 
		{			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\gilbe\\OneDrive\\Desktop\\Selenium\\chromium\\chromedriver-win64\\chromedriver.exe");
			long Long = 500L;
			ChromeOptions cop = new ChromeOptions();
			cop.setBinary("C:\\Users\\gilbe\\OneDrive\\Desktop\\Selenium\\chromium\\chrome-win64\\chrome.exe");
			driver = new ChromeDriver(cop);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().pageLoadTimeout(Long,TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//driver.get("https://amazon.com");
			driver.get("https://amazon.com");
		}
		
		@Test (priority = 0)
		public void verifyTitleOfThePage() throws InterruptedException {
			l++;
			System.out.println(l);
			System.out.println("verifyTitleOfThePage");
			Thread.sleep(10000);
			String expectedTitle = "Amazon.com. Spend less. Smile more.";
			String actualTitle = driver.getTitle();
			//Thread.sleep(20000);
			Assert.assertEquals(actualTitle, expectedTitle);
			
		}
		
		@Test(priority = 300)
		public void computerCheck() throws InterruptedException 
		{
			l++;
			System.out.println(l);
			System.out.println("computerCheck");
			WebElement eleII = driver.findElement(By.xpath("//a[@aria-label='Computers']"));
			eleII.click();
		}
		
		
		@Test (priority = 100)
		public void searchProduct() 
		{
			l++;
			System.out.println(l);
			System.out.println("searchProduct");
			String productItem = "Apple Watch";
			String category = "Electronics";
			WebElement selDropdown = driver.findElement(By.id("searchDropdownBox"));
			Select selCategory = new Select(selDropdown);
			selCategory.selectByVisibleText(category);
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productItem);
			driver.findElement(By.xpath("//input[@value='Go']")).click();
		}
		
		
		@Test(priority = 200)
		public void getNthProduct() throws InterruptedException 
		{
			l++;
			System.out.println(l);
			System.out.println("getNthProduct");
			WebElement ele = driver.findElement(By.xpath("//div[@data-component-type='s-search-result'][5]"));
			System.out.println(ele.getText());
		}
		
		@AfterClass
		public void closeBrowser() throws InterruptedException 
		{
			driver.quit();
		}
		
		@BeforeMethod
		public void methodInvoke() 
		{
			System.out.println("Next Test-------------");
		}
		
		@AfterMethod
		public void methodClose() 
		{
			System.out.println("Test Close-------------");
		}
}


