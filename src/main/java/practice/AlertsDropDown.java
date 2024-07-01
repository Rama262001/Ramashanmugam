package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class AlertsDropDown {
	@Test
	public void handleAlert() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
		driver.findElement(By.xpath("//p[text()='JavaScript Alerts']//button[text()='Click Me']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		driver.findElement(By.xpath("//p[text()='Confirm box:']//button[text()='Click Me']")).click();
		alert.accept();
		driver.findElement(By.xpath("//p[text()='Prompt box:']//button[text()='Click Me']")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.sendKeys("testing");
		System.out.println("Sent keys to alert1: testing");
		alert1.accept();
		driver.close();
		}

}
