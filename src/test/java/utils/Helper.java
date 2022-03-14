package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Helper {
	public WebDriver driver;
	public Helper(WebDriver driver) {
		this.driver=driver;
	}
	JavascriptExecutor js;
	public void WaitforElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void disableElement(WebElement element) {
		js = (JavascriptExecutor)driver;
		js.executeScript(
				    "arguments[0].parentNode.removeChild(arguments[0])", element);
	}
	public void waitInSec(int time) throws InterruptedException {
		Thread.sleep(time);
		
	}
}
