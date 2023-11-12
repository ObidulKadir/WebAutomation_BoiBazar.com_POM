package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseDrivers.PageDriver;

public class commonMethods{
	 public String currentPageUrl() {
	        return PageDriver.getCurrentDriver().getCurrentUrl();
	    }
	 
	 
	  /* ****************************************************************************
	     * Perform Hover on an element *
	     *
	     * Parameter element: This is the target element where to perform hover action *
	     *******************************************************************************
	  */

	    public void hover(WebElement element) {
	        Actions action = new Actions(PageDriver.getCurrentDriver());
	        action.clickAndHold(element).build().perform();
	    }
	    
	    public void sleepTime(int time) throws InterruptedException {
	    	Thread.sleep(time);
	    }

}
