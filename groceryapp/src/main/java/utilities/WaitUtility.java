package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility 
{
	public static int implicitwaitDuration = 10;
	public static int explicitwaitDuration = 20;
	public static int fluentwaitDuration = 25;
	
	
	// fluent wait
	
	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) 
	{
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}
	
	public void waitForWebElementAlert(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	// explicit wait methods
	
	public void waitUntilElementisVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
			
	}
	
	public void waitUntilElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
			
	}
	
	public void waitUntilElementToBeSelected(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitDuration));
		wait.until(ExpectedConditions.elementToBeSelected(element));
			
	}
	
	public void waitUntilElementAttributeContains(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitDuration));
		wait.until(ExpectedConditions.attributeContains(element, null, null));
			
	}
	
	
	
	
	// implicit wait
	
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitwaitDuration));
	}

}
