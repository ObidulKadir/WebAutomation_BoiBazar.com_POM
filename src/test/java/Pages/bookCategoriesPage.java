package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import BaseDrivers.PageDriver;
import Utility.GetScreenShot;
import Utility.commonMethods;

public class bookCategoriesPage extends commonMethods{
	ExtentTest test;
	
	public bookCategoriesPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test=test;
	}
	
	//locating the element.
	@FindBy(xpath="(//a[contains(text(),'প্রকাশনী')])[2]")
	WebElement premisesListHover;
	
	@FindBy(xpath="//input[@id='publisher0']")
	WebElement publisherSelect;
	
	@FindBy(xpath="//a[@id=\"authorList\"]")
	WebElement authorListHover;
	
	@FindBy(xpath="//input[@onclick=\"selectAuthor('Dr-Khandaker-Abdullah-Jahangir')\"]")
	WebElement selectAuthor;
	
	@FindBy(xpath="//a[@onclick=\"addCart('addbtn757',document.getElementById(757).value)\"]")
	WebElement bookAddedToCart;
	
	@FindBy(xpath="//img[@src=\"https://www.boibazar.com/asset/images/cartIconWeb.png\"]")
	WebElement cartIcon;
	
	// প্রকাশনী Module
	public void premisesSelect() throws IOException {
		test.info("Hover on the 'প্রকাশনী'");
		try {
			if(premisesListHover.isDisplayed()) {
				hover(premisesListHover);
				sleepTime(5000);
				passCase("Hovered on the 'প্রকাশনী'");
				passCaseWithSC("Sucessfully hover on the 'প্রকাশনী'", "premisesListHoverPass");
				
				try {
					test.info("Select the publisher.");
					if(publisherSelect.isDisplayed()) {
						publisherSelect.click();
						sleepTime(2000);
						passCase("Selected the আস-সুন্নাহ পাবলিকেশন্স from the 'প্রকাশনী'");
						passCaseWithSC("Sucessfully select আস-সুন্নাহ পাবলিকেশন্স", "publisherSelectPass");
					}
				} catch (Exception e) {
					failCaseWithSC("publisherSelect element is unable to locate.", "publisherSelectFail");
				}
			}
		} catch (Exception e) {
			failCaseWithSC("premisesListHover element is unable to locate.", "premisesListHoverFail");
		}
	}
	
	//লেখক Module
	public void authorSelect() throws InterruptedException, IOException {
		test.info("Hove on the 'লেখক'");
		try {
			if(authorListHover.isDisplayed()) {
				hover(authorListHover);
				sleepTime(3000);
				passCase("Hover on the 'লেখক '");
				passCaseWithSC("Sucessfully hover on the লেখক module", "authorListHoverPass");
				
				try {
					test.info("Select the author: ড. খোন্দকার আব্দুল্লাহ জাহাঙ্গীর");
					if (selectAuthor.isDisplayed()) {
						selectAuthor.click();
						sleepTime(5000);
						passCase("Selected the ইসলামী আকীদা from ড. খোন্দকার আব্দুল্লাহ জাহাঙ্গীর from the 'লেখক '");
						passCaseWithSC("Sucessfully select ড. খোন্দকার আব্দুল্লাহ জাহাঙ্গীর", "selectAuthorPass");
					}
	
				} catch (Exception e) {
					// TODO: handle exception
					failCaseWithSC("selectAuthor element is unable to locate.", "selectAuthorFail");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			failCaseWithSC("authorListHover element is unable to locate.", "authorListHoverFail");
		}
	}
	
	// book added to a cart
	public void bookAddedToCart() throws IOException {
		test.info("Added the book to cart.");
		try {
			if(bookAddedToCart.isDisplayed()) {
				bookAddedToCart.click();
				sleepTime(2000);
				passCase("Added the ইসলামী আকীদা book from Author: ড. খোন্দকার আব্দুল্লাহ জাহাঙ্গীর cart sucessfully.");
				passCaseWithSC("Sucessfully added a ইসলামী আকীদা book", "bookAddedToCartPass");
			}
		} catch (Exception e) {
			// TODO: handle exception
			failCaseWithSC("bookAddedToCart element is unable to locate.", "bookAddedToCartFail");
			
		}
	}
	
	// cart section
	public void Cart() throws IOException {
		test.info("Go to the cart section.");
		try {
			if(cartIcon.isDisplayed()) {
				cartIcon.click();
				sleepTime(2000);
				passCase("Clicked on the cartIcon sucessfully.");
				passCaseWithSC("Sucessfully Clicked on the cartIcon ", "cartIconPass");
			}
		} catch (Exception e) {
			// TODO: handle exception
			failCaseWithSC("cartIcon element is unable to locate.", "cartIconFail");
			
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
