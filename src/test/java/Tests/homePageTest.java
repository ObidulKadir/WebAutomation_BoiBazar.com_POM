package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BaseDrivers.PageDriver;
import BaseDrivers.baseDriver;
import Pages.homePage;
import Utility.ExtentFactory;

public class homePageTest extends baseDriver{
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void StartUrl() {
		PageDriver.getCurrentDriver().get(url);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Home page: 'ইসলামী বই'</b></p>").assignAuthor("QA TEAM").assignDevice("windows");
		
	}
	
	@Test
	public void IslamicBookCategoryTest() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Islamic book Catagory Selection:</b></p>");
		homePage hp = new homePage(childTest);
		hp.IslamicBookCategory();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}

}
