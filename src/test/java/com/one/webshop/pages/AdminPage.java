package com.one.webshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.one.webshop.objects.AdminHomePageObjects;
import com.one.webshop.utils.ProjectUtils;

public class AdminPage {

	WebDriver driver;
		
	// Constructor
	public AdminPage ( WebDriver driver ){
		this.driver = driver;
	}
	
	
	/*
	 * Login to admin
	 * @author - vs
	 */
	public void dologin(String username, String password) throws Exception {
		
		driver.findElement(By.name(AdminHomePageObjects.ADMIN_USERNAME_INPUT)).clear();
		
		driver.findElement(By.name(AdminHomePageObjects.ADMIN_USERNAME_INPUT)).sendKeys(username);
		
		driver.findElement(By.className(AdminHomePageObjects.ADMIN_PASSWORD_INPUT)).sendKeys(password);

		//Click Submit
		driver.findElement(By.className(AdminHomePageObjects.LOGIN_BUTTON)).click();
		  
		Thread.sleep(5000);
	}
	
	
	/*
	 * Verify Domain choosing Dropdown
	 * @author - vs
	 */
	public void verifyChooseDomain(String domainName) throws Exception {
	
		try{
			WebElement element = driver.findElement(By.id(AdminHomePageObjects.CHOOSE_DOMAIN_SELECT));
			Assert.assertTrue(element.isDisplayed(), "Choose domain dropdown is displayed");
			
			Select selectDomain = new Select(element);	
			selectDomain.selectByVisibleText(domainName);
			
			
			ProjectUtils.waitForPageLoad(driver);
			
			//Verify Activate SSL Popup
			boolean activateButton_Exists = ProjectUtils.isElementFound(driver, "linktext", AdminHomePageObjects.COMODO_TERMS_LINK_TEXT);
			if(activateButton_Exists)
			{
				System.out.println("Activate SSL Popup found");
				driver.findElement(By.xpath(AdminHomePageObjects.ACTIVATE_SSL_BUTTON)).click();
				ProjectUtils.wait(driver);
			}
			
			Assert.assertTrue(driver.findElement(By.className(AdminHomePageObjects.WELCOME_LABLE)).getText().contains(AdminHomePageObjects.WELCOME_TEXT),
					"Welcome message shown in Dashboard");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Object not found");
		}
	}
	
	
}
