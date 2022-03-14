package initialise;

import java.io.File;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class InitialiseDriver {
	public static WebDriver driver;
	
	public static void initialiseDriver() {
		
	//}
	//public InitialiseDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/eswar/Documents/chromedriver");

		//driver = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
	//	options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
	//	options.addArguments("--enable-automation");
		//options.addArguments("--headless");
		//options.addExtensions(new File("files/CaptchaDisabler.crx"));
		options.addArguments("start-maximized");

		options.addArguments("disable-infobars");

		options.addArguments("--disable-extensions");

		 driver = new ChromeDriver(options);
		
		driver.get("https://www.indeed.com/");
		driver.manage().window().maximize();
	}
	
}
