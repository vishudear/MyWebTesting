package com.one.webshop.utils;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Useful properties utilities.
 * 
 * @author vs
 * 
 */
public class PropertiesUtil {

	/**
	*	Method to get values from test.properties file properties
	*
	*	@author vs
	*	@param propertyName - Name of the property in test.properties
	*	@return value of the property
	*/
	public static String getDefaultProperty( String propertyName ){
		
		String propertyValue = "";
		
		Properties props = new Properties();
		
		try {
			props.load( PropertiesUtil.class.getResourceAsStream( "/test.properties" ) );
			propertyValue = props.getProperty( propertyName );
		} catch (Exception e) {}
		
		return propertyValue;
		
	}
	
	/**
	*	Method that loads properties file
	*
	*	@author vs
	*	@param fileName - Name of the properties file
	*	@return properties file
	*/
	
	public static ResourceBundle loadPropertiesFile( String fileName, String language){

		Locale currentLocale = new Locale( language, "EN");
		ResourceBundle messages;

		messages = ResourceBundle.getBundle( fileName, currentLocale );
		return messages;
	}
	
	
	/**
	*	Method to get values from EnvironmentBundle file
	*
	*	@author vs
	*	@param propertyName - Name of the property in test.properties
	*	@param testEnv - test envionment
	*	@return value of the property
	*/
	public static String getEnvironmentProperty( String propertyName){
		
		//	for environment bundle we use only environment suffix
		ResourceBundle rb = loadPropertiesFile("EnvironmentBundle", "en");
		return rb.getString(propertyName);		
	}		
	
}
