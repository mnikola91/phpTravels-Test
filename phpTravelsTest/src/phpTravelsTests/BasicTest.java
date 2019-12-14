package phpTravelsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import phpTravelsPages.TravelsLogin;
import phpTravelsUtils.TravelsUtils;

public class BasicTest {

	protected static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterTest
	public void quit() {
		driver.close();
	}
	
	public void loginPhpTravels() throws InterruptedException {
		String homepage = "https://www.phptravels.net/admin";

		TravelsLogin TL = new TravelsLogin(driver);
		driver.get(homepage);
		Thread.sleep(2000);
		driver.manage().window().fullscreen();

		TravelsUtils ex = new TravelsUtils();
		ex.setExcell("..\\phpTravelsTest\\Username.xlsx");
		ex.setWorkSheet(0);

		for (int i = 1; i < ex.getRowNumber(); i++) {

			TL.inputEmail(ex.getDataAt(i, 0));
			TL.inputPassword(ex.getDataAt(i, 1));
		}
		ex.closeExcell();

		TL.loginButton().click();
		Thread.sleep(2000);
	}
}
