package Selenium;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Tests {

	
	
	 public static void captureScreen(WebDriver driver, String path) throws Exception
	 {
		 	 String location = "C:\\Aravinth\\"+path+".png";
	        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        // Now you can do whatever you need to do with it, for example copy somewhere
	       FileUtils.copyFile(scrFile, new File(location));
	       System.out.println("Screenshot captured successfully and placed at "+ location);
	 }
	
	public static void main(String[] args) throws Exception {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(option);
		
		DesiredCapabilities desired = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "/StockTracker/chromedriver.exe");		

		driver.get("https://www.google.com/flights");
		
		WebElement ele1 = driver.findElement(By.xpath("//*[contains(text(),'Round trip') and @class='gws-flights-form__menu-label']"));
		ele1.click();
		captureScreen(driver,"after click");
		WebElement ele2 = driver.findElement(By.xpath("//menu-item[@class='mSPnZKpnf91__menu-item']//*[text()='One-way']"));
		ele2.click();
		captureScreen(driver,"after SELECT");
		
		Thread.sleep(4000);
		//Scroll(driver);
		
		driver.quit();
	}

	public static void Scroll(WebDriver driver) throws InterruptedException, Exception {
		
		driver.get("https://stackoverflow.com/questions/3189430/how-to-maximize-the-browser-window-in-selenium-webdriver-selenium-2-using-c");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//jse.executeScript("scroll(0,10250);");
		
		WebElement element = driver.findElement(By.linkText("Prasad Khode"));		
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000); 
		
		captureScreen(driver,"img1");
		
		WebElement element1 = driver.findElement(By.linkText("Ripon Al Wasim"));		
		jse.executeScript("arguments[0].scrollIntoView(true);", element1);
		Thread.sleep(500);

		captureScreen(driver, "img2");
		
		driver.manage().window().fullscreen();
		
		Thread.sleep(1000);
	}

}
