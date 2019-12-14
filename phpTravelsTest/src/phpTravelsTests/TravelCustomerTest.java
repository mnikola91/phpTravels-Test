package phpTravelsTests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import phpTravelsPages.TravelCustomer;

public class TravelCustomerTest extends BasicTest {

	@Test
	public void testCustomers() throws InterruptedException {
		BasicTest BT = new BasicTest();
		BT.loginPhpTravels();
		
		TravelCustomer TC = new TravelCustomer(driver);
		TC.accounts().click();
		Thread.sleep(700);
		TC.customers().click();
		Thread.sleep(2000);
		TC.showAllCustomers().click();
		Thread.sleep(2000);
		TC.editCustomer().click();
		Thread.sleep(2000);
		
		TC.fillFirstName("Peter");
		Thread.sleep(700);
		TC.fillLastName("Marks");
		Thread.sleep(700);
		TC.fillEmail("peter.marks@email.com");
		Thread.sleep(700);
		TC.fillMobileNumber("000111222");
		Thread.sleep(700);
		TC.pickCountry("Serbia");
		Thread.sleep(700);
		TC.fillAddress("NewYork");
		Thread.sleep(700);
		TC.pickStatus("Enabled");
		Thread.sleep(700);
		TC.emailSubscribe().click();
		Thread.sleep(1500);
		JavascriptExecutor JSE = (JavascriptExecutor) driver;
		JSE.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		TC.submitButton().click();
		Thread.sleep(1500);
		
		TC.searchButton().click();
		Thread.sleep(1500);
		TC.inputSearchTerm().sendKeys("peter.marks@email.com");
		Thread.sleep(1500);
		TC.goButton().click();
		Thread.sleep(1500);
		
		Assert.assertTrue(TC.checkIfCustomerIsAdded("peter.marks@email.com"));
	}
	
}
