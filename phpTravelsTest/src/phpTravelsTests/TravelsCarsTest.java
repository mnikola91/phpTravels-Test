package phpTravelsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import phpTravelsPages.TravelsCars;
import phpTravelsPages.TravelsMenu;

public class TravelsCarsTest extends BasicTest{

	TravelsCars TC = new TravelsCars(driver);
	TravelsMenu TM = new TravelsMenu(driver);

	@BeforeTest
	public void getHomepage() throws InterruptedException {
		BasicTest BT = new BasicTest();
		BT.loginPhpTravels();
		
		TM.Cars().click();
		Thread.sleep(1500);
		TM.CarsInCars().click();
		Thread.sleep(1000);
	}
	
	@Test(priority = 5)
	public void testNumberOfCarModels() {
		TC.checkTableSize();

		Assert.assertEquals(TC.checkTableSize(), 10);
	}
	
	@Test (priority = 10)
	public void testNumberOfOrders() {
		Assert.assertTrue(TC.isMoreThen50());
	}
	
	@Test (priority = 15)
	public void uploadPhoto() throws InterruptedException {
		String textBeforeUploadPhoto = TC.checkUploadText();

		TC.clickOnUpload();
		Thread.sleep(1000);
		TC.addButton().click();
		Thread.sleep(1000);
		TC.uploadPhoto("photo\\joker.jpg");
		Thread.sleep(5000);
		
		TM.Cars().click();
		Thread.sleep(500);
		TM.CarsInCars().click();
		Thread.sleep(2000);
		
		String textAfterUploadPhoto = TC.checkUploadText();

		Assert.assertNotEquals(textBeforeUploadPhoto, textAfterUploadPhoto);
		
	}
	
}
