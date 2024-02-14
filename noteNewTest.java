package Testclass;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class noteNewTest {
	WindowsDriver driver;
@SuppressWarnings("deprecation")
@BeforeClass
public void Start() throws IOException {
	Desktop desk=Desktop.getDesktop();
	desk.open(new File("C:\\\\Program Files (x86)\\\\Windows Application Driver\\\\WinAppDriver.exe"));
	//OPEN NOTEPAD
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability
	("app", "{1AC14E77-02E7-4E5D-B744-2EB1AE5198B7}\\notepad.exe");
	cap.setCapability("platformName", "Windows");
	cap.setCapability("platformVersion", "1.0");
	//RUN WINDOWS DRIVER
	WindowsDriver driver=new WindowsDriver(new URL("http://127.0.0.1:4723"),cap);
	System.out.println(driver.getSessionId());
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@Test
  public void test() {
	//TYPE IN NOTEPAD
	driver.findElement(By.name("Text Editor")).sendKeys("Hello word");
	driver.findElement(By.name("File")).click();
	driver.findElement(By.name("Save")).click();
	//SAVE USING FIRST TEST
	driver.findElement(By.name("File name")).sendKeys("First Test");
	driver.findElement(By.name("Save")).click();
	//RENAME THE FILE
	driver.findElement(By.name("File")).click();
	driver.findElement(By.name("Save As")).click();
	//CLEAR OLD NAME
	WebElement one=driver.findElement(By.name("File name"));
	one.clear();
	//ENTER NEW NAME
	one.sendKeys("First Task");
	//SAVE IT AGAIN
	driver.findElement(By.name("Save")).click();
}
@SuppressWarnings("deprecation")
@org.testng.annotations.AfterClass
public void close() throws IOException {
	Runtime.getRuntime().exec("taskkill /F /IM WinAppDriver.exe");
	
}


}
