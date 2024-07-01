package windowAndFrames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingFrames {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/frame");
		driver.switchTo().frame("firstFr");
		driver.findElement(By.name("fname")).sendKeys("Rama");
		driver.findElement(By.name("lname")).sendKeys("Shanmuga Sundaram");
		WebElement frames = driver.findElement(By.xpath("//iframe[@src='innerFrame']"));
		driver.switchTo().frame(frames);
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("abc@gmail.com");
		driver.close();
		
		
		
	}

}
