package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchBrowser {
	@Test
	public void myTest() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		String title = driver.getTitle();
		System.out.println(title);
		String title1 =driver.findElement(By.xpath("//h1[text()='Simple Form Demo']")).getText();
		System.out.println(title1);
		WebElement aInput = driver.findElement(By.id("sum1"));
		aInput.sendKeys("10");
		String attribute = aInput.getAttribute("placeholder");
		System.out.println("placeholder value: "+attribute);
		driver.findElement(By.id("sum2")).sendKeys("30");
		driver.findElement(By.xpath("//button[text()='Get Sum']")).click();
		String text = driver.findElement(By.id("addmessage")).getText();
		System.out.println("The provided result is: "+text);
		driver.close();
	}

}
