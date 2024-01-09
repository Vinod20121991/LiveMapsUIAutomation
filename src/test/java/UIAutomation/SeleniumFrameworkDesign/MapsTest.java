package UIAutomation.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericTestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MapsTest extends BaseTest{

		public AssetListPage assetList;
	    public AssetDetailsPage assetDetails;
	    
		@Test(dataProvider="getData",priority=1)
		public void assetDetailsVerificationTest(HashMap<String,String> input) throws InterruptedException, IOException
		{
			
		VDOFleetHomePage map = login.mapsLoginApplication(input.get("email"), input.get("password"));
		assetList = map.accessMapsApplication();
		assetDetails = assetList.getAssetByName(input.get("asset"));
		assetDetails.clickOnAssetTab();
		assetDetails.verifyAssetDetails(input.get("account"),input.get("homelocation"),input.get("licenseplate"),input.get("vinValue"),input.get("gpsdevicetype"),input.get("gpsid"));
		
//		assetDetails.verifyDriverDetails();
//		assetDetails.verifydriverAvailabilityWidget();
//		assetDetails.verifyFindNearByAssetsFeature();
//		Thread.sleep(8000);
		}
		
		@Test(priority=2)
		public void driverDetailsVerificationTest()
		{
			assetDetails.verifyDriverDetails();
		}
		
		@Test(priority=3)
		public void addressLocationLinkTest()
		{
			assetDetails.verifyAddressLocationLink();;
		}
		
		@Test(priority=4)
		public void driverAvailabilityWidgetTest() throws InterruptedException
		{
			assetDetails.verifydriverAvailabilityWidget();
		}
		
		@Test(priority=5)
		public void findNearByAssetsFeatureTest()
		{
			assetDetails.verifyFindNearByAssetsFeature();
		}
		
		@Test(dataProvider="getData",priority=6)
		public void historyDetailsOfTheAssetTest(HashMap<String,String> input) throws InterruptedException
		{
			assetDetails.verifyHistoryDetailsOfTheAsset(input.get("asset"));
			Thread.sleep(4000);
		}
		
//		@Test(priority=7)
//		public void tripSegmentsDetailsTestInTheHistoryPage() throws InterruptedException
//		{
//			assetDetails.verifyTripSegmentsDetailsInTheHistoryPage();
//		}
		
		
//		@Test(dependsOnMethods= {"submitOrders"})
//		public void orderHistoryTest() throws InterruptedException
//		{
//			ProductCataloguePage catalogue=login.loginApplication("vinodnb52@gmail.com", "Welcome@2023");
//			OrdersPage order = catalogue.goToOrderPage();
//			Assert.assertTrue(order.verifyOrderInOrdersPage(productName));
//			Thread.sleep(4000);
//		}
		
//		@DataProvider
//		public Object[][] getData()
//		{
//			Object[][] data = new Object[2][3];
//			data[0][0]="vinodnb52@gmail.com";
//			data[0][1]="Welcome@2023";
//			data[0][2]="zara coat 3";
//			data[1][0]="qat@gmail.com";
//			data[1][1]="Welcome*123";
//			data[1][2]="ADIDAS ORIGINAL";
//			
//			return data;
//		}
		
//		@DataProvider
//		public Object[][] getData()
//		{
//			return new Object[][] {{"vinodnb52@gmail.com","Welcome@2023","zara coat 3"},{"qat@gmail.com","Welcome*123","ADIDAS ORIGINAL"}};
//		}
		
//		@DataProvider
//		public Object[][] getData()
//		{
//			HashMap<String,String> map = new HashMap<String,String>();
//			map.put("email","vinodnb52@gmail.com");
//			map.put("password","Welcome@2023");
//			map.put("product","zara coat 3");
//			HashMap<String,String> map1 = new HashMap<String,String>();
//			map1.put("email","qat@gmail.com");
//			map1.put("password","Welcome*123");
//			map1.put("product","ADIDAS ORIGINAL");
//			return new Object[][] {{map},{map1}};
//		}
		
		@DataProvider
		public Object[][] getData() throws IOException 
		{
			List<HashMap<String, String>> mapObjects = getDataFromJsonToMap(System.getProperty("user.dir")+"//src//test//java//data//mapsTestData.json");
			return new Object[][] {{mapObjects.get(0)}};

		}
		
}
		
		
		
		
		
		
//		List<WebElement> products = driver.findElements(By.cssSelector("div.mb-3"));
//		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("zara coat 3")).findFirst().orElse(null);
//		prod.findElement(By.cssSelector(".card-body button:last-child")).click();
		
		//Implementation using for loop
//		for(int i=0;i<products.size();i++)
//		{
//			WebElement product = products.get(i);
//			String productName = product.findElement(By.cssSelector("b")).getText();
//			if(productName.equalsIgnoreCase("zara coat 3"))
//			{
//				product.findElement(By.cssSelector(".mb-3 .card-body button:last-child")).click();
//			}
//		}
		
		//implementation using iterator()
//		Iterator<WebElement> it = products.iterator();
//		while(it.hasNext())
//		{
//			WebElement product = it.next();
//			String productName = product.findElement(By.cssSelector("b")).getText();
//			if(productName.equalsIgnoreCase("zara coat 3"))
//			{
//				product.findElement(By.cssSelector(".mb-3 .card-body button:last-child")).click();
//			}
//			break;
//		}
		
		//Using Java Stream
//		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("zara coat 3")).findFirst().orElse(null);
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
//		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
//		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
//		boolean pr = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("zara coat 3"));
//		Assert.assertTrue(pr);
//		System.out.println("Item Added Present in the List");
		
//		driver.findElement(By.cssSelector(".totalRow button")).click();
		
//		Actions act = new Actions(driver);
//		act.sendKeys(driver.findElement(By.cssSelector("")), "India");
		
//		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("India");
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector(".ta-results button:nth-child(3)")).click();
//		driver.findElement(By.cssSelector("a[class*='action__submit']")).click();
//		String placeOrderMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//		System.out.println(placeOrderMessage);
//		boolean confirmedMessage = placeOrderMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
//		Assert.assertTrue(confirmedMessage);
//		}

