package login;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Logintest {
	@Test
	public void myTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		//Correct Username and Password
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("student");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id = 'submit']")).click();
		Thread.sleep(2000);
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.contains("practicetestautomation.com/logged-in-successfully/"), "URL does not contain the expected string.");
		String textmessage = driver.findElement(By.xpath("//strong[text()='Congratulations student. You successfully logged in!']")).getText();
		System.out.println("The success message: "+textmessage);
		WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log out']"));
		assertTrue(logoutButton.isDisplayed(), "Log out button is not displayed.");
		
		//Invalid Username and Correct Password
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("incorectUser");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id = 'submit']")).click();
		String errormessage = driver.findElement(By.xpath("//div[text() ='Your username is invalid!']")).getText();
		System.out.println("The issue here: "+errormessage);
		Thread.sleep(2000);
		
		//Correct Username and Invalid Password
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("student");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("incorrectPassword");
		driver.findElement(By.xpath("//button[@id = 'submit']")).click();
		String errormessage1 = driver.findElement(By.xpath("//div[text() ='Your password is invalid!']")).getText();
		System.out.println("The issue here are: "+errormessage1);
		 Assert.assertEquals(errormessage1, "Your password is invalid!", "Error message does not match the expected value.");
		Thread.sleep(2000);
		driver.quit();
		
	}

}
