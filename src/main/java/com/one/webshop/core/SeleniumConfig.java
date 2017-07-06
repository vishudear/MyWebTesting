package com.one.webshop.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SeleniumConfig {
	//Mention serverName, serverPort, browserStartCmd, browserStartFF/Chrome/IE
		private String browserUrl;
		private String resultPath;
		private String stagingUrl;
		private String nextUrl;
		private String prodUrl;
		private String chromeDriverPath;
		private String ieDriverPath;
		private String edgeDriverPath;
		private String defLang;
		private String defBrowser;
		private String geckoDriverPath;
		
		public SeleniumConfig(String propertiesFileName) throws IOException
		{
			FileInputStream input = null;
			
			Properties props = new Properties();
			input = new FileInputStream(propertiesFileName);
			props.load(input);
			//props.load(getClass().getResourceAsStream(propertiesFileName));
			browserUrl = props.getProperty("browser.url");
			stagingUrl = props.getProperty("staging.url");
			nextUrl = props.getProperty("next.url");
			prodUrl = props.getProperty("prod.url");
			
			chromeDriverPath = props.getProperty("chrome.driver");
			ieDriverPath = props.getProperty("ie.driver");
			edgeDriverPath = props.getProperty("edge.driver");
			geckoDriverPath = props.getProperty("gecko.driver");
			resultPath = props.getProperty("results.path");
			
			// Default values for Test execution
			defLang = props.getProperty("default.language");
			defBrowser = props.getProperty("default.browser");
		}
		
		public String getResultPath() {
			return resultPath;
		}

		public String getBrowserUrl() {
			return browserUrl;
		}

		public String getStagingUrl() {
			return stagingUrl;
		}
		
		public String getNextUrl() {
			return nextUrl;
		}
		
		public String getProdUrl() {
			return prodUrl;
		}
		
		public String getChromeDriver() {
			return chromeDriverPath;
		}
		
		public String getIEDriver() {
			return ieDriverPath;
		}
		
		public String getEdgeDriver(){
			return edgeDriverPath;
		}
		
		public String getGeckoDriver(){
			return geckoDriverPath;
		}

		public String getDefLanguage(){
			return defLang;
		}
		
		public String getDefBrowser(){
			return defBrowser;
		}
}
