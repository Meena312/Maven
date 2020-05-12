package com.erp.newproject;

	import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

	public class BaseClass
	{
		FileInputStream fis;
		Properties p1;
	public static WebDriver driver;
	public static Logger log;
	@Test 
	public void openBrowser() throws IOException
	{
		log=Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("Log4jA.properties");
		fis=new FileInputStream(System.getProperty("user.dir")+"//Video.properties");
		p1=new Properties();
		p1.load(fis);
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			 driver=new ChromeDriver();
		driver.get(p1.getProperty("url"));
		log.info("**********Browser Launched**********");
		driver.manage().window().maximize();
		log.info("**********Window maximized**********");
		driver.findElement(By.className("ytp-play-button ytp-button")).click(); //play video
		driver.findElement(By.xpath("//button[@title='Unmute (m)']")).getScreenshotAs(OutputType.FILE); //volume muted
		EventFiringWebDriver efwd=new EventFiringWebDriver(BaseClass.driver);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		File f1=efwd.getScreenshotAs(OutputType.FILE);
		log.info("**********ScreenShot Taken**********");
		String S=new SimpleDateFormat("ddMMyyyy-hhmmss").format(new Date());
		File f2=new File(System.getProperty("user.dir")+"//ScreenShots//"+S+".jpg");
		FileUtils.copyFile(f1,f2);
	}

	}

