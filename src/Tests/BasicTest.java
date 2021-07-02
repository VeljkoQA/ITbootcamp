package Tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;	
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import Pages.AuthPage;
import Pages.CartSummaryPage;
import Pages.LocationPopupPage;
import Pages.LoginPage;
import Pages.MealPage;
import Pages.NotificationSistemPage;
import Pages.ProfilePage;
import Pages.SearchResultPage;

public abstract class BasicTest {

	
	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait waiter;
	protected SoftAssert sa;
	
	protected String baseUrl;
	protected String email;
	protected String password;
	protected String locationName;
	
	protected AuthPage authPage;
	protected CartSummaryPage cartSummaryPage;
	protected LocationPopupPage popUpPage;
	protected LoginPage loginPage;
	protected MealPage mealPage;
	protected NotificationSistemPage notificationSistemPage;
	protected ProfilePage profilePage;
	protected SearchResultPage searchResultPage;
	
	@BeforeMethod
	
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.waiter = new WebDriverWait(driver, 20);
		this.js = (JavascriptExecutor) driver;
		
		this.baseUrl = "http://demo.yo-meals.com/";
		this.email = "customer@dummyid.com";
		this.password = "12345678a";
		this.locationName = "City Center - Albany";
		
		this.authPage = new AuthPage(driver, js, waiter);
		this.popUpPage = new LocationPopupPage(driver, js, waiter);
		this.loginPage = new LoginPage(driver, js, waiter);
		this.profilePage = new ProfilePage(driver, js, waiter);
		this.notificationSistemPage = new NotificationSistemPage(driver, js, waiter);
		this.mealPage = new MealPage(driver, js, waiter);
		this.searchResultPage = new SearchResultPage(driver, js, waiter);
		this.cartSummaryPage = new CartSummaryPage(driver, js, waiter);
		
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
		
		@AfterMethod
		
		public void cleanUp(ITestResult results) throws IOException {
			
			if (ITestResult.FAILURE == results.getStatus()) {
				TakesScreenshot screenShot = (TakesScreenshot) driver;
				File source = screenShot.getScreenshotAs(OutputType.FILE);
				String fileName = new SimpleDateFormat("yyyy-MM-dd 'at' HH-mm-ss'.png'").format(new Date());
				FileHandler.copy(source, new File("screenshots/" + results.getName() + "--" + fileName));
			}
			
			this.driver.quit();
			
		}
		
}
