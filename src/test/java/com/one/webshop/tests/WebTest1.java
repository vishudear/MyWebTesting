package com.one.webshop.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.one.webshop.core.TestBase;

import com.one.webshop.pages.AdminPage;



public class WebTest1 extends TestBase{
	
	private String welcome_text = null;
	private int actionTime = 30;
	
	  /*
	   * Do login test
	   * without entering password
	   */
	  @Test
	  public void loginTest1() throws Exception {
		  
		  AdminPage adminPage = new AdminPage(driver);
		  adminPage.dologin("vs@one.com", "");
		
		  Thread.sleep(5000);  
	  
	  }
	  
	  @Test
	  public void loginTest2() throws Exception {
		  
		  AdminPage adminPage = new AdminPage(driver);
		  adminPage.dologin("vs@one.com", "123456");
		  
		  Thread.sleep(5000);
		  
		  adminPage.verifyChooseDomain("qadxb11.1stg.one");
	  }

		
	//@Test
	public void f() {
		//Login
		driver.findElement(By.className("username")).sendKeys("vs@one.com");
		driver.findElement(By.className("password")).sendKeys("123456");
		driver.findElement(By.className("oneButton")).click();
		driver.manage().timeouts().implicitlyWait(actionTime, TimeUnit.SECONDS);
		  
		//Select domain
		Select domainSelect = new Select(driver.findElement(By.id("domainSelect")));
		domainSelect.selectByVisibleText("qadxb11.1next.one");
		driver.manage().timeouts().implicitlyWait(actionTime, TimeUnit.SECONDS);
		  	    
		//Verify Activate SSL Popup
		if(driver.findElement(By.linkText("Comodo terms of service")).isDisplayed())
		{
			System.out.println("Activate SSL Popup found");
			driver.findElement(By.xpath("/html/body/div[6]/webshop-modal-dialog[4]/div[2]/div/div/div/footer/div/button")).click();
			driver.manage().timeouts().implicitlyWait(actionTime, TimeUnit.SECONDS);
		}
		
		//Verify Dashboard
		welcome_text = driver.findElement(By.xpath("//*[@id='component-content']/div[2]/div/div/div/section/h2")).getText().trim();
		System.out.println("welcome_text:" + welcome_text);
		if(welcome_text.equals("Welcome to your webshop!"))
			System.out.println("Login succesfull");
		else
			System.out.println("Login NOT succesfull");
		
	  
		}
}
 

