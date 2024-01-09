package UIAutomation.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Utility.GenericFunctions;

public class VDOFleetHomePage extends GenericFunctions{
	

	WebDriver driver;
	public VDOFleetHomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath="//span[text()='LiveMaps']")
	WebElement maps;
	
	//Actions Methods
	By mapsButton=By.xpath("//span[text()='LiveMaps']");
	By assetListText = By.cssSelector(".asset-list-title.ng-star-inserted");
	
	public AssetListPage accessMapsApplication() throws InterruptedException
	{
		explicitWait(mapsButton);
		maps.click();
//		Thread.sleep(5000);
		explicitWait(assetListText);
		String mapsApplicationTitleUrl = driver.getTitle();
		System.out.println(mapsApplicationTitleUrl);
		Assert.assertEquals(mapsApplicationTitleUrl, "VDO Fleet");
		AssetListPage assetList = new AssetListPage(driver);
		return assetList;
	}
	
//	public WebElement getProductByName(String productName)
//	{
//		WebElement prod = getListOfProducts().stream()
//				.filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
//		return prod;
//	}
	
//	public void addProductToCart(String productName)
//	{
//		WebElement addItemToCart = getProductByName(productName);
//		addItemToCart.findElement(By.cssSelector(".card-body button:last-child")).click();
//		explicitWait(toastMessage);
//		explicitWaitForElementInvisibility(toastMessage);
//	}

}
