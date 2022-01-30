package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	 public WebDriver driver;
		public Properties prop;
	public WebDriver initializeDriver() throws IOException

	{

		prop=new Properties();		
		FileInputStream fis=new FileInputStream("C:\\Nitu\\Selenium\\EbayShopping\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);	
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
		 String exePath = "C:\\Users\\Vick\\Downloads\\Selenium Download\\chromedriver_win32\\chromedriver.exe";
         System.setProperty("webdriver.chrome.driver", exePath);
         ChromeOptions options = new ChromeOptions();
         options.addArguments("disable-extensions");
         options.addArguments("--start-maximized");
         options.setExperimentalOption("useAutomationExtension", false);
         driver = new ChromeDriver(options);
	}
		else if(browserName.equals("firefox"))
		{
		driver =new FirefoxDriver();
		}
		else
		{
			driver =new InternetExplorerDriver();
	}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
}
