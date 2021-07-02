package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends BasicTest{
	
	String numberMessage = "[ERROR] Number Of Products Doesn't Match";
	String nameMessage = "[ERROR] Products Names Are Different";
	
	@Test(priority = 0)
	
	public void searchResults() throws InterruptedException, IOException {
		
		File file = new File("data/Data(4).xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meal Search Results");
		SoftAssert sa = new SoftAssert();
		
		this.driver.navigate().to(baseUrl + "meals");
		this.popUpPage.selectLocation(locationName);
		
		for (int i = 1; i < 7; i++) {
			String url = sheet.getRow(i).getCell(0).getStringCellValue();
			this.driver.get(url);
			Thread.sleep(3000);
			
			String location = sheet.getRow(i).getCell(0).getStringCellValue();
			this.popUpPage.closePopup();
			this.popUpPage.selectLocation(location);
			Thread.sleep(3000);
			
			int resultNumber = (int) sheet.getRow(i).getCell(2).getNumericCellValue();
			int numbersOfMeals = this.searchResultPage.getMealNumber();
			Thread.sleep(3000);
			
			sa.assertEquals(numbersOfMeals, resultNumber, numberMessage);
			Thread.sleep(4000);
			
			for (int j = 3; j < 3 + resultNumber; j++) {
				String meal = sheet.getRow(i).getCell(j).getStringCellValue();
				String mealName = searchResultPage.getName().get(j - 3);
				Thread.sleep(3000);
				sa.assertTrue(mealName.contains(meal), nameMessage);
				
			}
			
			Thread.sleep(3000);
			
		}
		
		sa.assertAll();
		
	}
	
	
}
