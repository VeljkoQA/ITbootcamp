package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	
	
	
	
}
