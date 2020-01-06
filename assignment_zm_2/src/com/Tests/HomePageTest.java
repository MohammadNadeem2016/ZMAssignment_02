/**
 * 
 */
package com.Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import com.CommonUtilities.LaunchBrowser;
import com.Pages.HomePage;
import com.Pages.SearchList;

/**
 * @author $Mohammad_Nadeem$
 *
 */
public class HomePageTest extends LaunchBrowser {
	
	
	WebDriver driver;
	
	@Test
	public void test() throws IOException, InterruptedException{
		
		driver = launchBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.tripadvisor.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage homepage= new HomePage(driver);
		homepage.enterValueInSearchBoxField("Club Mahindra");
		homepage.clickOnSearchButton();
		Thread.sleep(500);
		String expected="Club Mahindra";
		String expectedWR="Write a review";
		String fillTitleReview="Enjoyed New Year Party 2020";
		String YourTypeText="We enjoyed a lot at club Mahindra madikeri.... New year party theme with maharaja was wonderful.... Entire party was good.... We enjoyed allot in madikeri rooms very need n clean... Food was tasty... Especially new celebration was really amazing..";
		String selectDateDdValue="December 2019";
		String iFrameEmailAddress="abc.xyz@gmail.com";
		String cApassword="abc.xyz";
		SearchList searchlist= new SearchList(driver); 
		searchlist.selectedList(expected, expectedWR, fillTitleReview, YourTypeText, selectDateDdValue, iFrameEmailAddress, cApassword);
		
		driver.quit();
		
		
	}
	
	
	

}
