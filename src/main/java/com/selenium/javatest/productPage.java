package com.selenium.javatest;
import java.util.Random;
import org.openqa.selenium.By;
public class productPage {
	static String fiyat = null;
	public static void productRandomSelected() {
		try {
			// Random eleman secimi
			Testjava.liste = Testjava.driver.findElements(By.xpath(locators.random_element_selection_listxpath));
			Random rand = new Random();
			int randomSecim = rand.nextInt(Testjava.liste.size());
			Testjava.liste.get(randomSecim).click();
			String secilenElemanad = Testjava.driver.findElement(By.id(locators.info_selected_elementid)).getText();
			System.out.println("Seclien urun:\n" + secilenElemanad + "\n");
		} catch (Exception e) {
			System.out.println("Eleman Secilemedi Hata:" + e.getMessage());
		}
	}
	public static void productaddCard(){
		try {
			fiyat= Testjava.driver.findElement(By.className(locators.product_priceclassName)).getText();
			System.out.println("Fiyat: " + fiyat + "\n");
			Testjava.driver.findElement(By.id(locators.add_to_cardid)).click();
			Thread.sleep(2500);
			Testjava.driver.findElement(By.id(locators.go_to_cardid)).click();
			Thread.sleep(1500);
		} catch (Exception e) {
			System.out.println("Eleman ucreti alinamadi yada sepete eklenemedi: "+e.getMessage());
		}
	}
	public static void productCardPrice(){
		try {
			String sepetFiyat = Testjava.driver.findElement(By.className(locators.price_in_cartclassName)).getText();
			System.out.println("Sepetteki fiyat: " + sepetFiyat + "\n");
			if (fiyat.equals(sepetFiyat)) {
				System.out.println("Urun fiyat ve sepetteki fiyat esit\n");
			} else {
				System.out.println("Urun fiyat ve sepetteki esit degil\n");
			}
			Testjava.driver.findElement(By.className(locators.product_incraseclassName)).click();
			Thread.sleep(1500);
		} catch (Exception e) {
			System.out.println("Sepetteki fiyat alinamadi: "+ e.getMessage());
			}}}
