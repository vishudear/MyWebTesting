package com.one.webshop.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ProjectUtils {

	private static int actionTime = 30;
	private static int pageLoadTime = 40;
	private static int waitTime = 20;
	
	/**
	*	Method to set wait time for an action
	*/
	public static void waitForAction( WebDriver driver){
		
		driver.manage().timeouts().implicitlyWait(actionTime, TimeUnit.SECONDS);
	}
	
	/**
	*	Method to set wait time for Page to Load
	*/
	public static void waitForPageLoad( WebDriver driver){
		
		driver.manage().timeouts().implicitlyWait(pageLoadTime, TimeUnit.SECONDS);
	}
	
	/**
	*	Method to set wait time for general actions
	*/
	public static void wait( WebDriver driver){
		
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}
	
	
	/**
	*	Method to find whether an object is visible in the UI with just ObjRecognization parameters
	*/
//	public static boolean isElementPresent(WebDriver driver, String objToFind){
//		
//		boolean objVisible = false;
//		
//		//Find by Classpath
//		try{
//			driver.findElement(By.className(objToFind));
//			objVisible = true;
//			return objVisible;
//		} catch (NoSuchElementException e){
//			objVisible = false;
//		}
//		
//		//Find by cssSelector
//		try{
//			driver.findElement(By.cssSelector(objToFind));
//			objVisible = true;
//			return objVisible;
//		} catch (NoSuchElementException e){
//			objVisible = false;
//		}
//		
//		//Find by id
//		try{
//			driver.findElement(By.id(objToFind));
//			objVisible = true;
//			return objVisible;
//		} catch (NoSuchElementException e){
//			objVisible = false;
//		}
//		
//		//Find by linkText
//		try{
//			driver.findElement(By.linkText(objToFind));
//			objVisible = true;
//			return objVisible;
//		} catch (NoSuchElementException e){
//			objVisible = false;
//		}
//		
//		//Find by name
//		try{
//			driver.findElement(By.name(objToFind));
//			objVisible = true;
//			return objVisible;
//		} catch (NoSuchElementException e){
//			objVisible = false;
//		}
//		
//		//Find by Partial Link Text
//		try{
//			driver.findElement(By.partialLinkText(objToFind));
//			objVisible = true;
//			return objVisible;
//		} catch (NoSuchElementException e){
//			objVisible = false;
//		}
//		
//		//Find by Tag Name
//		try{
//			driver.findElement(By.tagName(objToFind));
//			objVisible = true;
//			return objVisible;
//		} catch (NoSuchElementException e){
//			objVisible = false;
//		}
//		
//		//Find by xPath
//		try{
//			driver.findElement(By.xpath(objToFind));
//			objVisible = true;
//			return objVisible;
//		} catch (NoSuchElementException e){
//			objVisible = false;
//		}
//		
//		System.out.println("Object not found");
//		return objVisible;
//	}
//}
		   
	/**
	*	Method to find whether an object is visible in the UI with just ObjRecognization parameters
	*/
	public static boolean isElementFound(WebDriver driver, String property, String objToFind){
		
		boolean objVisible = false;
		
		if(property.equalsIgnoreCase("classname")){
			try{
				driver.findElement(By.className(objToFind));
				objVisible = true;
			}catch (NoSuchElementException e){
				objVisible = false;
			}
		}else if(property.equalsIgnoreCase("css")){
			try{
				driver.findElement(By.cssSelector(objToFind));
				objVisible = true;
			}catch (NoSuchElementException e){
				objVisible = false;
			}
		}else if(property.equalsIgnoreCase("id")){
			try{
				driver.findElement(By.id(objToFind));
				objVisible = true;
			}catch (NoSuchElementException e){
				objVisible = false;
			}
		}else if(property.equalsIgnoreCase("linktext")){
			try{
				driver.findElement(By.linkText(objToFind));
				objVisible = true;
			}catch (NoSuchElementException e){
				objVisible = false;
			}
		}else if(property.equalsIgnoreCase("name")){
			try{
				driver.findElement(By.name(objToFind));
				objVisible = true;
			}catch (NoSuchElementException e){
				objVisible = false;
			}
		}else if(property.equalsIgnoreCase("partiallinktext")){
			try{
				driver.findElement(By.partialLinkText(objToFind));
				objVisible = true;
			}catch (NoSuchElementException e){
				objVisible = false;
			}
		}else if(property.equalsIgnoreCase("tagname")){
			try{
				driver.findElement(By.tagName(objToFind));
				objVisible = true;
			}catch (NoSuchElementException e){
				objVisible = false;
			}
		}else if(property.equalsIgnoreCase("xpath")){
			try{
				driver.findElement(By.xpath(objToFind));
				objVisible = true;
			}catch (NoSuchElementException e){
				objVisible = false;
			}
		}else{System.out.println("Obj property not found");}
	
		return objVisible;
	}
			
} // END of Class
