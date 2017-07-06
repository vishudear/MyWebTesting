package com.one.webshop.core;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class TestBase {
	
	protected static WebDriver driver;
	protected String language;
	protected String browserUrl;
	protected String driverPath;

	
	@Parameters({"lang", "browser", "url"})
	@BeforeClass
	public final void setupDriver(@Optional("none") String lang, String browser, String url) throws IOException{
		
		//Set the parameters 
		SeleniumConfig config = new SeleniumConfig("C:\\Users\\Vishwanath\\workspace\\MyWebtesting\\src\\main\\resources\\test.properties");
				
		
		//set default language if no language is mentioned in Suite file
		language = lang;
		if (lang.isEmpty() || lang.equalsIgnoreCase("none")){
			lang = config.getDefLanguage();
		}
		
		System.out.println("Language chosen =" + lang);
		
		if (url.equalsIgnoreCase("Staging"))
			browserUrl = config.getStagingUrl();
		else if (url.equalsIgnoreCase("next"))
			browserUrl = config.getNextUrl();
		else if (url.equalsIgnoreCase("prod"))
			browserUrl = config.getProdUrl();
		
		System.out.println("browserUrl chosen =" + browserUrl);
		System.out.println("browser chosen =" + browser);
	
		//Instantiate the respective browser driver
		if (browser.equalsIgnoreCase("chrome")) {
		    try {
		    	
		      System.out.println("-------------***LAUNCHING GOOGLE CHROME***--------------");		      
		      System.setProperty("webdriver.chrome.driver", config.getChromeDriver());
		      
			  driver = new ChromeDriver();
			  
			  //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			  //driver.get(browserUrl);
		    } catch (Exception e) {
		    	throw new IllegalStateException("Can't start selenium server", e);
		    }
		  }
		 else   if (browser.equalsIgnoreCase("ie")) {
			System.out.println("---------------***LAUNCHING INTERNET EXPLORER***-----------");
			
			System.setProperty("webdriver.ie.driver", config.getIEDriver());
		    driver = new InternetExplorerDriver();
		    }
		 else if (browser.equalsIgnoreCase("edge")){
			 System.out.println("---------------***LAUNCHING IE EDGE***-----------");
			 System.setProperty("webdriver.edge.driver", config.getEdgeDriver());
			 
			 DesiredCapabilities capabilities = new DesiredCapabilities().edge();
			 driver = new EdgeDriver(capabilities);
		 }
		
		 else if (browser.equalsIgnoreCase("firefox")) {
			 System.out.println("-------------***LAUNCHING FIREFOX***--------------");
			 System.setProperty("webdriver.gecko.driver", config.getGeckoDriver());
			 
			 
		     driver=new FirefoxDriver();
		    //driver.navigate().to(browserUrl + "/");
		    //driver.get(browserUrl);
		  }
		 else {
		    throw new IOException("------Only FireFox,InternetExplore and Chrome works -----------");
		  }
		
		//Launch browser
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(browserUrl);
				
		}
	
	//Return driver object
	public static WebDriver getDriverObject(){
		return driver;
	}
	
	@AfterClass
	public static void tearDown(){
		//Closing edge service
		driver.quit();
		//Closing edge service
//		if(edgeService.isRunning())
//		{
//			edgeService.stop();
//		}
		//Stopping server
		System.out.println("Stopping driver");
	}
}