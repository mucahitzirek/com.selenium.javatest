package com.selenium.javatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Testjava {
	public static WebDriver driver;
	public static String loginUrl = "https://www.hepsiburada.com/";
	public static List<WebElement> liste;
	public static int a = 0;

	@Before
	public void Testing() {
		try {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			// Chrome driveri gosterildi(zorunlu)
			System.setProperty("webdriver.chrome.driver", locators.driver_path);
			driver = new ChromeDriver(capabilities);
			// tam ekran
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			// dinamik bekleme suresi
			// Sayfanin yuklenmesi
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			// Bir hata atmadan once sayfa yuklemesinin tamamlanması icin
			// beklenecek sureyi ayarlar.
			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			// Komut dosyasinin yurutmeyi bitirmesi icin beklenecek sureyi
			// ayarlar
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		driver.get(loginUrl);
		loginPage.login(locators.user_nameSendKeys, locators.user_passwordSendKeys);
		try {// arama kutucugunda kulaklik aramasi yapildi
			homePage.homeSearch();
			productPage.productRandomSelected();
			for (a = 1; a < 100; a++) {
				if (!(liste.size() == 0)) {
					a++;
					break;
				} else {
					System.out.println("Eleman secilemedi Ekran goruntusu gecersiz.");
				}
			}
			//Urunun ekran goruntusu alındı.
			screenShot.screenShots();
			Thread.sleep(1500);
			productPage.productaddCard();
			productPage.productCardPrice();
		} catch (Exception e) {
			System.out.println("Hata: " + e);
		}
	}

	@After
	public void tearDown() throws Exception {

	}
}
