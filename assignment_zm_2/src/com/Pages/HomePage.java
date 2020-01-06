/**
 * 
 */
package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.CommonUtilities.SeleniumMethods;

/**
 * @author $Mohammad_Nadeem$
 *
 */
public class HomePage extends SeleniumMethods {

	WebDriver driver;
	
	
	By homeSearchBox= By.xpath("//*[@class='brand-global-nav-action-search-Search__searchButton--b9-IK' and @title='Search']");
	By mainSearchBox= By.id("mainSearch");
	By submit= By.xpath("//*[@id='SEARCH_BUTTON' and @class='search_button']");
	
	
	/**
	 * Default Constructor.
	 * @param driver
	 */
	
	public HomePage(WebDriver driver) {
		this.driver = driver;

	}
	
	/**
	 * This method will enter value in Search Box text field.
	 * @param Fill
	 */
	public void enterValueInSearchBoxField(String fill){		
		WebElement hsbox= driver.findElement(homeSearchBox);
		waitForElementToBeVisible(hsbox, driver);
		hsbox.click();
		
		WebElement msbox= driver.findElement(mainSearchBox);
		waitForElementToBeVisible(msbox, driver);		
		msbox.clear();
		msbox.sendKeys(fill);
	}
	
	/**
	 * This method will click on Search button.
	 */


	public void clickOnSearchButton() {
		
		WebElement sub= driver.findElement(submit);
		waitForButtonToBeClickable(sub, driver);
		sub.click();
		
	}

	
}
