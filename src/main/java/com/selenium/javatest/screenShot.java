package com.selenium.javatest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class screenShot {
	public static void screenShots(){
		try {
			File source = ((TakesScreenshot) Testjava.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(locators.screenshot_path + Testjava.a + ".png"));
		} catch (IOException e) {
			System.out.println("Ekran goruntusu alinamadi: " + e.getMessage());
		}
	}
}
