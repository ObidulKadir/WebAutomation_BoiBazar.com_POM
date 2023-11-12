package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Pages.bookCategoriesPage;
import Utility.ExtentFactory;

public class bookCategoriesPageTest {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void StartUrl() {
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Book: 'ইসলামী বই' Category Selection.</b></p>").assignAuthor("QA TEAM").assignDevice("windows");
		
	}
	
	@Test (priority = 0)
	public void premisesSelection() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>প্রকাশনী Selection.</b></p>");
		bookCategoriesPage bcp = new bookCategoriesPage(childTest);
		bcp.premisesSelect();
	}
	
	@Test (priority = 1)
	public void authorSelection() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>লেখক Selection.</b></p>");
		bookCategoriesPage bcp = new bookCategoriesPage(childTest);
		bcp.authorSelect();
	}
	
	@Test (priority = 2)
	public void bookAddedtoCart() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Book Added to a cart.</b></p>");
		bookCategoriesPage bcp = new bookCategoriesPage(childTest);
		bcp.bookAddedToCart();
	}
	
	@Test (priority = 3)
	public void cartPage() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Go to Cart page.</b></p>");
		bookCategoriesPage bcp = new bookCategoriesPage(childTest);
		bcp.Cart();
	}
	
	
	@AfterClass
	public void report() {
		report.flush();
	}

}
