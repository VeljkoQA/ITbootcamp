package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest{

	int quantity1 = 3;
	String locationMessage1 = "The Following Errors Occurred: ";
	String locationMessage2 = "Please Select Location";
	String locationMessageFail = "[ERROR] No Message";
	String cartMessage = "Meal Added To Cart";
	String cartMassageFail = "[ERROR] Adding To Cart Failed";
	String favoriteMessage = "Please Login First!";
	String favoriteMessageFail = "[ERROR] Login Again";
	String favoriteMealMessage = "The Meal Was Added To The Favorites";
	String favoriteMealMessageFail = "[ERROR] Meal Has Not Been Added To The Favorites";
	String mealMessage = "Meal Added To Cart";
	String mealMessageFail = "[ERROR] Cart Is Empty";
	String cartRemoveMessage = "All Meals Removed From Cart";
	String cartRemoveMessageFail = "[ERROR] Items Have Not Been Removed";
	
	@Test(priority = 3)
	
	public void addMealToCart() throws InterruptedException {
		
		// Add meal
		
		this.driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		this.popUpPage.closePopup();
		this.mealPage.addMealToCart(quantity1);
		Assert.assertTrue(this.notificationSistemPage.getMessageText().contains(locationMessage1), this.locationMessageFail);
		Assert.assertTrue(this.notificationSistemPage.getMessageText().contains(locationMessage2), this.locationMessageFail);
		this.notificationSistemPage.waitUntilMessageDisappears();
		
		// Set location and add meal
		
		this.popUpPage.closePopup();
		this.popUpPage.selectLocation(locationName);
		this.mealPage.addMealToCart(quantity1);
		Assert.assertTrue(this.notificationSistemPage.getMessageText().contains(cartMessage), this.cartMassageFail);
		
	}
	
	@Test(priority = 4)
	
	public void addToFavorite() throws InterruptedException {
		
		// Add to Favorite
		
		this.driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		this.popUpPage.closePopup();
		this.mealPage.addToFavourite();
		Assert.assertTrue(this.notificationSistemPage.getMessageText().contains(favoriteMessage), this.favoriteMessageFail);
		this.notificationSistemPage.waitUntilMessageDisappears();
		
		//User login
		
		this.driver.navigate().to(baseUrl + "guest-user/login-form");
		Thread.sleep(2000);
		this.loginPage.loginUser(email, password);
		
		// Add Favorite
		
		this.driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		this.mealPage.addToFavourite();
		Assert.assertTrue(this.notificationSistemPage.getMessageText().contains(favoriteMealMessage), this.favoriteMealMessageFail);
		this.notificationSistemPage.waitUntilMessageDisappears();
		
	}
		
	@Test(priority = 5)
	
	public void clearCart() throws InterruptedException, IOException {
		
		this.driver.navigate().to(baseUrl + "meals");
		Thread.sleep(2000);
		this.popUpPage.selectLocation(locationName);
		Thread.sleep(2000);
		
		// Import data
		
		File file = new File("data/Data(4).xlsx");
		FileInputStream fis  = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meals");
		
		// Adding meals to cart
		
		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			String meal = sheet.getRow(i).getCell(0).getStringCellValue();
			int quantity = (int) sheet.getRow(i).getCell(1).getNumericCellValue();
			
			this.driver.navigate().to(meal);
			this.mealPage.addMealToCart(quantity);
			Assert.assertTrue(this.notificationSistemPage.getMessageText().contains(mealMessage), this.mealMessageFail);
		}
	
		// Remove meals form cart
		
		this.cartSummaryPage.cartAllClear();
		Assert.assertTrue(this.notificationSistemPage.getMessageText().contains(cartRemoveMessage), this.cartRemoveMessageFail);
		this.notificationSistemPage.waitUntilMessageDisappears();
		
	}
	
	
	
	
	
}
