package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class ScreenshotUtility 
{
	
	public void getScreenshot(WebDriver driver, String failedtestcase) throws IOException 
	{
		TakesScreenshot scrShot = (TakesScreenshot) driver;  	//TakesScreenshot--interface in java
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);  //screenshot will get saved in a temperory path
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());	//to generate current time stamp
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");   // to get the project directory --  "OutputScreenShot" - generate a folder like this

		if (!f1.exists()) 
		{
			f1.mkdirs();    //mkdir --> will create folder using java
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedtestcase + timeStamp+ ".png";   // to replace the screenshot from temperory path to 
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);	//copy screenshot from temperory path to project folder

	}
}
