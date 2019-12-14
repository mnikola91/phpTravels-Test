package phpTravelsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import phpTravelsPages.TravelsCars;
import phpTravelsPages.TravelsMenu;

public class TravelsCarsTest extends BasicTest{

	@BeforeTest
	public void getHomepage() throws InterruptedException {
		BasicTest BT = new BasicTest();
		BT.loginPhpTravels();
		
		TravelsMenu TM = new TravelsMenu(driver);
		TM.Cars().click();
		Thread.sleep(1500);
		TM.CarsInCars().click();
		Thread.sleep(1000);
	}
	
	@Test(priority = 5)
	public void testNumberOfCarModels() {
		TravelsCars TC = new TravelsCars(driver);
		TC.checkTableSize();

		Assert.assertEquals(TC.checkTableSize(), 10);
	}
	
	@Test (priority = 10)
	public void testNumberOfOrders() {
		TravelsCars TC = new TravelsCars(driver);
		Assert.assertTrue(TC.isMoreThen50());
	}
	
	@Test (priority = 15)
	public void uploadPhoto() throws InterruptedException {
		TravelsCars TC = new TravelsCars(driver);
		String textBeforeUploadPhoto = TC.checkUploadText();

		TC.clickOnUpload();
		Thread.sleep(1000);
		TC.addButton().click();
		Thread.sleep(1000);
		TC.uploadPhoto("E:\\My stuffs\\IT Boot camp (QA)\\NikolaJava\\phpTravelsTest\\joker.jpg");
		Thread.sleep(5000);
		
		TravelsMenu TM = new TravelsMenu(driver);
		TM.Cars().click();
		Thread.sleep(500);
		TM.CarsInCars().click();
		Thread.sleep(2000);
		
		String textAfterUploadPhoto = TC.checkUploadText();

		Assert.assertNotEquals(textBeforeUploadPhoto, textAfterUploadPhoto);
		
	}
	
}
