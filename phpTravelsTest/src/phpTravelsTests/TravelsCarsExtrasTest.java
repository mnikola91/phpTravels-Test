package phpTravelsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import phpTravelsPages.TravelsCarsExtras;

public class TravelsCarsExtrasTest extends BasicTest {
	
	@Test(priority = 5)
	public void cars() throws InterruptedException {
		BasicTest BT = new BasicTest();
		BT.loginPhpTravels();
		
		TravelsCarsExtras TCE = new TravelsCarsExtras(driver);
		TCE.Cars().click();
		Thread.sleep(1000);
		TCE.CarsExtras().click();
		Thread.sleep(4000);
		TCE.ExtrasAdd().click();
		Thread.sleep(4000);
		TCE.NameCars().sendKeys("Yugo car");
		Thread.sleep(1500);
		TCE.uploadImage("E:\\My stuffs\\IT Boot camp (QA)\\NikolaJava\\phpTravelsTest\\joker.jpg");
		Thread.sleep(4000);
		TCE.setStatus("No");
		Thread.sleep(1500);
		TCE.Price().sendKeys("2000");
		Thread.sleep(1500);
		TCE.SaveAndReturn().click();
		Thread.sleep(1500);

		Assert.assertTrue(TCE.isImageUpload());
	}

	@Test(priority = 10)
	public void findCarName() {
		TravelsCarsExtras TCE = new TravelsCarsExtras(driver);

		Assert.assertTrue(TCE.checkIfCarIsAdded("Yugo car"));
	}
	
	@Test(priority = 15)
	public void inputStringInPriceFieldTest() throws InterruptedException {
		TravelsCarsExtras TCE = new TravelsCarsExtras(driver);

		TCE.Cars().click();
		Thread.sleep(1000);
		TCE.CarsExtras().click();
		Thread.sleep(4000);
		TCE.ExtrasAdd().click();
		Thread.sleep(4000);
		TCE.NameCars().sendKeys("Yugo car");
		Thread.sleep(1500);
		TCE.setStatus("Yes");
		Thread.sleep(1500);
		TCE.Price().sendKeys("Price");
		Thread.sleep(1500);
		TCE.SaveAndReturn().click();
		Thread.sleep(2500);
		TCE.inputStringInPriceField();

		Assert.assertTrue(TCE.inputStringInPriceField());
	}
	
}
