package popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HandleAuthenticationPopup {
	@Test
	public void handleAuth() {
		String username = "admin";
		String password = "admin";
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		String text = driver.findElement(By.cssSelector("div.example>p")).getText();
		System.out.println(text);
		String expected = "Congratulations! You must have the proper credentials.";
		Assert.assertEquals(text.trim(), expected);
		
		try {
			Thread.sleep(5000);
			}catch (InterruptedException e) {
				e.printStackTrace();
				}
		driver.quit();
		
		
	}

}
