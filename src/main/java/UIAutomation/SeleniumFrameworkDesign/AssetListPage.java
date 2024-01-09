package UIAutomation.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Utility.GenericFunctions;

public class AssetListPage extends GenericFunctions{
	
	WebDriver driver;
	
	public AssetListPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	//List<WebElement> products = driver.findElements(By.cssSelector("div.mb-3"));
	//declaring WebElements of Product Catalogue page
//	@FindBy(css="div.mb-3")
//	List<WebElement> products;
	
//	@FindBy(xpath="//span[text()='LiveMaps']")
//	WebElement maps;
	
	@FindBy(css=".asset-list-item-name-driver-container")
	List<WebElement> assets;
	
	//Actions Methods
//	By allProducts= By.cssSelector("div.mb-3");
//	By toastMessage=By.cssSelector("#toast-container");
//	By mapsButton=By.xpath("//span[text()='LiveMaps']");
	By listOfAssets= By.cssSelector(".asset-list-item-name-driver-container");
//	By assetId=By.cssSelector(".activity-value");
	By DAWebelementDisplayOnPage=By.xpath("//h4[text()='Driver Availability']");
	
	public List<WebElement> getListOfAssets()
	{
		explicitWait(listOfAssets);
		return assets;
	}	
	
	public AssetDetailsPage getAssetByName(String assetVRNNumber) throws InterruptedException
	{
		WebElement assetNumber = getListOfAssets().stream()
				.filter(product->product.findElement(By.cssSelector(".asset-list-heading")).getText().equalsIgnoreCase(assetVRNNumber)).findFirst().orElse(null);
		assetNumber.click();
		explicitWait(DAWebelementDisplayOnPage);
		AssetDetailsPage assetDetails = new AssetDetailsPage(driver);
		return assetDetails;
	}
	
//	public void addProductToCart(String productName)
//	{
//		WebElement addItemToCart = getProductByName(productName);
//		addItemToCart.findElement(By.cssSelector(".card-body button:last-child")).click();
//		explicitWait(toastMessage);
//		explicitWaitForElementInvisibility(toastMessage);
//	}

}

