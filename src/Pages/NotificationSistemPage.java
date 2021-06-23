package Pages;
	
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	
public class NotificationSistemPage extends BasicPage{
	
	public NotificationSistemPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
	public WebElement getLoginSuccessfull() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')]"));
	}
	
//	public WebElement getMessageReturn() {
//		return driver.findElement(By.)
//	}
	
//	a method that waits for the notification to disappear
//	waiting for element // * [contains (@class, 'system_message')]
//	gets the value "display: none;" for the style attribute
	
	public void waitsNotificationDisappear() {
		WebDriverWait wait = new WebDriverWait (driver, 10);
//		WebElement element = driver.findElement(By.xpath("//*[contains(@style,'display: block')])"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@style,'display: block')][contains(@style,'display: none')])")));
	}
	
	
}
