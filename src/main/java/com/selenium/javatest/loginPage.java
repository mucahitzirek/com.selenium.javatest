package com.selenium.javatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginPage {
	public static void login(String user_name,String user_password){
		try {
			System.out.println(Testjava.driver.getTitle());
			// Anasayfada dropdown acilarak login'e tiklandi
			WebElement myAccount = Testjava.driver.findElement(By.id(locators.accountid));
			myAccount.click();
			Thread.sleep(2500);
			WebElement myLogin = Testjava.driver.findElement(By.id(locators.loginid));
			myLogin.click();
			System.out.println(Testjava.driver.getTitle());
			Thread.sleep(2500);
			// Kullanıcı bilgileri girilerek giris yapildi
			Testjava.driver.findElement(By.name("username")).sendKeys(user_name);
			Testjava.driver.findElement(By.name("password")).sendKeys(user_password);
			Testjava.driver.findElement(By.name("btnLogin")).click();
			Thread.sleep(2500);
			System.out.println(Testjava.driver.getTitle());
		} catch (Exception e) {
			System.out.println(Testjava.driver.getTitle() + " " + "Login islemi gerceklestirilemedi: " + e.getMessage());
		}
	}

}
