package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage{

	public LoginPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[@class='filled']/a"));
	}
	
	public WebElement getEmailUsername() {
		return driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.name("password"));
	}
	
	public WebElement getSecondLoginButton() {
		return driver.findElement(By.name("btn_submit"));
	}
	
//	metodu koja prijavljuje korisnika na sistem - kao parametri se prosleđuju imejl i lozinka
	
	public void loginUser (String emailUsername, String password) {
		this.getEmailUsername();
		this.getPassword();
		this.getSecondLoginButton().click();
	}
	
	
	
}
