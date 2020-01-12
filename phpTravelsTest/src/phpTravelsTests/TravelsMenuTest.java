package phpTravelsTests;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import phpTravelsPages.TravelsMenu;

public class TravelsMenuTest extends BasicTest{
	
	TravelsMenu TM = new TravelsMenu(driver);

	@BeforeTest
	public void getHomepage() throws InterruptedException {
		BasicTest BT = new BasicTest();
		BT.loginPhpTravels();
		Thread.sleep(4000);
	}

	@Test(priority = 5)
	public void checkDashboard() throws InterruptedException {
		TM.Dashboard().click();
		Thread.sleep(1500);

		String expectedTitle = "Dashboard";

		Assert.assertTrue(TM.checkPage(expectedTitle));
	}

	@Test(priority = 7)
	public void checkUpdates() throws InterruptedException {
		TM.Updates().click();
		Thread.sleep(1500);

		String expectedTitle = "Updates";

		Assert.assertTrue(TM.checkPage(expectedTitle));
	}

	@Test(priority = 9)
	public void checkModules() throws InterruptedException {
		TM.Modules().click();
		Thread.sleep(1500);

		String expectedTitle = "Modules";

		Assert.assertTrue(TM.checkPage(expectedTitle));
	}

	@Test(priority = 11)
	public void checkAddNewTours() throws InterruptedException {
		TM.Tours().click();
		Thread.sleep(1500);
		TM.addNewInTours().click();
		Thread.sleep(1500);

		String expectedTitle = "Add Tour";

		Assert.assertTrue(TM.checkPage(expectedTitle));
	}

	@Test(priority = 13)
	public void checkCars() throws InterruptedException {
		TM.Cars().click();
		Thread.sleep(1500);
		TM.CarsInCars().click();
		Thread.sleep(1000);

		String expectedTitle = "Cars Management";

		Assert.assertTrue(TM.checkPage(expectedTitle));
	}

	@Test(priority = 15)
	public void checkCoupons() throws InterruptedException {
		TM.Coupons().click();
		Thread.sleep(1000);

		String expectedTitle = "Coupon Codes Management";

		Assert.assertTrue(TM.checkPage(expectedTitle));
	}

	@Test(priority = 17)
	public void checkNewsletter() throws InterruptedException {
		TM.Newsletter().click();
		Thread.sleep(1500);

		String expectedTitle = "Newsletter Management";

		Assert.assertTrue(TM.checkPage(expectedTitle));
	}

	@Test(priority = 19)
	public void checkBookings() throws InterruptedException {
		TM.Bookings().click();
		Thread.sleep(1500);

		String expectedTitle = "Booking Management";

		Assert.assertTrue(TM.checkPage(expectedTitle));
	}

}
