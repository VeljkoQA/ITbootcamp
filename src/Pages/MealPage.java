package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage{

	public MealPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
	public WebElement getAddToCart() {
		return this.driver.findElement(By.xpath("//div[@class='d-flex align-items-center justify-content-between flex-lg--col]/a"));
	}
	
	public WebElement getQuantity() {
		return this.driver.findElement(By.name("product_qty"));
	}
	
	public WebElement getFavouriteButton() {
		return this.driver.findElement(By.id("item_119"));
	}
	
	public void addToFavourite() {
		this.getFavouriteButton().click();
	}
	
	public void addMealToCart(int quantity) throws InterruptedException {
		String qty = Integer.toString(quantity);
		this.getQuantity().sendKeys(Keys.CONTROL + "a");
		this.getQuantity().sendKeys(Keys.DELETE);
		Thread.sleep(2500);
		this.getQuantity().sendKeys(qty);
		this.js.executeScript("arguments[0].click()", this.getAddToCart());
	}
	
}
