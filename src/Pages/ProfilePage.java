package Pages;
	
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
	
public class ProfilePage extends BasicPage{
	
	public ProfilePage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
	public WebElement getEditProfile() {
		return this.driver.findElement(By.xpath("//div[@class='action-profile']/a[2]"));
	}
	
	public WebElement getFirstName() {
		return this.driver.findElement(By.name("user_first_name"));
	}
	
	public WebElement getLastName() {
		return this.driver.findElement(By.name("user_last_name"));
	}
	
	public WebElement getAddress() {
		return this.driver.findElement(By.name("user_address"));
	}
	
	public WebElement getPhoneNumber() {
		return this.driver.findElement(By.name("user_phone"));
	}
	
	public WebElement getZipCode() {
		return this.driver.findElement(By.name("user_zip"));
	}
	
	public Select getCountry() {
		WebElement selectCountry = this.driver.findElement(By.id("user_country_id"));
		Select country = new Select(selectCountry);
		return country;
	}
	
	public Select getState() {
		WebElement selectState = this.driver.findElement(By.id("user_state_id"));
		Select state = new Select(selectState);
		return state;
	}
	
	public Select getCity() {
		WebElement selectCity = this.driver.findElement(By.id("user_city"));
		Select city = new Select(selectCity);
		return city;
	}
	
	public WebElement getSaveButton() {
		return this.driver.findElement(By.xpath("//input[@name='btn_submit']"));
	}
	
}
