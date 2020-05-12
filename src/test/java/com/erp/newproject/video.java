package com.erp.newproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

public class video {
	log.info("**********Volume muted ScreenShot Taken**********");
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[@title='Subtitles/closed captions (c)']")).getScreenshotAs(OutputType.FILE); //subtitles on
	log.info("**********SubTitle ScreenShot Taken**********");
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[@title='Settings']")).getScreenshotAs(OutputType.FILE); //settings
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	log.info("**********Setings ScreenShot Taken**********");
	driver.findElement(By.linkText("Autoplay")).getScreenshotAs(OutputType.FILE); //Autoplay on
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	log.info("**********Autoplay ScreenShot Taken**********");
	driver.findElement(By.linkText("Annotations")).getScreenshotAs(OutputType.FILE); // Annotations on
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	log.info("**********Annotations  ScreenShot Taken**********");
	driver.findElement(By.xpath("//button[@title='Miniplayer (i)']")).click();
	driver.findElement(By.xpath("//button[@title='Expand (i)']")).getScreenshotAs(OutputType.FILE);
	log.info("**********Miniplayer ScreenShot Taken**********");
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[@title='Default view (t)']")).getScreenshotAs(OutputType.FILE);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	log.info("**********Default ScreenShot Taken**********");
	driver.findElement(By.xpath("//button[@title='Full screen (f)']")).getScreenshotAs(OutputType.FILE);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	log.info("**********FullScreen ScreenShot Taken**********");
}
