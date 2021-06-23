package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage{
	
	public LocationPopupPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
//	get method for an element that displays the location in the header

	public WebElement getSelectLocation() {
		return driver.findElement(By.className("location-selector"));
	}
	
//	get method for close element
	
	public WebElement getCloseButton() {
		return driver.findElement(By.className("close-btn-white"));
	}
	
//	getKeyword	
	
	public WebElement getKeyword() {
		return driver.findElement(By.id("locality_keyword"));
	}
	
//	getLocationItem(String locationName)
	
	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	
//	getLocationInput()
	
	public WebElement getLocationInput() {
		return driver.findElement(By.id("location_id"));
	}
	
//	getSubmit()
	
	public WebElement getSubmit() {
		return driver.findElement(By.name("btn_submit"));
	}
	
//	a method that opens a pop-up dialog
// by clicking on the location from the header
	
	public void clickLocation() {
		this.getSelectLocation().click();
	}
	
//	metodu koja postavlja lokaciju - naziv lokacije (locationName) se prosleđuje kao parametar metode
//	metoda prvo klikne na element keyword element
//	čita vrednost data-value atributa location item elementa
//	postavlja lokaciju izvršavajući JavaScript kod
//	Skripta: arguments[0].value=arguments[1]
//	prvi argument skripte je location input
//	drugi argument skripte je vrednost pročitanog atributa iz drugog koraka.
//	Klikće na submit element preko skripte arguments[0].click();

	
	public void selectLocation(String locationName) throws InterruptedException {
		this.getKeyword().click();
		Thread.sleep(1000);
		String dataValue = this.getLocationItem(locationName).getAttribute("data-value");
		Thread.sleep(1000);
		js.executeScript("arguments[0].value = arguments[1];", this.getLocationInput(), dataValue);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click()", this.getSubmit());
	}
	
//	a method that closes the pop-up dialog by clicking the X button
	
	public void closePopup() {
		this.getCloseButton().click();
	}
	
}
