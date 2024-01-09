package UIAutomation.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import java.util.Set;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Utility.GenericFunctions;

public class AssetDetailsPage extends GenericFunctions{
	
	WebDriver driver;
	
	public AssetDetailsPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	

	@FindBy(xpath="(//p[@class='activity-value'])[1]")
	WebElement assetTab;
	
	@FindBy(xpath="(//div[@class='detail-value'])[1]")
	WebElement accountName;
	
	@FindBy(xpath="(//div[@class='detail-value'])[2]")
	WebElement homeLocation;
	
	@FindBy(xpath="(//div[@class='detail-value'])[3]")
	WebElement licensePlate;
	
	@FindBy(xpath="(//div[@class='detail-value'])[4]")
	WebElement odometerValue;
	
	@FindBy(xpath="(//div[@class='detail-value'])[5]")
	WebElement vin;
	
	@FindBy(xpath="(//div[@class='detail-value'])[6]")
	WebElement gpsDeviceType;
	
	@FindBy(xpath="(//div[@class='detail-value'])[7]")
	WebElement gpsId;
	
	@FindBy(xpath="(//p[@class='activity-value'])[2]")
	WebElement driverName;
	
	@FindBy(xpath="//h4[text()='Driver Availability']")
	WebElement driverAvailabilityWidgetText;
	
	@FindBy(xpath="(//div[@class='item-label'])[1]")
	WebElement driving;
	
	@FindBy(xpath="(//div[@class='item-label'])[2]")
	WebElement today;
	
	@FindBy(xpath="(//div[@class='item-label'])[3]")
	WebElement thisWeek;
	
	@FindBy(xpath="(//div[@class='item-value text-blue'])[1]")
	WebElement remainingDrivingTimeDisplayedInsideDrivingCircle;
	
	@FindBy(xpath="(//div[@class='item-value text-blue'])[2]")
	WebElement remainingDrivingTimeDisplayedInsideTodayCircle;
	
	@FindBy(xpath="(//div[@class='item-value text-blue'])[3]")
	WebElement remainingDrivingTimeDisplayedInsideThisWeekCircle;
	
	@FindBy(xpath="//h5[text()='remaining break time: ']")
	WebElement remainingBreakTime;
	
	@FindBy(xpath="//span[text()='Driving extensions']")
	WebElement drivingExtensionsField;
	
	@FindBy(xpath="//span[text()='Rest reductions']")
	WebElement restReductionsField;
	
	@FindBy(xpath="(//span[@class='title-label'])[1]")
	WebElement currentShiftEndsOnField;
	
	@FindBy(xpath="(//span[@class='title-label'])[1]")
	WebElement earliestNextshiftStartsOnField;
	
	@FindBy(xpath="//span[text()='Find nearby assets']")
	WebElement findNearByAssetsTab;
	
	@FindBy(css="div[class*='asset-list-container']")
	WebElement nearByAssetsExist;
	
	@FindBy(css=".asset-list-heading")
	List<WebElement> listOfNearByAssets;
	
	@FindBy(css=".asset-list-heading")
	WebElement nearByAssetListHeading;
	
	@FindBy(css=".no-nearby-assets-message-container.mat-caption.ng-star-inserted")
	WebElement noNearByAssetsAlertMessage;
	
	@FindBy(css=".current-location-link")
	WebElement googleMapAddressLocationLink;
	
	@FindBy(css="#toggle-history")
	WebElement historyTab;
	
	@FindBy(css=".activity-value")
	WebElement assetIdInHistoryPage;
	
	@FindBy(xpath="(//span[@class='duration-value'])[1]")
	WebElement activeDrivingTime;
	
	@FindBy(xpath="(//span[@class='duration-value'])[2]")
	WebElement idleOrRestDetailsField;
	
	@FindBy(xpath="//p[text()='Trips']")
	WebElement TripsText;
	
	@FindBy(css=".trip-segment-container")
	WebElement tripSegment;
	
	@FindBy(css=".trip-segment-container")
	List<WebElement> multipleTripSegments;
	
	@FindBy(xpath="//div[text()='No activity for the date selected']")
	WebElement noActivityAlertMessage;
	
	@FindBy(css="#timelineControl")
	WebElement viewTripsBar;
	
	@FindBy(css="._pendo-nearby-asset-item.ng-star-inserted")
	WebElement nearByAssetsExists;
	
	@FindBy(css=".content-pane.path-detail-container")
	List<WebElement> historySegments;
	
	By accountNameText = By.xpath("(//div[@class='detail-value'])[1]");
	By nearByAssetText=By.xpath("//h3[text()='Nearby assets']");
	By tripDetails=By.cssSelector(".content-pane.path-detail-container");
	
	//Actions Methods
	
	public void clickOnAssetTab()
	{
		assetTab.click();
		explicitWait(accountNameText);
	}
	
	public void verifyAssetDetails(String account,String homeLocationOfAsset,String licensePlateOfAsset,String VINOfAsset,String gpsDeviceTypeOfAsset,String GPSIdOfAsset)
	{
		String actualAccountName = accountName.getText();
		String actualhomeLocationName=homeLocation.getText();
		String actualLicensePlate=licensePlate.getText();
		String actualOdometerValue=odometerValue.getText();
		String actualVin=vin.getText();
		String actualDeviceType=gpsDeviceType.getText();
		String actualGpsId=gpsId.getText();
				
		System.out.println(actualAccountName);
		System.out.println(actualhomeLocationName);
		System.out.println(actualLicensePlate);
		System.out.println(actualOdometerValue);
		System.out.println(actualVin);
		System.out.println(actualDeviceType);
		System.out.println(actualGpsId);
		
		Assert.assertEquals(actualAccountName, account);
		Assert.assertEquals(actualhomeLocationName, homeLocationOfAsset);
		Assert.assertEquals(actualLicensePlate, licensePlateOfAsset);
		Assert.assertEquals(actualOdometerValue, actualOdometerValue);
		Assert.assertEquals(actualVin, VINOfAsset);
		Assert.assertEquals(actualDeviceType, gpsDeviceTypeOfAsset);
		Assert.assertEquals(actualGpsId, GPSIdOfAsset);
	}
	
	public void verifyDriverDetails()
	{
		String actualDriverName=driverName.getText();
		Assert.assertTrue(driverName.isDisplayed());
		System.out.println("driver name is " +actualDriverName);
	}
	
	public void verifydriverAvailabilityWidget()
	{
		Assert.assertTrue(driverAvailabilityWidgetText.isDisplayed());
		Assert.assertTrue(driving.isDisplayed());
		Assert.assertTrue(today.isDisplayed());
		Assert.assertTrue(thisWeek.isDisplayed());
		Assert.assertTrue(remainingDrivingTimeDisplayedInsideDrivingCircle.isDisplayed());
		Assert.assertTrue(remainingDrivingTimeDisplayedInsideTodayCircle.isDisplayed());
		Assert.assertTrue(remainingDrivingTimeDisplayedInsideThisWeekCircle.isDisplayed());
		Assert.assertTrue(remainingBreakTime.isDisplayed());
		Assert.assertTrue(drivingExtensionsField.isDisplayed());
		Assert.assertTrue(restReductionsField.isDisplayed());
		Assert.assertTrue(currentShiftEndsOnField.isDisplayed());
		Assert.assertTrue(earliestNextshiftStartsOnField.isDisplayed());
	}
	
	public void verifyAddressLocationLink()
	{
		Assert.assertTrue(googleMapAddressLocationLink.isDisplayed());
		String addressLocationLinkOnMap = googleMapAddressLocationLink.getAttribute("href");
		googleMapAddressLocationLink.click();
		Set<String> windowIds = driver.getWindowHandles();
		ArrayList<String> windows = new ArrayList<>(windowIds);
		driver.switchTo().window(windows.get(1));
		String googleMapUrl = driver.getCurrentUrl();
		System.out.println("address link on livemaps application " +addressLocationLinkOnMap);
		System.out.println("Google link " +googleMapUrl);
		Assert.assertEquals(googleMapUrl, addressLocationLinkOnMap);
		driver.switchTo().window(windows.get(0));
		
	}
	
//	public void verifyFindNearByAssetsFeature() throws InterruptedException
//	{
//		Assert.assertTrue(findNearByAssetsTab.isDisplayed());
//		findNearByAssetsTab.click();
//		explicitWait(nearByAssetText);
//			
//		long countOfNearByAssets = listOfNearByAssets.stream().count();
//		System.out.println("Number of Near by assets " +countOfNearByAssets);
//		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("document.querySelector(\".content-pane\").scrollTop=2000");
//		if(countOfNearByAssets>0)
//		{
//			Assert.assertTrue(countOfNearByAssets>0, "Nearby Assets are displayed in the application");
//			listOfNearByAssets.stream().forEach(nearByAssets->System.out.println("Nearby Asset Id : " +nearByAssets.getText()));
//		}
//		else
//		{
//			String actualAlertMessage = noNearByAssetsAlertMessage.getText();
//			Assert.assertEquals(actualAlertMessage, " No assets were found within 50 miles of the selected asset. ");
//		}
//		Thread.sleep(3000);
//		js.executeScript("document.querySelector(\".content-pane\").scrollTop=-2000");
//	}
	
	public void verifyFindNearByAssetsFeature() {
		Assert.assertTrue(findNearByAssetsTab.isDisplayed());
		findNearByAssetsTab.click();
		explicitWait(nearByAssetText);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector(\".content-pane\").scrollTop=2000");		
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			if (nearByAssetsExists.isDisplayed()) {
				Assert.assertTrue(nearByAssetsExists.isDisplayed());
				long countOfNearByAssets = listOfNearByAssets.stream().count();
				System.out.println("Number of Near by assets " + countOfNearByAssets);
				listOfNearByAssets.stream()
						.forEach(nearByAssets -> System.out.println("Nearby Asset Id : " + nearByAssets.getText()));
			}
		} catch (NoSuchElementException e) {
			String actualAlertMessage = noNearByAssetsAlertMessage.getText();
			Assert.assertEquals(actualAlertMessage, "No assets were found within 50 miles of the selected asset.");
		}
		js.executeScript("document.querySelector(\".content-pane\").scrollTop=-2000");
	}
	
	public void verifyHistoryDetailsOfTheAsset(String assetLicensePateNumber) {
		historyTab.click();		
			try {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				if (noActivityAlertMessage.isDisplayed()) {
				Assert.assertTrue(noActivityAlertMessage.isDisplayed());
				} 
			}catch (NoSuchElementException e) {
				explicitWait(tripDetails);
				String actualAssetIdInHistoryPage = assetIdInHistoryPage.getText();
				Assert.assertEquals(actualAssetIdInHistoryPage, assetLicensePateNumber);
				Assert.assertTrue(activeDrivingTime.isDisplayed());
				Assert.assertTrue(idleOrRestDetailsField.isDisplayed());
				Assert.assertTrue(TripsText.isDisplayed());
				long numberOfTripSegments = multipleTripSegments.stream().count();
				System.out.println("Number of Trips Segments " + numberOfTripSegments);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.querySelector(\"div[class*='content-pane']\").scrollTop=2000");
				Assert.assertTrue(tripSegment.isDisplayed());
				multipleTripSegments.stream().forEach(segment -> Assert.assertTrue(segment.isDisplayed()));
				Assert.assertTrue(viewTripsBar.isDisplayed());
			}
		}			
}
//	public void verifyTripSegmentsDetailsInTheHistoryPage()
//	{
//		Assert.assertTrue(TripsText.isDisplayed());
//		long numberOfTripSegments = multipleTripSegments.stream().count();
//		System.out.println("Number of Trips Segments " +numberOfTripSegments);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("document.querySelector(\"div[class*='content-pane']\").scrollTop=2000");
//		
//		if(numberOfTripSegments==1)
//		{
//			Assert.assertTrue(tripSegment.isDisplayed());
//		}
//		else if(numberOfTripSegments>1)
//		{
//			multipleTripSegments.stream().forEach(segment->Assert.assertTrue(segment.isDisplayed()));
//		}
//		else
//		{
//			Assert.assertTrue(noActivityAlertMessage.isDisplayed());
//		}
//		
//		Assert.assertTrue(viewTripsBar.isDisplayed());
//	}
	

