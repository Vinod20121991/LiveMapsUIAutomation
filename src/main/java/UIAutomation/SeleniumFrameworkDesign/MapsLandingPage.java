package UIAutomation.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.GenericFunctions;

public class MapsLandingPage extends GenericFunctions{
	
	WebDriver driver;
	
	public MapsLandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		//to initialize driver to all the WebElements, we have to use PageFactory initElements method
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElement ue=driver.findElement(By.id("userEmail"));
	//@PageFactory design pattern used to declare WebElements
	@FindBy(id="username")
	WebElement emailAddress;
	
	@FindBy(xpath="//button[@name='action']")
	WebElement submit;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(css="button[class*='_button-login-password']")
	WebElement clickOncontinue;
	
//	@FindBy(css="[class*='flyInOut']")
//	WebElement errorMessage;
	
//	By errorToastMessage = By.cssSelector("[class*='flyInOut']");
	//Need to implement Actions methods for the above WebElements
	//Login Action
	public void goToTheApplication()
	{
		//driver.get("https://rahulshettyacademy.com/client");
		driver.get("https://www.at.my-fis.com/fleetservices/default.aspx");
		
	}
	
//	public ProductCataloguePage mapsLoginApplication(String email,String pwd) throws InterruptedException
//	{
//		emailAddress.sendKeys(email);
//		submit.click();
//		password.sendKeys(pwd);
//		Thread.sleep(4000);
//		clickOncontinue.click();
//		Thread.sleep(5000);
//		ProductCataloguePage catalogue = new ProductCataloguePage(driver);
//		return catalogue;
//	}
	
	public VDOFleetHomePage mapsLoginApplication(String email,String pwd) throws InterruptedException
	{
		emailAddress.sendKeys(email);
		submit.click();
		password.sendKeys(pwd);
		clickOncontinue.click();
		Thread.sleep(9000);
		VDOFleetHomePage catalogue = new VDOFleetHomePage(driver);
		return catalogue;
	}
	
//	public String getErrorMessage()
//	{
//		explicitWait(errorToastMessage);
//		return errorMessage.getText();
//	}
	
		

}

