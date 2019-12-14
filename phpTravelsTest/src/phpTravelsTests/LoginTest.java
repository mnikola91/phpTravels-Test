package phpTravelsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import phpTravelsPages.LogoutPage;

public class LoginTest extends BasicTest {
	
	@Test
	public void testCheckLogin() throws InterruptedException {
		BasicTest BT = new BasicTest();
		BT.loginPhpTravels();

		String logoutText = "Logout";
		LogoutPage LP = new LogoutPage(driver);
		Assert.assertEquals(LP.logoutButton().getText(), logoutText);
	}
}
