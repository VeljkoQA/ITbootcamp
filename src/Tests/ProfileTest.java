package Tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{

	String firstName = "Ronald";
	String lastName = "Williams";
	String address = "Pico Gardens";
	String city = "Los Angeles";
	String zipCode = "160055";
	String state = "California";
	String country = "United States";
	String phone = "9988499868";
	
	String loginMessage = "Login Successfull";
	String loginMessageFail = "[ERROR] Unexpected login message";
	String setupMessage = "Setup Successfull";
	String setupMessageFail = "[ERROR] Unexpected setup message";
	String logoutMessage = "Logout Successfull";
	String logoutMessageFail = "[ERROR] Unexpected logout message";
	String imgMessage = "Profile image uploaded successfully";
	String imgMessageFail = "[ERROr] Image upload failed";
	String imgDelete = "Profile image deleted successfully";
	String imgDeleteFail = "[ERROR] Profile image deleted failed";
	
	@Test(priority = 1)
	
	public void editProfile() throws InterruptedException {
		
		// login
		
		this.driver.navigate().to(baseUrl + "guest-user/login-form");
		this.popUpPage.closePopup();
		this.loginPage.loginUser(email, password);
		Assert.assertTrue(this.notificationSistemPage.getMessageText().contains(loginMessage), this.loginMessageFail);
		
		// edit
		
		this.driver.navigate().to(baseUrl + "member/profile");
		this.profilePage.changeInfo(firstName, lastName, phone, address, zipCode, country, state, city);
		Assert.assertTrue(this.notificationSistemPage.getMessageText().contains(loginMessage), this.loginMessageFail);
		
		// logout 
		
		this.authPage.logout();
		Assert.assertTrue(this.notificationSistemPage.getMessageText().contains(logoutMessage), this.logoutMessageFail);
	}
	
	@Test(priority = 2)
	
	public void changeImg() throws IOException {
		
		// login
		
		this.driver.navigate().to(baseUrl + "/guest-user/login-form");
		this.popUpPage.closePopup();
		this.loginPage.loginUser(email, address);
		Assert.assertTrue(this.notificationSistemPage.getMessageText().contains(loginMessage), this.loginMessageFail);
		this.notificationSistemPage.waitUntilMessageDisappears();
		
		// img upload
		
//		this.driver.navigate().to(baseUrl + "/member/profile");
//		String imgPath = new File().getCanonicalPath();
		
	}
	
	
	
}
