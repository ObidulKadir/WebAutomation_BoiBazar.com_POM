package BaseDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseDriver {
	protected static final String url = "https://www.boibazar.com/";
	WebDriver driver;
	
	@BeforeSuite
	public void StartBrowser() {
		String browserName = System.getProperty("browser", "chrome");
		
		if(browserName.equals("chrome")){
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
	
	}else if(browserName.equals("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
	else {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
		PageDriver.getInstance().setDriver(driver);
	
	}
	
	@AfterSuite
	public void CloseBrowser() {
		driver.quit();
	}

}
