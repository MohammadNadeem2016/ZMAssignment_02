/**
 * 
 */
package com.Pages;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;


import com.CommonUtilities.SeleniumMethods;
import com.google.common.base.Function;

/**
 * @author $Mohammad_Nadeem$
 *
 */
public class SearchList extends SeleniumMethods {
	
	WebDriver driver;
	

	
	By matchList= By.xpath("(//*[@class='result-title'])[1]");
	By scrollView= By.xpath("//*[@id='REVIEWS']/div/span[1]");
	By buttonWrite= By.xpath("//*[@class='hotels-community-content-common-ContextualCTA__currentOption--3Wd5D']/a");
	By hoverActions1= By.id("bubble_rating");
	By titleReview= By.id("ReviewTitle");
	By yourLongText=By.id("ReviewText");
	By BcFsButton=By.id("trip_type_table");
	By BcFsClickB=By.xpath("//*[@id='trip_type_table']/div[5]");
	By srollDateCheck=By.id("DATE_OF_VISIT");
	By selectDateDrop= By.id("trip_date_month_year");
	By hoverActions2=By.id("DQ_RATINGS");
	
	//==================================================================================//
	
	By hoverActions2_1= By.id("qid12_bubbles"); //Service
	By ServiceLabelhoverActions2_1= By.xpath("//*[@id='tr_qid12']/div[1]");	//Label Service 
	
	By hoverActions2_2= By.id("qid190_bubbles"); //Sleep Quality
	By SleepLabelhoverActions2_2= By.xpath("//*[@id='tr_qid190']/div[1]");//Label Sleep Quality

	By hoverActions2_3= By.id("qid13_bubbles"); //Value
	By ValueLabelhoverActions2_3= By.xpath("//*[@id='tr_qid13']/div[1]");//Label Value
	
	By hoverActions2_4= By.id("qid14_bubbles"); //Cleanliness
	By CleanlinessLabelhoverActions2_4= By.xpath("//*[@id='tr_qid14']/div[1]");//Label Cleanliness
	
	By hoverActions2_5= By.id("qid11_bubbles"); //Rooms
	By RoomsLabelhoverActions2_5= By.xpath("//*[@id='tr_qid11']/div[1]");//Label Rooms
	
	By hoverActions2_6= By.id("qid47_bubbles"); //Locations
	By LocationsLabelhoverActions2_6= By.xpath("//*[@id='tr_qid47']/div[1]");//Label Locations
	
	
	//==================================================================================//
	
	By selectCheckBox= By.xpath("//*[@id='FRAUD_CONT']/div/input[2]");
	By submitReviewButton= By.id("SUBMIT");
	By switchIframe= By.id("overlayRegFrame");
	By continueWithMail= By.xpath("//*[@id='ssoButtons']/span/span[2]");
	By EnterEmailAddress= By.id("regSignUp.email");
	By createApassword= By.id("regSignUp.password");

	
	/**
	 * Default Constructor.
	 * @param driver
	 */
	
	
	public SearchList(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	

	/**
	 * This method will select the choice and give the result.
	 * @throws InterruptedException 
	 * 
	 */
	
	
	public void selectedList(String expected, String expectedWR, String fillTitleReview, String YourTypeText, String selectDateDdValue, String iFrameEmailAddress, String cApassword) throws InterruptedException 
	{
	
			
		String expectedText=expected;
		WebElement schoose=driver.findElement(matchList);
    	// Use Actions for Hover on all 
		Actions act= new Actions(driver);
		// Use JavascriptExecutor Interface for scrolling the page
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//Matching List is appear
		// List 1st result Text
		String actualText= schoose.getText();
		//Title of Matching List is appear 
		String maintitle= driver.getTitle();	
		if(actualText.contains(expectedText))
		{
			
			
			waitForButtonToBeClickable(schoose, driver);
			//Click on List 1st result	
			schoose.click();
			
			try {
		// List appear Window Handle		
			String mainWindow=driver.getWindowHandle();
				// It returns no. of windows opened by WebDriver and will return Set of Strings
			Set<String> set =driver.getWindowHandles();
				// Using Iterator to iterate with in windows
				Iterator<String> itr= set.iterator();
				while(itr.hasNext()){
					String childWindow=itr.next();
		// Compare whether the main windows is not equal to child window. If not equal, we will close.
					if(!mainWindow.equals(childWindow)){
						
						driver.switchTo().window(childWindow);
						// Child Window of first result that appear in the search List and get the title			
					String switchwindowTitle= driver.getTitle();					
					if(!maintitle.contentEquals(switchwindowTitle)) {
						
							WebElement sview= driver.findElement(scrollView);
							waitForElementToBeVisible(sview, driver);							
							js.executeScript("arguments[0].scrollIntoView();", sview);
						
						WebElement bwrite= driver.findElement(buttonWrite);
						waitForButtonToBeClickable(bwrite, driver);
						bwrite.click();	
						// Move to the separate Review page to write review
						Set<String> setWR =driver.getWindowHandles();	
						// Using Iterator to iterate with in windows
						Iterator<String> itrWR= setWR.iterator();
						while(itrWR.hasNext()){
							String childWindowWR=itrWR.next();	
							if(!childWindow.equals(childWindowWR)){
								driver.switchTo().window(childWindowWR);
							// Now we are coming to the Review Page to write review
								String switchwindowTitleWR= driver.getTitle();		
								if(!switchwindowTitle.contentEquals(switchwindowTitleWR)) {
									if(switchwindowTitleWR.contains(expectedWR)) {
							// Review Writing Start
							WebElement hoverOn1= driver.findElement(hoverActions1);
							waitForElementToBeVisible(hoverOn1, driver);
							// Use Actions  CLass for Hover 
							act.moveToElement(hoverOn1, 32, 33).pause(1000).moveToElement(hoverOn1, 64, 33).pause(1000).moveToElement(hoverOn1, 96, 33).pause(1000).moveToElement(hoverOn1, 128, 33).pause(1000).moveToElement(hoverOn1, 160, 33).pause(1000);
							act.click().build().perform();	
							WebElement titleRW= driver.findElement(titleReview);
							waitForElementToBeVisible(titleRW, driver);
							titleRW.clear();
							titleRW.sendKeys(fillTitleReview);
							
							WebElement YLText= driver.findElement(yourLongText);
							waitForElementToBeVisible(YLText, driver);
							YLText.clear();
						
							int yttCheck=YourTypeText.length();
							if(yttCheck!=0 && yttCheck>200 )
							{
								YLText.sendKeys(YourTypeText);
							
							}
									
							else {
							System.out.println("You has entered less than 200 character. Please enter minimum 200 Character.");
							}
						
							WebElement BcFsViewButton= driver.findElement(BcFsButton);
							waitForElementToBeVisible(BcFsViewButton, driver);
							js.executeScript("arguments[0].scrollIntoView();", BcFsViewButton);	
							WebElement BcFsClickButton= driver.findElement(BcFsClickB);
							waitForButtonToBeClickable(BcFsClickButton, driver);
							BcFsClickButton.click();	
														
							WebElement srollDateCheckDrop= driver.findElement(srollDateCheck);
							waitForElementToBeVisible(srollDateCheckDrop, driver);
							js.executeScript("arguments[0].scrollIntoView();", srollDateCheckDrop);
							WebElement selectDateDropDown= driver.findElement(selectDateDrop);
							waitForElementToBeVisible(selectDateDropDown, driver);
							Select selectDateDropDownValue= new Select(selectDateDropDown);
							selectDateDropDownValue.selectByVisibleText(selectDateDdValue);
							WebElement ViewhoverActions2= driver.findElement(hoverActions2);
							waitForElementToBeVisible(ViewhoverActions2, driver);
							js.executeScript("arguments[0].scrollIntoView();", ViewhoverActions2);	
							
								
						
							//1
							WebElement EServiceLabelhoverActions2_1= driver.findElement(ServiceLabelhoverActions2_1);
							String TextEServiceLabelhoverActions2_1= EServiceLabelhoverActions2_1.getText();

							//2
							WebElement ESleepLabelhoverActions2_2= driver.findElement(SleepLabelhoverActions2_2);
							String TextESleepLabelhoverActions2_2= ESleepLabelhoverActions2_2.getText();
							
							//3
							WebElement EValueLabelhoverActions2_3= driver.findElement(ValueLabelhoverActions2_3);
							String TextEValueLabelhoverActions2_3= EValueLabelhoverActions2_3.getText();
							
							//4
							WebElement ECleanlinessLabelhoverActions2_4= driver.findElement(CleanlinessLabelhoverActions2_4);
							String TextECleanlinessLabelhoverActions2_4= ECleanlinessLabelhoverActions2_4.getText();
							
							//5
							WebElement ERoomsLabelhoverActions2_5= driver.findElement(RoomsLabelhoverActions2_5);
							String TextERoomsLabelhoverActions2_5= ERoomsLabelhoverActions2_5.getText();
							
							//6
							WebElement ELocationsLabelhoverActions2_6= driver.findElement(LocationsLabelhoverActions2_6);
							String TextELocationsLabelhoverActions2_6= ELocationsLabelhoverActions2_6.getText();
		
							Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
									.withTimeout(20, TimeUnit.SECONDS)
									.pollingEvery(5, TimeUnit.SECONDS)
									.ignoring(NoSuchElementException.class);
							
	By ListOfLabelLocator[]= {ServiceLabelhoverActions2_1,SleepLabelhoverActions2_2,ValueLabelhoverActions2_3,CleanlinessLabelhoverActions2_4,RoomsLabelhoverActions2_5,LocationsLabelhoverActions2_6};
							
	for(By ele: ListOfLabelLocator) 
	{
		
		WebElement fluentele = wait.until(new Function<WebDriver, WebElement>(){	
			public WebElement apply(WebDriver driver ) {
				return driver.findElement(ele);
			}
		});
		
		String LabelVisibleText= fluentele.getText();
		
		if(TextEServiceLabelhoverActions2_1.contentEquals(LabelVisibleText)) {
			
			//Hotel only mentioned Value Service
			WebElement HrServicehoverActions2_1= driver.findElement(hoverActions2_1);
		
			act.moveToElement(HrServicehoverActions2_1, 24, 25).pause(1000).moveToElement(HrServicehoverActions2_1, 48, 25).pause(1000).moveToElement(HrServicehoverActions2_1, 72, 25).pause(1000).moveToElement(HrServicehoverActions2_1, 96, 25).pause(1000).moveToElement(HrServicehoverActions2_1, 120, 25).pause(1000);
			act.click().build().perform();		
		}	
		
		else if(TextESleepLabelhoverActions2_2.contentEquals(LabelVisibleText)){
			
			//Hotel Rating Sleep Quality
			WebElement HsQualityChoverActions2_2= driver.findElement(hoverActions2_2);
		
			act.moveToElement(HsQualityChoverActions2_2, 24, 25).pause(1000).moveToElement(HsQualityChoverActions2_2, 48, 25).pause(1000).moveToElement(HsQualityChoverActions2_2, 72, 25).pause(1000).moveToElement(HsQualityChoverActions2_2, 96, 25).pause(1000).moveToElement(HsQualityChoverActions2_2, 120, 25).pause(1000);
			act.click().build().perform();	
		}
		
		else if(TextEValueLabelhoverActions2_3.contentEquals(LabelVisibleText)){
			
			//Hotel Rating Value
			WebElement HrValuehoverActions2_3= driver.findElement(hoverActions2_3);
		
			act.moveToElement(HrValuehoverActions2_3, 24, 25).pause(1000).moveToElement(HrValuehoverActions2_3, 48, 25).pause(1000).moveToElement(HrValuehoverActions2_3, 72, 25).pause(1000).moveToElement(HrValuehoverActions2_3, 96, 25).pause(1000).moveToElement(HrValuehoverActions2_3, 120, 25).pause(1000);
			act.click().build().perform();
		}
		
		else if(TextECleanlinessLabelhoverActions2_4.contentEquals(LabelVisibleText)){
			
			//Hotel Rating Cleanliness
			WebElement HrCleanlinessHoverActions2_4= driver.findElement(hoverActions2_4);
			
			act.moveToElement(HrCleanlinessHoverActions2_4, 24, 25).pause(1000).moveToElement(HrCleanlinessHoverActions2_4, 48, 25).pause(1000).moveToElement(HrCleanlinessHoverActions2_4, 72, 25).pause(1000).moveToElement(HrCleanlinessHoverActions2_4, 96, 25).pause(1000).moveToElement(HrCleanlinessHoverActions2_4, 120, 25).pause(1000);
			act.click().build().perform();
		}
		
		else if(TextERoomsLabelhoverActions2_5.contentEquals(LabelVisibleText)){

			//Hotel Rating Rooms
			WebElement HrRoomshoverActions2_5= driver.findElement(hoverActions2_5);
		
			act.moveToElement(HrRoomshoverActions2_5, 24, 25).pause(1000).moveToElement(HrRoomshoverActions2_5, 48, 25).pause(1000).moveToElement(HrRoomshoverActions2_5, 72, 25).pause(1000).moveToElement(HrRoomshoverActions2_5, 96, 25).pause(1000).moveToElement(HrRoomshoverActions2_5, 120, 25).pause(1000);
			act.click().build().perform();
		}
		else if(TextELocationsLabelhoverActions2_6.contentEquals(LabelVisibleText)){
			
			//Hotel Rating Locations
			WebElement HrLocationshoverActions2_6= driver.findElement(hoverActions2_6);
			
			act.moveToElement(HrLocationshoverActions2_6, 24, 25).pause(1000).moveToElement(HrLocationshoverActions2_6, 48, 25).pause(1000).moveToElement(HrLocationshoverActions2_6, 72, 25).pause(1000).moveToElement(HrLocationshoverActions2_6, 96, 25).pause(1000).moveToElement(HrLocationshoverActions2_6, 120, 25).pause(1000);
			act.click().build().perform();				
		}
		else {
			
		System.out.println("Something found issue to locate element");	
			
		}	
	
	}						
	
							Thread.sleep(500);
							act.sendKeys(Keys.PAGE_DOWN).build().perform();
							
						WebElement TselectCheckBox= driver.findElement(selectCheckBox);
					js.executeScript("arguments[0].click();", TselectCheckBox);
					Thread.sleep(500);
					
						if(TselectCheckBox.isSelected()) 
						{		
						WebElement submitReviewB= driver.findElement(submitReviewButton);
						waitForButtonToBeClickable(submitReviewB, driver);
						submitReviewB.click();
						
						//Enter in Iframe
						WebElement EswitchIframe= driver.findElement(switchIframe);
						waitForFrameANDswitch(EswitchIframe, driver);
						
						
							WebElement CwE= driver.findElement(continueWithMail);
							waitForButtonToBeClickable(CwE, driver);
							CwE.click();
							
							WebElement eEaddress= driver.findElement(EnterEmailAddress);
							waitForElementToBeVisible(eEaddress, driver);
							eEaddress.clear();
							eEaddress.sendKeys(iFrameEmailAddress);
							
							WebElement cApass= driver.findElement(createApassword);
							waitForElementToBeVisible(cApass, driver);
							cApass.clear();
							cApass.sendKeys(cApassword);
							
							
							}
							
							else {System.out.println("Something is wrong while we click on SUBMIT Button");}
							
							
									}
							
								}	
							}
						
						}
						
						
					}
					}}
			
		} catch (Exception e) {e.printStackTrace();}
				
		}
		
		else {
			
		System.out.println("Selective Name that you want to search is not available in the present list");
		}
			
		
	}
	
	
	

}
