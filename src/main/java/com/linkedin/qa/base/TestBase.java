package com.linkedin.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.linkedin.qa.utils.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			// to read properties file
			// 1. create object of properties class available in java.util
			prop = new Properties();

			// 2. create object of FileInputStream class available in java.io
			FileInputStream ip;
			ip = new FileInputStream(
					"/Users/tanu/eclipse-workspace/LinkedIn/src/main/java/com/linkedin/qa/config/config.properties");

			// 3. with prop object load the properties file streaming it through ip object
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void intialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/tanu/Downloads/IMP-Drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("No browser value is given");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
