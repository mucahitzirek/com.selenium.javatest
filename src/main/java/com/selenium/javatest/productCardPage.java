package com.selenium.javatest;

import org.openqa.selenium.By;

public class productCardPage {
	public static void productDelete() {
		try {
			Testjava.driver.findElement(By.xpath(locators.delete_productxpath)).click();
			String tag = Testjava.driver.findElement(By.xpath(locators.get_product_namexpath)).getText();
			if (tag != null) {
				System.out.println("Urun Silindi.. " + tag);
			} else {
				System.out.println("Urun Silinmedi");
			}
		} catch (Exception e) {
			System.out.println("Urun Silinemedi Hata:" + e.getMessage());
		}
	}
}
