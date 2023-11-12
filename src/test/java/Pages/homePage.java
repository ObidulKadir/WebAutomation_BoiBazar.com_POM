package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import BaseDrivers.PageDriver;
import BaseDrivers.baseDriver;
import Utility.GetScreenShot;
import Utility.commonMethods;
public class homePage extends baseDriver{
	ExtentTest test;
	
	public homePage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	@FindBy(xpath = "//ul[@class=\"nav navbar-nav home-menu-ul\"]/li[@class=\"nav-item\"]/a[contains(text(),'ইসলামী বই')][1]")
	WebElement IslamicBook;
	
	public void IslamicBookCategory() throws IOException {
		try {
			test.info("Click on the 'ইসলামী বই'");
			if(IslamicBook.isDisplayed()) {
				IslamicBook.click();
				passCase("Clicked on the ''ইসলামী বই''");
				passCaseWithSC("Clicked on the 'ইসলামী বই'","IslamicBookClickedPass");
				
			}
		} catch (Exception e) {
			failCaseWithSC("'ইসলামী বই' element is unable to locate", "IslamicBookClickedFail");
		}
	}
	
	public void failCaseWithSC(String message, String scName) throws IOException {
		
		test.fail(
				"<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + scName +".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	// pass message with Screenshots
	@SuppressWarnings("unused")
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		
	}
	
	// only pass message
	@SuppressWarnings("unused")
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		
	}

	
	

}
