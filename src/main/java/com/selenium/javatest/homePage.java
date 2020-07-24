package com.selenium.javatest;

import org.openqa.selenium.By;

public class homePage {
  public static void homeSearch() throws InterruptedException{
		Testjava.driver.findElement(By.className(locators.search_homeclassName)).sendKeys("kulaklik");
		Testjava.driver.findElement(By.className(locators.search_home_btn_clickclassName)).click();
		Thread.sleep(2500);
  }
}
