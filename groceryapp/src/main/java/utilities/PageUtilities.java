package utilities;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {

	WebDriver driver ;
	 
	//dropdown methods
	
	public String selectDropdownWithValue(WebElement element, String value) 
	{
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	
	public String selectDropdownWithValue(WebElement element, int value) 
	{
		Select object = new Select(element);
		object.selectByIndex(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();	
	}
	
	public String selectDropdownByVisibleText(WebElement element,String value)
	{
		Select object =new Select(element);
		object.selectByVisibleText(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();		
	}
	
	public String selectDropdownByContainsVisibleText(WebElement element,String value)
	{
		Select object =new Select(element);
		object.selectByContainsVisibleText(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();		
	}
	
	public String selectDropdownBydeSelectAll(WebElement element,String value)
	{
		Select object =new Select(element);
		object.deselectAll();
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();		
	}
	
	public String selectDropdownDeselectByValue(WebElement element,String value)
	{
		Select object =new Select(element);
		object.deselectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();		
	}
	
	public String selectDropdownDeselectByIndex(WebElement element,String value)
	{
		Select object =new Select(element);
		object.deselectByIndex(0);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();		
	}
	
	public String selectDropdownDeselectByVisibleText(WebElement element,String value)
	{
		Select object =new Select(element);
		object.deselectByVisibleText(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();		
	}
	
	public String selectDropdownDeselectByContainsVisibleText(WebElement element,String value)
	{
		Select object =new Select(element);
		object.deSelectByContainsVisibleText(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();		
	}
	
	//checkbox methods
	
	public void selectSingleCheckbox(WebElement element)
	{
		if(!element.isSelected())
		{
			element.click();
		}
		
	}
	
	public void deSelectSingleCheckbox(WebElement element)
	{
		if(!element.isSelected())
		{
			element.click();
		}
		
	}
	
	
	//Drag and drop
	
	public void dragAndDrop(WebElement element,WebElement target)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(element, target).perform();
		
	}
	
	
	//Alert window
	
	public void confirmationAlertOkButton(WebElement element,WebDriver driver)
	{
		element.click();
		driver.switchTo().alert().accept();
		
	}
	
	public void confirmationAlertCancelButton(WebElement element,WebDriver driver)
	{
		element.click();
		driver.switchTo().alert().accept();
		
	}
	
	public void promptAlert(WebElement element,WebDriver driver,String text)
	{
		element.click();
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
		
	}
	
	//Mouse action methods
	
	public void rightClickUsingMouse(WebElement element,WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).perform();		
	}
	
	public void doubleClickUsingMouse(WebElement element,WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();		
	}
	
	public void normalClickUsingMouse(WebElement element,WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.click(element).perform();		
	}
	
	public void mouseOverkUsingMouse(WebElement element,WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	
	//javascript methods
	
	public void clickJavaScriptExecutor(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public void downScrollJavaScriptExecutor(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
	
	public void upScrollJavaScriptExecutor(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}
	
	
	public void rightScrollJavaScriptExecutor(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,0)", "");
	}
	
	
	public void leftScrollJavaScriptExecutor(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(-350,0)", "");
	}
	
	
	//generate current date and time
	
	public String generateCurrentDateAndTime() 
	{
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
}
